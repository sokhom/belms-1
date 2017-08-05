package com.belms.dream.service.customer;

import com.belms.dream.api.service.AbstractProcessService;
import com.belms.dream.api.service.ProcessingService;
import com.blems.dream.api.model.Repo;
import com.blems.dream.api.model.customer.Customer;

public class CustomerProcessingService extends AbstractProcessService<Customer> implements ProcessingService {

	@Override
	protected void takeAction(Customer t) {
		
	}

	@Override
	protected Repo<Customer> getRepo() {
		return null;
	}

}
