package com.belms.dream.repository.common;

import java.io.FileReader;
import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.blems.dream.api.repo.SqlSessionFactoryMngt;

public class SqlSessionFactoryMngtImpl implements SqlSessionFactoryMngt {

	private SqlSessionFactory sessionFactory;
	private String resource = "D:/dev/Java/config/repositories/employee/persistence/configuration.xml";

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

}
