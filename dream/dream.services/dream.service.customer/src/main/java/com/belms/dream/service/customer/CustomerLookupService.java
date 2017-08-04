package com.belms.dream.service.customer;

import java.util.List;

import com.belms.dream.api.dto.customer.CustomerInitDataWrapperDto;
import com.belms.dream.api.service.LookupService;
import com.blems.dream.api.model.customer.Customer;

public class CustomerLookupService implements LookupService<CustomerInitDataWrapperDto, Customer>{

	public CustomerInitDataWrapperDto getInitData() {
		return null;
	}

	public List<Customer> getDataList() {
		return null;
	}

	public Customer getDataItemById(int id) {
		return null;
	}

	public List<Customer> getDataList(String search) {
		return null;
	}

	

}
