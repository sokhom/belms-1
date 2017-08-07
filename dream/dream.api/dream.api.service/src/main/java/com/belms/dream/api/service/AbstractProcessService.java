package com.belms.dream.api.service;

import org.apache.ibatis.session.SqlSession;

import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.Repo;

public abstract class AbstractProcessService<T extends BasedModel> {

	private SqlSession sqlSession = null;

	public void process(T object) {
		
		sqlSession = ServiceProvider.newSession();
		try {
			takeAction((T) object);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		} finally {
			sqlSession.close();
			sqlSession = null;
		}

	}

	protected abstract Repo<T> getRepo();
	
	
	
	/**
	 * 
	 * @param serviceId : specify for general services
	 * @return
	 */

	protected SqlSession getSqlSession() {
		return sqlSession;
	}
	
	protected void takeAction(T t) {
				
		
		Repo<T> repo =  getRepo() ;
		
		
		if (BasedModel.OPER.ADD == t.getOper()) {
			repo.add(t);
		} else if (BasedModel.OPER.EDIT == t.getOper()) {
			repo.edit(t);
		} else if (BasedModel.OPER.DELETE == t.getOper()) {
			repo.remove(t);
		}
	}

}
