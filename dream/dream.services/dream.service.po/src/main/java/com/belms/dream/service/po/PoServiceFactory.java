package com.belms.dream.service.po;

import com.belms.dream.api.service.LookupService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceFactory;
import com.blems.dream.api.model.BasedModel;

public class PoServiceFactory  implements ServiceFactory{

	public static final String ID = "PO_SERVICE";
	
	public String getId() {
		return ID;
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
