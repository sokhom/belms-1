package com.belms.dream.service.common.address;

import java.util.List;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.belms.dream.api.service.LookupService;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.repository.common.address.AddressRepo;
import com.belms.dream.repository.common.address.AddressRepoImpl;
import com.blems.dream.api.model.address.Address;

public class AddressLookupService implements LookupService<AddressInitDataWrapperDto, Address> {

	
	private final AddressRepo  addressRepo ;
	
	
	public AddressLookupService() {
		addressRepo = new AddressRepoImpl(ServiceProvider.newSession());
	}
	
	public AddressInitDataWrapperDto getInitData() {
		// TODO Auto-generated method stub
		return addressRepo.getInitData();
	}

	public List<Address> getDataList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Address> getDataList(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	public Address getDataItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
