package com.belms.dream.service.common.setup;

import com.belms.dream.api.service.Service;
import com.belms.dream.api.service.ServiceFactory;
import com.belms.dream.api.service.setup.SetupService;

public class SetupServiceFactory implements ServiceFactory {

	public String getId() {
		return SetupService.ID;
	}

	public Service<?> getService() {
		return new SetupServiceImpl();
	}

}
