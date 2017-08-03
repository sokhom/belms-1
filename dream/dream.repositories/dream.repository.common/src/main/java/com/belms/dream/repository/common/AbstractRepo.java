/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.repository.common;

import org.apache.ibatis.session.SqlSession;

import com.belms.dream.repository.common.mapper.ObjectMapper;
import com.blems.dream.api.model.BasedModel;

public abstract class AbstractRepo<T extends BasedModel> implements Repo<T> {
	
	private final SqlSession session;
	private  ObjectMapper<T> objectMapper;
	
	public AbstractRepo(SqlSession session) {
		this.session = session;
	}
	
	public AbstractRepo(SqlSession session,ObjectMapper<T> objectMapper) {
		this(session);
		this.objectMapper = objectMapper;
	}
	
	public T getById(int id) {
		
		return null;
	}
	
	public T add(T t) {
		try {
			getObjectMapper().insert(t);
			getSqlSession().commit();
		}catch (Exception e) {
			System.err.println(e);
			getSqlSession().rollback();
		}finally {
			getSqlSession().close();
		}
		return t;
	}

	public void remove(T t) {
		// TODO Auto-generated method stub
		
	}

	public T edit(T t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	protected SqlSession getSqlSession() {
		return session;
	}

	
	protected void flush() {
		getSqlSession().flushStatements();
	}
	
	
	protected void commit() {
		getSqlSession().commit();
	}
	
	protected void close() {
		getSqlSession().close();
	}
	

	private ObjectMapper<T> getObjectMapper(){
		if(this.objectMapper == null) {
			throw new RuntimeException("No object mapper provided");
		}
		return this.objectMapper;
	}
	
	protected void setObjectMapper( ObjectMapper<T> objectMapper) {
		this.objectMapper = objectMapper;
	}

}
