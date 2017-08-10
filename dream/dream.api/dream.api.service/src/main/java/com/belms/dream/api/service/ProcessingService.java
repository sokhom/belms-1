package com.belms.dream.api.service;

import java.util.List;

import com.belms.dream.api.service.action.Action;
import com.belms.dream.api.service.security.Authorize;

public interface ProcessingService<T> {
	 void process(T object);
	 ProcessingService<T> setAction(Action action);
	 List<Action> getValidActions(T object,Authorize authorize);
}
