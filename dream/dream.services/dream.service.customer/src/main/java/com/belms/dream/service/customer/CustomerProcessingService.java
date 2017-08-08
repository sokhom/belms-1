package com.belms.dream.service.customer;

import com.belms.dream.api.service.AbstractProcessService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.repository.customer.CustomerRepo;
import com.blems.dream.api.model.Repo;
import com.blems.dream.api.model.customer.Customer;

public class CustomerProcessingService extends AbstractProcessService<Customer> implements ProcessingService<Customer> {
	@Override
	protected Repo<Customer> getRepo() {
		return new CustomerRepo(()->ServiceProvider.newSession());
	}
}
