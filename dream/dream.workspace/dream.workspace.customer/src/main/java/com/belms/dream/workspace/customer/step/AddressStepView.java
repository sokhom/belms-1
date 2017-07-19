package com.belms.dream.workspace.customer.step;

import java.util.List;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.belms.dream.workspace.common.address.AddressView;
import com.belms.dream.workspace.common.address.AddressViewImpl;
import com.belms.dream.workspace.common.newview.AbstractStepView;
import com.blems.dream.api.model.address.Address;
import com.vaadin.ui.Component;

public class AddressStepView extends AbstractStepView {

	private final static String NAME="Address";
	private final AddressInitDataWrapperDto initDataWrapperDto;
	private AddressView addressView;
	private final List<Address> addresses;
	
	public AddressStepView(final List<Address> addresses, final AddressInitDataWrapperDto initDataWrapperDto) {
		this.addresses = addresses;
		this.initDataWrapperDto = initDataWrapperDto;
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
			addressView =  new AddressViewImpl(initDataWrapperDto);
			addressView.initView();
			addressView.loadData(addresses);
		}
		return (Component) addressView;
	}

	@Override
	public boolean validationRequired() {
		return false;
	}

}
