package com.belms.dream.service.po;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.belms.dream.api.service.AbstractProcessService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.action.Action;
import com.belms.dream.api.service.security.Authorize;
import com.belms.dream.repository.po.PoRepo;
import com.blems.dream.api.model.Repo;
import com.blems.dream.api.model.po.Po;

public class PoProcessingService  extends AbstractProcessService<Po> implements ProcessingService<Po> {

	private PoRepo poRepo;
	private static final String ADD="PO.ADD";
	
	private static final String EDIT = "PO.EDIT";
	private static final String EDIT_ITEM = "PO.EDIT.ITEM";
	private static final String VOID="PO.VOID";
	private static final String DELETE_ITEM = "PO.DELETE.ITEM";
	private static final String CLOSE_SHORT = "PO.CLOSE.SHORT";
	
	
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
	public List<Action> getValidActions(Po object, Authorize authorize) {
		
		
		Po po =getRepo().getById(object.getId());
		
	
		return null;
	}

	@Override
	public ProcessingService<Po> setAction(Action action) {
		setProcessAction(action);
		return this;
	}

	

}
