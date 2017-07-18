package com.belms.dream.workspace.customer;

import com.belms.dream.api.dto.customer.CustomerInitDataWrapperDto;
import com.belms.dream.api.service.address.AddressService;
import com.belms.dream.api.view.event.EventBusProvider;
import com.belms.dream.workspace.common.address.AddressView;
import com.belms.dream.workspace.common.address.AddressViewImpl;
import com.belms.dream.workspace.common.mainview.AbstractMainView;
import com.belms.dream.workspace.common.newview.AbstractNewView;
import com.belms.dream.workspace.customer.subview.CustomerDetailView;
import com.belms.dream.workspace.customer.subview.CustomerInfoView;
import com.blems.dream.api.model.customer.Customer;
import com.vaadin.data.Binder;
import com.vaadin.ui.Component;

public class CustomerViewImpl extends AbstractMainView<Customer, Customer, CustomerInitDataWrapperDto> implements CustomerView {

	private static final long serialVersionUID = 1L;
	private AddressView addressView ;
	private AddressService addressService;	
	public CustomerViewImpl(final EventBusProvider eventBusProvider) {
		super(eventBusProvider);
		new CustomerMainLayoutPresenter(this);
	}

	
	@Override
	public void initView() {
		super.initView();
		buildTabs();
	}

	protected void buildTabs() {
		addTab(new CustomerInfoView(binder, getDataInitWrapper()));
		addTab(new CustomerDetailView(binder, getDataInitWrapper()));
		addressView  =new AddressViewImpl(this.addressService);
		addressView.initView();
		addTab((Component) addressView);
		
	}
	
	@Override
	public void loadData(Customer data) {
		super.loadData(data);
		this.addressView.setAccount(data.getAccount().getId());
	}

	@Override
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
		
	}

	@Override
	public AbstractNewView getNewView() {
		return new NewCustomerView( addressService, super.getEventBusProvider(),new Binder<Customer>() , getDataInitWrapper());
	}

	


}
