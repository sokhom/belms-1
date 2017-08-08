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
	
	private SqlSession session;
	private final SqlSessionProvider sqlSessionProvider;
	private ObjectMapperProvider<T> mapperProvider;
	private  ObjectMapper<T> objectMapper;
	private boolean manualTran;
	
	public AbstractRepo(SqlSessionProvider sqlSessionProvider) {
		this(sqlSessionProvider, null, false);
	}
	
	public AbstractRepo(SqlSessionProvider sqlSessionProvider, ObjectMapperProvider<T> mapperProvider){
		this(sqlSessionProvider, mapperProvider, false);
	}
	
	public AbstractRepo(SqlSessionProvider sqlSessionProvider, ObjectMapperProvider<T> mapperProvider, boolean manualTran) {
		this.sqlSessionProvider = sqlSessionProvider;
		this.mapperProvider = mapperProvider;
		this.manualTran = manualTran;
	}
	

	public T getById(int id) {
		try {
			return getObjectMapper().selectById(id);
			
		}catch (Exception e) {
			System.err.println(e);
		}finally{
			close();
		}
		
		return null;
	}
	
	
	public List<T> getAll() {
		try {
			getObjectMapper().selectAll();
		}catch (Exception e) {
			System.err.println(e);
		}finally{
			close();
		}
		
		return null;
	}

	public T add(T t) {
		try {
			getObjectMapper().insert(t);
			commit();
		}catch (Exception e) {
			System.err.println(e);
			rollback();
		}finally {
			close();
		}
		return t;
	}

	public void remove(T t) {
		try {
			getObjectMapper().remove(t);
			commit();
		}catch (Exception e) {
			rollback();
		}finally{
			getSqlSession().close();
		}
			
	}

	public T edit(T t) {
		try {
			getObjectMapper().update(t);
			commit();
		}catch (Exception e) {
			rollback();
		}finally{
			close();
		}
		return t;
	}
	
	@Override
	public SqlSession getSqlSession() {
		if(session == null) {
			session = sqlSessionProvider.newSession();
		}
		return session;
	}

	protected void setObjectMapperProvider(ObjectMapperProvider<T> mapperProvider) {
		this.mapperProvider = mapperProvider;
	}
	
	protected ObjectMapper<T> getMapper(){
		if(objectMapper==null) {
			objectMapper = mapperProvider.getMapper(getSqlSession());
		}
		return objectMapper;
	}
	
	protected void flush() {
		if(manualTran) return;
		getSqlSession().flushStatements();
	}
	
	
	protected void commit() {
		if(manualTran) return;
		getSqlSession().commit();
	}
	
	protected void close() {
		if(manualTran) return;
		getSqlSession().close();
	}
	
	
	protected void rollback() {
		if(manualTran) return;
		getSqlSession().rollback();
	}

	public List<T> search(String value) {
		return null;
	}

	private ObjectMapper<T> getObjectMapper(){
		if(this.objectMapper == null) {
			if(this.mapperProvider!=null) {
				 this.objectMapper = this.mapperProvider.getMapper(getSqlSession());
			}else {
				throw new RuntimeException("No object mapper provided");
			}
		}
		return this.objectMapper;
	}
	
	public void setObjectMapper( ObjectMapper<T> objectMapper) {
		this.objectMapper = objectMapper;
	}
	
	public <E extends ObjectMapper<T>> void setMapperClass(Class<E> mapperClass){
		this.objectMapper = getSqlSession().getMapper(mapperClass);
	 }
	

}
