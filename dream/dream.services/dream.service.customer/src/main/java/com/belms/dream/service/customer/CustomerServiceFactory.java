/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.service.customer;

import com.belms.dream.api.service.LookupService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceFactory;
import com.blems.dream.api.model.BasedModel;

public class CustomerServiceFactory implements ServiceFactory{
	
	public static final String ID = "CUSTOMER_PROCESSING_SERVICE";

	public String getId() {
		return ID;
	}

	public ProcessingService getService() {
		return new CustomerProcessingService();
	}

	@SuppressWarnings("unchecked")
	public <E, T extends BasedModel> LookupService<E, T> getLookupService() {
		return (LookupService<E, T>) new CustomerLookupService();
	}

	
	

}
