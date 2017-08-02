package com.blems.dream.api.repo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public interface SqlSessionFactoryMngt {
	SqlSessionFactory getSessionFactory();
	SqlSession newSession();
}
