package com.belms.dream.workspace.customer;

import com.belms.dream.api.dto.customer.CustomerInitDataWrapperDto;
import com.belms.dream.api.service.address.AddressService;
import com.belms.dream.workspace.common.mainview.MainLayoutView;
import com.blems.dream.api.model.customer.Customer;

public interface CustomerView extends MainLayoutView<Customer, Customer, CustomerInitDataWrapperDto>  {

	void setAddressService(AddressService addressService);
	
}
