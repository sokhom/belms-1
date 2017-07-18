package com.belms.dream.workspace.common.address;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.belms.dream.workspace.common.View;
import com.blems.dream.api.model.address.Address;
import com.vaadin.data.provider.DataProvider;

public interface AddressView extends View {
	void setAddressListProvider(DataProvider<Address, String> dataProvider);
	void setAccount(int accountId);
	void setLoadAddressesListener(LoadAddressesListener addressesListener);
	void setInitDataWrapperDto(AddressInitDataWrapperDto addressInitDataWrapperDto);
}