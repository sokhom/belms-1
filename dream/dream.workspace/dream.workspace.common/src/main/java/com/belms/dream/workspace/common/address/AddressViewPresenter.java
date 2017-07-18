package com.belms.dream.workspace.common.address;

import java.util.List;

import com.belms.dream.api.service.address.AddressService;
import com.blems.dream.api.model.address.Address;
import com.vaadin.data.provider.CallbackDataProvider;

public class AddressViewPresenter implements LoadAddressesListener {

	private final AddressView addressView;
	private final AddressService addressService;
	
	public AddressViewPresenter(AddressView addressView,AddressService addressService) {
		this.addressView = addressView;
		this.addressService = addressService;
		this.addressView .setLoadAddressesListener(this);
		addressView.setInitDataWrapperDto(addressService.getInitData());
	}
	
	@Override
	public void loaded(int accountId) {
		List<Address> addresses = addressService.getListAccountId(accountId);
		addressView.setAddressListProvider(new CallbackDataProvider<Address, String>(query-> addresses.stream(),query-> addresses.size()));
		
		
	}

}
