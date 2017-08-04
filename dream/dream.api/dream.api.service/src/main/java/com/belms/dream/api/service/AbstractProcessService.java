package com.belms.dream.api.service;

import org.apache.ibatis.session.SqlSession;

import com.blems.dream.api.model.BasedModel;

public abstract class AbstractProcessService<T> {
	
	private SqlSession sqlSession = null;
	
	@SuppressWarnings("unchecked")
	public void process(BasedModel object) {
		sqlSession = ServiceProvider.newSession();
		try {
			takeAction((T) object);
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
		}finally {
			sqlSession.close();
			sqlSession = null;
		}
		
	}
	
	
	protected SqlSession getSqlSession() {
		return sqlSession;
	}
	
	protected abstract void takeAction(T t);

}
