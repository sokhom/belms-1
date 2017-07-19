package com.belms.dream.workspace.common.address;

import java.util.List;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.belms.dream.workspace.common.View;
import com.blems.dream.api.model.address.Address;

public interface AddressView extends View {
	void setAddresses(List<Address> addresses);
//	void setLoadAddressesListener(LoadAddressesListener addressesListener);
	void setInitDataWrapperDto(AddressInitDataWrapperDto addressInitDataWrapperDto);
	void setContactHeight(float height);
}
