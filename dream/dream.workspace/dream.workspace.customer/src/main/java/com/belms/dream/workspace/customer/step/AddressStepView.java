package com.belms.dream.workspace.customer.step;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.belms.dream.workspace.common.address.AddressView;
import com.belms.dream.workspace.common.address.AddressViewImpl;
import com.belms.dream.workspace.common.newview.AbstractStepView;
import com.vaadin.ui.Component;

public class AddressStepView extends AbstractStepView {

	private final static String NAME="Address";
	private final AddressInitDataWrapperDto initDataWrapperDto;
	private AddressView addressView;
	
	public AddressStepView(final AddressInitDataWrapperDto initDataWrapperDto) {
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
		}
		return (Component) addressView;
	}

}
