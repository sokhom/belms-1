package com.belms.dream.service.customer;

import java.util.List;

import com.belms.dream.api.service.AbstractProcessService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.action.Action;
import com.belms.dream.api.service.security.Authorize;
import com.belms.dream.repository.customer.CustomerRepo;
import com.blems.dream.api.model.Repo;
import com.blems.dream.api.model.customer.Customer;

public class CustomerProcessingService extends AbstractProcessService<Customer> implements ProcessingService<Customer> {
	@Override
	protected Repo<Customer> getRepo() {
		return new CustomerRepo(()->ServiceProvider.newSession());
	}

	@Override
	public ProcessingService<Customer> setAction(Action action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Action> getValidActions(Customer object, Authorize authorize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
}
