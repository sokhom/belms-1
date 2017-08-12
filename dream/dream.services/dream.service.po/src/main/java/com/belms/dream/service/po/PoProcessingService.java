package com.belms.dream.service.po;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.belms.dream.api.service.AbstractProcessService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceIds;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.action.Action;
import com.belms.dream.api.service.action.DefaultAction;
import com.belms.dream.api.service.security.Authorize;
import com.belms.dream.repository.po.PoRepo;
import com.blems.dream.api.model.BasedModel.OPER;
import com.blems.dream.api.model.Repo;
import com.blems.dream.api.model.po.Po;
import com.blems.dream.api.model.po.PoItem;

public class PoProcessingService extends AbstractProcessService<Po> implements ProcessingService<Po> {

	private PoRepo poRepo;
	public static final String AUTHORIZED_ADD = "PO.ADD";
	private static final String AUTHORIZED_ISSUED = "PO.ISSUE";
	private static final String AUTHORIZED_UNISSUE = "PO.UNISSUE";
	private static final String AUTHORIZED_EDIT = "PO.EDIT";
	private static final String AUTHORIZED_EDIT_ITEM = "PO.EDIT.ITEM";
	private static final String AUTHORIZED_VOID = "PO.VOID";
	private static final String AUTHORIZED_DELETE_ITEM = "PO.DELETE.ITEM";
	private static final String AUTHORIZED_CLOSE_SHORT = "PO.CLOSE.SHORT";

	private static final Action SAVE_ACTION = new DefaultAction("PO.SAVE", ServiceIds.PO_SERVICE_ID, "Save");
	private static final Action ISSUE_ACTION = new DefaultAction("PO.ISSUE", ServiceIds.PO_SERVICE_ID, "Save");
	private static final Action UNISSUE_ACTION = new DefaultAction("PO.UNISSUE", ServiceIds.PO_SERVICE_ID, "Unissue");


	public PoProcessingService() {
		poRepo = new PoRepo(() -> ServiceProvider.newSession(), true);
	}

	@Override
	protected Repo<Po> getRepo() {
		return poRepo;
	}

	@Override
	public void process(Po object) {

		if (getAction() == null) {
			setAction(SAVE_ACTION);
		}
		SqlSession session = getRepo().getSqlSession();
		try {
			if(object.getStatus()==null ) {
				object.setStatus(Po.STATUS_BID_REQUEST);
				
				for (PoItem item: object.getItems()) {
					if(OPER.ADD == item.getOper()) {
						item.setStatus(PoItem.STATUS_ITEM_ENTERED);
					}
				}
				
			}
			super.process(object);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	protected boolean isValid() {
		
		if(SAVE_ACTION.equals(getAction())) {
			if(Po.STATUS_FULFILLED.equals(this.getObject().getStatus()) || Po.STATUS_VOID.equals(this.getObject().getStatus())) {
				throw new RuntimeException(String.format("Save operation is denied when Po status is", getObject().getStatus().getName()));
			}
		}
		
		return true;
	}

	@Override
	public List<Action> getValidActions(Po object, Authorize authorize) {
		List<Action> actions = new ArrayList<>();
		// New
		if (object == null ) {
			if (authorize.check(AUTHORIZED_ADD)) {
				actions.add(SAVE_ACTION);
			}

			if (authorize.check(AUTHORIZED_ISSUED)) {
				actions.add(ISSUE_ACTION);
			}
		} else {
			Po po = getRepo().getById(object.getId());
			if (Po.STATUS_BID_REQUEST.equals(po.getStatus())) {
				actions.add(ISSUE_ACTION);
			} else if (Po.STATUS_ISSUED.equals(po.getStatus())) {
				actions.add(ISSUE_ACTION);
			}
		}

		setAuthrizeToActions(actions, authorize);
		return actions;
	}

	@Override
	public ProcessingService<Po> setAction(Action action) {
		setProcessAction(action);
		return this;
	}

}
