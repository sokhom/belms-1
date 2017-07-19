package com.belms.dream.workspace.customer;

import com.belms.dream.api.service.ServiceFactory;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.address.AddressService;
import com.belms.dream.api.service.customer.CustomerService;
import com.belms.dream.workspace.common.mainview.FilterListener;
import com.belms.dream.workspace.common.mainview.ShowSlectedItemListener;
import com.blems.dream.api.model.customer.Customer;
import com.vaadin.ui.Notification;

public class CustomerMainLayoutPresenter implements FilterListener, ShowSlectedItemListener<Customer> {
	
	private CustomerView layoutView;
	private final CustomerService customerService;
	private final AddressService addressService;
	
	public CustomerMainLayoutPresenter(CustomerView layoutView) {
		ServiceFactory factory = ServiceProvider.get(CustomerService.ID);
		customerService = (CustomerService) factory.getService();
		
		factory = ServiceProvider.get(CustomerService.ID);
		
		this.layoutView = layoutView;
		this.layoutView.setFilterListener(this);
		this.layoutView.setShowItemListener(this);
		factory = ServiceProvider.get(AddressService.ID);
		
		addressService = (AddressService) factory.getService();
		initData();
		this.layoutView.initView();
	}

	private void initData() {
	
		this.layoutView.setItemListData(customerService.getAll());
		this.layoutView.setDataInitWrapper(customerService.getInitData());
		this.layoutView.setAddressInitDataWrapperDto(addressService.getInitData());
	}

	@Override
	public void actionPerformed(String value) {
		Notification.show("Serching");
	}



	@Override
	public void itemSelected(Customer selectedITem) {
		layoutView.loadData(customerService.getById(selectedITem.getId()));
	}

	
	
}
