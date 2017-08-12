package com.belms.dream.repository.common;

import java.io.FileReader;
import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.blems.dream.api.repo.SqlSessionFactoryMngt;

public class SqlSessionFactoryMngtImpl implements SqlSessionFactoryMngt {

	private SqlSessionFactory sessionFactory;
	private String resource = "E:\\dev\\resources\\projectconfig\\config\\repositories\\configuration.xml";

	public SqlSessionFactory getSessionFactory() {

		if (sessionFactory == null) {

			try {
				FileReader fileReader = new FileReader(resource);
				sessionFactory = new SqlSessionFactoryBuilder().build(fileReader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return sessionFactory;
	}

	public SqlSession newSession() {
		return getSessionFactory().openSession();
	}

	@Override
	public SessionFactory getHibernateSessionFactory() {
		return null;
	}

	@Override
	public Session getSession() {
		return null;
	}

}
