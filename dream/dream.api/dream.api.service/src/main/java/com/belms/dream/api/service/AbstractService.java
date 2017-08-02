package com.belms.dream.api.service;

import org.apache.ibatis.session.SqlSession;

public abstract class AbstractService {
	
	private SqlSession session;
	
	
	protected SqlSession getSqlSession() {
		
		if(session==null) {
			session = ServiceProvider.newSession();
		}
		return session;
	}
	

	public void setSqlSession(SqlSession sqlSession) {
		this.session= sqlSession;
	}
	
}
