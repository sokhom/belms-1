package com.belms.dream.service.common;

import com.belms.dream.api.service.AbstractLookupServcie;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.repository.common.DefaultRepo;
import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.ObjectMapper;
import com.blems.dream.api.model.Repo;

public class DefaultLookupService<E, T extends BasedModel>  extends AbstractLookupServcie<E, T>  {

private  Repo<T> defaultRepo ;
	
	public DefaultLookupService(Repo<T> repo) {
		defaultRepo = repo;
	}
	
	public <M extends ObjectMapper<T>>  DefaultLookupService(Class<M> mapperClass) {
		 defaultRepo = new DefaultRepo<T>(()-> ServiceProvider.newSession(),sqlSession ->sqlSession.getMapper(mapperClass)) ;
	}

	@Override
	protected Repo<T> getRepo() {
		return defaultRepo;
	}

	
	

}
