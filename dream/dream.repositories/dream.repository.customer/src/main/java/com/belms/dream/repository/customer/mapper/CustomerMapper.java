package com.belms.dream.repository.customer.mapper;

import java.util.List;

import com.blems.dream.api.model.ObjectMapper;
import com.blems.dream.api.model.customer.Customer;

public interface CustomerMapper extends ObjectMapper<Customer> {
	List<Customer> selectAll();
	void insert(Customer customer);
	Customer selectCustomerById(int id);
}
