/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.repository.common;

import org.apache.ibatis.session.SqlSession;

public abstract class AbstractRepo<T> implements Repo<T> {
	
	private final SqlSession session;
	
	public AbstractRepo(SqlSession session) {
		this.session = session;
	}
	
	
	public T getById(int id) {
		
		return null;
	}
	
	public T add(T t) {
		// TODO Auto-generated method stub
		return null;
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
	


}
