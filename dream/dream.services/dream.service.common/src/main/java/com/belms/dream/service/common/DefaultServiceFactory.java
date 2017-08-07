package com.belms.dream.service.common;

import com.belms.dream.api.service.LookupService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceFactory;
import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.vendor.Vendor;

public class DefaultServiceFactory implements ServiceFactory {

	public static final String ID = "DEFAULT_SERVICE";

	public String getId() {
		return ID;
	}

	public <T extends BasedModel> ProcessingService<T> getService() {
	
		return new TestType<T>();

	}

	public <E, T extends BasedModel> LookupService<E, T> getLookupService() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		ServiceFactory factory = new DefaultServiceFactory();

		ProcessingService<Vendor> processingService = factory.getService();
		processingService.process(new Vendor());
	}

	public class TestType<T> implements  ProcessingService<T>{

		public void process(T object) {
			System.out.println(object.getClass());
			//new DefaultProcessingService<Vendor>(VendorMapper.class);
			
		}
		
	}
	
}
