package com.belms.dream.workspace.customer.step;

import com.belms.dream.api.service.address.AddressService;
import com.belms.dream.workspace.common.address.AddressView;
import com.belms.dream.workspace.common.address.AddressViewImpl;
import com.belms.dream.workspace.common.newview.AbstractStepView;
import com.vaadin.ui.Component;

public class AddressStepView extends AbstractStepView {

	private final static String NAME="Address";
	private final AddressService addressService;
	private AddressView addressView;
	
	public AddressStepView(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	protected Component buildView() {
		
		if(addressView == null){
			addressView =  new AddressViewImpl(addressService);
			addressView.initView();
		}
		return (Component) addressView;
	}

}
