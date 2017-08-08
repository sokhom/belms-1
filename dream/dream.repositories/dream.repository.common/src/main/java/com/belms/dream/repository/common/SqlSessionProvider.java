package com.belms.dream.repository.common;

import org.apache.ibatis.session.SqlSession;

public interface SqlSessionProvider {
	SqlSession newSession();
}
