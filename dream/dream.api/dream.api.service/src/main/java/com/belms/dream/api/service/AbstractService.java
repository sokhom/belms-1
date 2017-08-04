package com.belms.dream.api.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.Repo;

public abstract class AbstractService<T extends BasedModel> {
	
	private SqlSession session;
	
	protected abstract Repo<T> getRepo();
	
	protected SqlSession getSqlSession() {
		
		if(session==null) {
			session = ServiceProvider.newSession();
		}
		return session;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.session= sqlSession;
	}
	
	public T add(T t) {
		return getRepo().add(t);
	}

	public void remove(T t) {
		getRepo().remove(t);
	}

	public void edit(T t) {
		getRepo().edit(t);
	}

	public T getById(int id) {
		return getRepo().getById(id);
	}

	public List<T> getAll() {
		return getRepo().getAll();
	}
}
