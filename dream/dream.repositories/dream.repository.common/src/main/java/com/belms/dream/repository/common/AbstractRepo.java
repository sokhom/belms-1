/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.repository.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.ObjectMapper;
import com.blems.dream.api.model.Repo;

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
		
		try {
			return getObjectMapper().selectById(id);
		}catch (Exception e) {
			System.err.println(e);
		}finally{
			getSqlSession().close();
		}
		
		return null;
	}
	
	
	public List<T> getAll() {
		try {
			return getObjectMapper().selectAll();
		}catch (Exception e) {
			System.err.println(e);
		}finally{
			getSqlSession().close();
		}
		
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
		try {
			getObjectMapper().remove(t);
			getSqlSession().commit();
		}catch (Exception e) {
			getSqlSession().rollback();
		}finally{
			getSqlSession().close();
		}
			
	}

	public T edit(T t) {
		try {
			getObjectMapper().update(t);
			getSqlSession().commit();
		}catch (Exception e) {
			getSqlSession().rollback();
		}finally{
			getSqlSession().close();
		}
		return t;
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
	

	public List<T> search(String value) {
		return null;
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
