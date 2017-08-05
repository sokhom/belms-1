/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.customer;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.belms.dream.api.dto.customer.CustomerInitDataWrapperDto;
import com.belms.dream.api.service.LookupService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceFactory;
import com.belms.dream.api.service.ServiceIds;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.address.AddressService;
import com.belms.dream.api.view.event.AddnewEntityListener;
import com.belms.dream.api.view.event.RefreshEntityListener;
import com.belms.dream.api.view.event.SaveEnityListener;
import com.blems.dream.api.model.address.Address;
import com.blems.dream.api.model.customer.Customer;

public class CustomerMainLayoutPresenter
		implements AddnewEntityListener<Customer>, SaveEnityListener<Customer>, RefreshEntityListener<Customer> {

	private CustomerView layoutView;
	private final LookupService<CustomerInitDataWrapperDto, Customer> customerLookupService;
	private final LookupService<AddressInitDataWrapperDto, Address> addressLookupService;
	
	private final ProcessingService customerProccessingservice;
	
	
	
	public CustomerMainLayoutPresenter(CustomerView layoutView) {
		ServiceFactory customerServiceFactory = ServiceProvider.get(ServiceIds.CUSTOMER_SERVICE_ID);
		customerProccessingservice = customerServiceFactory.getService();
		customerLookupService = customerServiceFactory.getLookupService();
		this.layoutView = layoutView;
		ServiceFactory addressServiceFactory = ServiceProvider.get(AddressService.ID);
		addressLookupService = addressServiceFactory.getLookupService();
		initData();
		this.layoutView.initView();

		if (layoutView.getSelectedItem() != null) {
			Customer customer = customerLookupService.getDataItemById(layoutView.getSelectedItem().getId());
			this.layoutView.loadData(customer);
		}

	}

	private void initData() {

		// this.layoutView.setItemListData(customerService.getAll());
		this.layoutView.setDataInitWrapper(customerLookupService.getInitData());
		this.layoutView.setAddressInitDataWrapperDto(addressLookupService.getInitData());

	}

	@Override
	public void addNew(Customer t) {
		customerProccessingservice.process(t);
		System.out.println(t.getName() + " added");
	}

	@Override
	public void save(Customer entiry) {
		customerProccessingservice.process(entiry);

	}

	@Override
	public Customer refresh(Customer entity) {
		return customerLookupService.getDataItemById(entity.getId());
	}

}
