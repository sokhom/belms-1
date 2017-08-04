/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.service.customer;

import com.belms.dream.api.dto.customer.CustomerInitDataWrapperDto;
import com.belms.dream.api.service.AbstractService;
import com.belms.dream.api.service.customer.CustomerService;
import com.belms.dream.repository.customer.CustomerRepo;
import com.blems.dream.api.model.Repo;
import com.blems.dream.api.model.customer.Customer;

public class CustomerServiceImpl extends AbstractService<Customer> implements CustomerService {

	
	private final CustomerRepo customerRepo;
	
	
	public CustomerServiceImpl() {
		customerRepo = new CustomerRepo(getSqlSession()); 
	}
	
	

	public CustomerInitDataWrapperDto getInitData() {
		return customerRepo.getInitData();
	}



	@Override
	protected Repo<Customer> getRepo() {
		return customerRepo;
	}



	public void process(Customer object) {
		
	}



	public <E> void process(E object) {
		
		
	}



}
