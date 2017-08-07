package com.belms.dream.service.common.setup;

import com.belms.dream.api.service.LookupService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceFactory;
import com.belms.dream.api.service.setup.SetupService;
import com.blems.dream.api.model.BasedModel;

public class SetupServiceFactory implements ServiceFactory {

	public String getId() {
		return SetupService.ID;
	}

	

	public <E, T extends BasedModel> LookupService<E, T> getLookupService() {
		return null;
	}


	public <T extends BasedModel> ProcessingService<T> getService() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
