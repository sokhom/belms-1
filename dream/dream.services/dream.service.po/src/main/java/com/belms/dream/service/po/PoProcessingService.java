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
import com.blems.dream.api.model.Repo;
import com.blems.dream.api.model.common.ObjectStatus;
import com.blems.dream.api.model.po.Po;

public class PoProcessingService  extends AbstractProcessService<Po> implements ProcessingService<Po> {

	private PoRepo poRepo;
	public static final String ADD="PO.ADD";
	private static final String ISSUE="PO.ISSUE";
	private static final String UNISSUE="PO.UNISSUE";
	private static final String EDIT = "PO.EDIT";
	private static final String EDIT_ITEM = "PO.EDIT.ITEM";
	private static final String VOID="PO.VOID";
	private static final String DELETE_ITEM = "PO.DELETE.ITEM";
	private static final String CLOSE_SHORT = "PO.CLOSE.SHORT";
	
	private static final Action SAVE_ACTION = new DefaultAction("PO.SAVE", ServiceIds.PO_SERVICE_ID, "Save");
	private static final Action ISSUE_ACTION = new DefaultAction("PO.ISSUE", ServiceIds.PO_SERVICE_ID, "Save");
	private static final Action UNISSUE_ACTION = new DefaultAction("PO.UNISSUE", ServiceIds.PO_SERVICE_ID, "Unissue");
	
	
	private static final int STATUS_BID_REQUEST = 10;
	private static final int STATUS_ISSUE = 20;
	private static final int STATUS_PICKING = 30;
	private static final int STATUS_PARTIAL = 40;
	private static final int STATUS_PICKED = 50;
	private static final int STATUS_SHIPPED = 60;
	private static final int STATUS_FULFILLED = 70;
	private static final int STATUS_CLOSED_SHORT = 80;
	private static final int STATUS_VOID = 90;
	
	
	public PoProcessingService() {
		poRepo = new PoRepo(()->ServiceProvider.newSession(),true);
	}
	
	@Override
	protected Repo<Po> getRepo() {
		return  poRepo;
	}

	@Override
	public void process(Po object) {
		SqlSession session = getRepo().getSqlSession();
		try {
		super.process(object);
		session.commit();
		}catch (Exception e) {
			session.rollback();
		}finally {
			session.close();
		}
	}


	@Override
	protected boolean isValid() {
		return super.isValid();
	}

	@Override
	public List<Action> getValidActions(Po object, Authorize authorize) {
		List<Action> actions = new ArrayList<>();
		//New
		if(object==null) {
			if(authorize.check(ADD)) {
				actions.add(SAVE_ACTION);
			}
			
			if(authorize.check(ISSUE)) {
				actions.add(ISSUE_ACTION);
			}
		}else {
			Po po =getRepo().getById(object.getId());
			if(po.getStatus().getId()==STATUS_BID_REQUEST) {
				actions.add(ISSUE_ACTION);
			}else if(po.getStatus().getId()==STATUS_ISSUE) {
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
