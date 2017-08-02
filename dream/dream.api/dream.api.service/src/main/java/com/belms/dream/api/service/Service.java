/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.api.service;

import org.apache.ibatis.session.SqlSession;

public interface Service<T> {
	void setSqlSession(SqlSession sqlSession);
}
