package com.blems.dream.api.repo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface SqlSessionFactoryMngt {
	SqlSessionFactory getSessionFactory();
	SqlSession newSession();
	SessionFactory getHibernateSessionFactory();
	Session getSession();
}
