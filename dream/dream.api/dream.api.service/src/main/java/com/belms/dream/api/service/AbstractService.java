package com.belms.dream.api.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.Repo;

public abstract class AbstractService<T extends BasedModel> {
	

	protected SqlSession sqlSession ;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		
	}
	
	
	
	protected abstract Repo<T> getRepo();
	
	
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
