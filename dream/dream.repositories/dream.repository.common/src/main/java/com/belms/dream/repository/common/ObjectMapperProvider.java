package com.belms.dream.repository.common;

import org.apache.ibatis.session.SqlSession;

import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.ObjectMapper;

public interface ObjectMapperProvider<T extends BasedModel> {
	ObjectMapper<T> getMapper(SqlSession sqlSession);
}



