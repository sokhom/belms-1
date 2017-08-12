package com.belms.dream.service.endpoint;

import org.apache.ibatis.session.SqlSession;

import com.belms.dream.api.service.ServiceProvider;

public class Test {
	
	public static void main(String[] args) {
		SqlSession session = ServiceProvider.newSession();
		
		if(session!=null) {
			session.close();
		}
		
		System.out.println(session);
	}

}
