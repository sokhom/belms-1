package com.belms.dream.api.service;

import org.apache.ibatis.session.SqlSession;

import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.Repo;

public abstract class AbstractProcessService<T extends BasedModel> {
	public void process(T object) {
		Repo<T> repo =  getRepo() ;
		if (BasedModel.OPER.ADD == object.getOper()) {
			repo.add(object);
		} else if (BasedModel.OPER.EDIT == object.getOper()) {
			repo.edit(object);
		} else if (BasedModel.OPER.DELETE == object.getOper()) {
			repo.remove(object);
		}
	}

	protected abstract Repo<T> getRepo();
	
	/**
	 * 
	 * @param serviceId : specify for general services
	 * @return
	 */

	protected SqlSession getSqlSession() {
		return getRepo().getSqlSession();
	}

}
