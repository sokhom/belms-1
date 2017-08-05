package com.belms.dream.service.customer;

import java.util.List;

import com.belms.dream.api.dto.customer.CustomerInitDataWrapperDto;
import com.belms.dream.api.service.LookupService;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.repository.customer.CustomerRepo;
import com.blems.dream.api.model.customer.Customer;

public class CustomerLookupService implements LookupService<CustomerInitDataWrapperDto, Customer>{

	private final CustomerRepo customerRepo;
	
	public CustomerLookupService() {
		customerRepo = new CustomerRepo(ServiceProvider.newSession());
	}
	
	public CustomerInitDataWrapperDto getInitData() {
		return customerRepo.getInitData();
	}

	public List<Customer> getDataList() {
		return customerRepo.getAll();
	}

	public Customer getDataItemById(int id) {
		return customerRepo.getById(id);
	}

	public List<Customer> getDataList(String search) {
		return null;
	}

	

}
