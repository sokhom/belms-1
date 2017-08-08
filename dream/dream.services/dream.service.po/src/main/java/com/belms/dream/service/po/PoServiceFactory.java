package com.belms.dream.service.po;

import com.belms.dream.api.service.AbstractServiceFactory;
import com.belms.dream.api.service.LookupService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceFactory;
import com.belms.dream.api.service.ServiceIds;
import com.blems.dream.api.model.BasedModel;

public class PoServiceFactory  extends AbstractServiceFactory implements ServiceFactory{
	
	public String getId() {
		return ServiceIds.PO_SERVICE_ID;
	}


	@SuppressWarnings("unchecked")
	public <E, T extends BasedModel> LookupService<E, T> getLookupService() {
		return (LookupService<E, T>) new PoLookupService();
	}


	@SuppressWarnings("unchecked")
	public <T extends BasedModel> ProcessingService<T> getService() {
		return (ProcessingService<T>) new PoProcessingService();
	}

}
