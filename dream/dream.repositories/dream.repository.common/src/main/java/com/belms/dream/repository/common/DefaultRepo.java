package com.belms.dream.repository.common;

import com.blems.dream.api.model.BasedModel;

public class DefaultRepo<T extends BasedModel> extends AbstractRepo<T> {

	public DefaultRepo(SqlSessionProvider sqlSessionProvider, ObjectMapperProvider<T> mapperProvider) {
		super(sqlSessionProvider, mapperProvider);
	}

}
