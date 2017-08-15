package com.belms.dream.api.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.belms.dream.api.service.action.Action;
import com.belms.dream.api.service.security.Authorize;
import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.Repo;

public abstract class AbstractProcessService<T extends BasedModel> {

	private Action action;

	private T object;
	
	public void process(T object) {
		this.object = object;

		if (isValid()) {
			if (BasedModel.OPER.ADD == object.getOper()) {
				add(object);
			} else if (BasedModel.OPER.EDIT == object.getOper()) {
				edit(object);
			} else if (BasedModel.OPER.DELETE == object.getOper()) {
				remove(object);
			}
		}

		setProcessAction(null);

	}

	protected void add(T object) {
		if (BasedModel.OPER.ADD == object.getOper()) {
			getRepo().add(object);
		}
	}

	protected void edit(T object) {
		if (BasedModel.OPER.EDIT == object.getOper()) {
			getRepo().edit(object);
		}
	}

	protected void remove(T object) {
		if (BasedModel.OPER.DELETE == object.getOper()) {
			getRepo().remove(object);
		}
	}

	protected void setProcessAction(Action action) {
		this.action = action;
	}

	protected Action getAction() {
		return action;
	}

	protected void setAuthrizeToActions(List<Action> actions, Authorize authorize) {
		for (Action action : actions) {
			action.setAuthorize(authorize);
		}
	}

	protected abstract Repo<T> getRepo();

	/**
	 * 
	 * @param serviceId
	 *            : specify for general services
	 * @return
	 */

	protected boolean isValid() {
		
		return false;
	}
	
	protected SqlSession getSqlSession() {
		return getRepo().getSqlSession();
	}

	public T getObject() {
		return object;
	}
	
}
