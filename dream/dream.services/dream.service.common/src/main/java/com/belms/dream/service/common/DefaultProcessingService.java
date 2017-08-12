package com.belms.dream.service.common;

import java.util.List;

import com.belms.dream.api.service.AbstractProcessService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.action.Action;
import com.belms.dream.api.service.security.Authorize;
import com.belms.dream.repository.common.DefaultRepo;
import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.ObjectMapper;
import com.blems.dream.api.model.Repo;

public class DefaultProcessingService<T extends BasedModel> extends AbstractProcessService<T>  implements ProcessingService<T> {

	private  Repo<T> defaultRepo ;
	
	public DefaultProcessingService(Repo<T> repo) {
		defaultRepo = repo;
	}
	
	public <E extends ObjectMapper<T>>  DefaultProcessingService(Class<E> mapperClass) {
		 defaultRepo = new DefaultRepo<T>(()-> ServiceProvider.newSession(),sqlSession ->sqlSession.getMapper(mapperClass)) ;
	}

	@Override
	protected Repo<T> getRepo() {
		return defaultRepo;
	}

	@Override
	public ProcessingService<T> setAction(Action action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Action> getValidActions(T object, Authorize authorize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
