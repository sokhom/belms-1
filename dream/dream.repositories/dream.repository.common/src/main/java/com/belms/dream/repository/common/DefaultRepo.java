package com.belms.dream.repository.common;

import org.apache.ibatis.session.SqlSession;

import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.ObjectMapper;

public class DefaultRepo<T extends BasedModel> extends AbstractRepo<T> {

	public <E extends ObjectMapper<T>> DefaultRepo(SqlSession session, Class<E> mapper) {
		
		super(session, mapper);
	}
	
	
	


}
