/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.customer;

import com.belms.dream.api.service.ServiceFactory;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.address.AddressService;
import com.belms.dream.api.service.customer.CustomerService;
import com.belms.dream.api.view.event.AddnewEntityListener;
import com.belms.dream.api.view.event.RefreshEntityListener;
import com.belms.dream.api.view.event.SaveEnityListener;
import com.blems.dream.api.model.customer.Customer;

public class CustomerMainLayoutPresenter
		implements AddnewEntityListener<Customer>, SaveEnityListener<Customer>, RefreshEntityListener<Customer> {

	private CustomerView layoutView;
	private final CustomerService customerService;
	private final AddressService addressService;

	public CustomerMainLayoutPresenter(CustomerView layoutView) {
		ServiceFactory factory = ServiceProvider.get(CustomerService.ID);
		customerService = (CustomerService) factory.getService();
		factory = ServiceProvider.get(CustomerService.ID);
		this.layoutView = layoutView;
		factory = ServiceProvider.get(AddressService.ID);
		addressService = (AddressService) factory.getService();
		initData();
		this.layoutView.initView();

		if (layoutView.getSelectedItem() != null) {
			Customer customer = customerService.getById(layoutView.getSelectedItem().getId());
			this.layoutView.loadData(customer);
		}

	}

	private void initData() {

		// this.layoutView.setItemListData(customerService.getAll());
		this.layoutView.setDataInitWrapper(customerService.getInitData());
		this.layoutView.setAddressInitDataWrapperDto(addressService.getInitData());

	}

	@Override
	public void addNew(Customer t) {
		customerService.add(t);
		System.out.println(t.getName() + " added");
	}

	@Override
	public void save(Customer entiry) {
		customerService.edit(entiry);

	}

	@Override
	public Customer refresh(Customer entity) {
		return customerService.getById(entity.getId());
	}

}
