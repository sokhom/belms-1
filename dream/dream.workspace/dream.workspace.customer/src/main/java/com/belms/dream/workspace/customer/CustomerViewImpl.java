package com.belms.dream.workspace.customer;

import java.util.ArrayList;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.belms.dream.api.dto.customer.CustomerInitDataWrapperDto;
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
	private AddressInitDataWrapperDto initDataWrapperDto;
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
		addressView  =new AddressViewImpl(initDataWrapperDto);
		addressView.setContactHeight(300.0f);
		addressView.initView();
		
		addTab((Component) addressView);
		
	}
	
	@Override
	public void loadData(Customer data) {
		super.loadData(data);
		
		if(data.getAddresses() == null) {
			data.setAddresses(new ArrayList<>());
		}
		
		this.addressView.setAddresses(data.getAddresses());
	}

	@Override
	public AbstractNewView getNewView() {
		return new NewCustomerView(super.getEventBusProvider(),new Binder<Customer>() , getDataInitWrapper(),initDataWrapperDto);
	}


	@Override
	public void setAddressInitDataWrapperDto(AddressInitDataWrapperDto initDataWrapperDto) {
		this.initDataWrapperDto = initDataWrapperDto;
		
	}


	

	


}
