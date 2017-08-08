/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public interface Repo<T extends BasedModel> {
	T add(T t);
	void remove(T t);
	T edit(T t);
	List<T> getAll();
	T getById(int id); 
	List<T> search(String value);
	SqlSession getSqlSession();
}
