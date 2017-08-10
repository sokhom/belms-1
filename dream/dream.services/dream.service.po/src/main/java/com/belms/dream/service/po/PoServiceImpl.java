package com.belms.dream.service.po;

import org.apache.ibatis.session.SqlSession;

import com.belms.dream.api.service.AbstractService;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.po.PoService;
import com.belms.dream.repository.po.PoRepo;
import com.blems.dream.api.model.Repo;
import com.blems.dream.api.model.po.Po;

public class PoServiceImpl extends AbstractService<Po> implements PoService {

	private PoRepo poRepo;
	
	public PoServiceImpl() {
		poRepo = new PoRepo(()->ServiceProvider.newSession(),true);
	}
	
	@Override
	protected Repo<Po> getRepo() {
		return poRepo;
	}

	@Override
	public Po add(Po t) {
		SqlSession  session = getRepo().getSqlSession();
		try {
			super.add(t);
			session.commit();
			return t;
		}catch (Exception e) {
			session.rollback();
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
		
	}

	

	

	
	
	
}
