package com.belms.dream.repository.customer.mapper;

import java.util.List;

import com.blems.dream.api.model.customer.Customer;

public interface CustomerMapper {
	List<Customer> selectAll();
	void insert(Customer customer);
	Customer selectCustomerById(int id);
}
