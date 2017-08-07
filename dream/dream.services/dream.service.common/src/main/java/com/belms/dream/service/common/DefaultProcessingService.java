package com.belms.dream.service.common;

import com.belms.dream.api.service.AbstractProcessService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.repository.common.DefaultRepo;
import com.belms.dream.repository.common.mapper.VendorMapper;
import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.ObjectMapper;
import com.blems.dream.api.model.Repo;
import com.blems.dream.api.model.vendor.Vendor;

public class DefaultProcessingService<T extends BasedModel> extends AbstractProcessService<T>  implements ProcessingService<T> {

	private DefaultRepo<T> defaultRepo ;
	
	public <E extends ObjectMapper<T>>  DefaultProcessingService(Class<E> mapper) {
		 defaultRepo = new DefaultRepo<T>(ServiceProvider.newSession(), mapper);
	}

	@Override
	protected Repo<T> getRepo() {
		return defaultRepo;
	}



	
	public static void main(String[] args) {
		ProcessingService<Vendor> processingService = new DefaultProcessingService<Vendor>(VendorMapper.class);
		processingService.process(null);
		
	}

	

}
