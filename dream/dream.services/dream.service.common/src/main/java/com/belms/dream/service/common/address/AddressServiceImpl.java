/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.service.common.address;

import java.util.List;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.belms.dream.api.service.AbstractService;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.address.AddressService;
import com.belms.dream.repository.common.address.AddressRepo;
import com.belms.dream.repository.common.address.AddressRepoImpl;
import com.blems.dream.api.model.Repo;
import com.blems.dream.api.model.address.Address;

public class AddressServiceImpl extends AbstractService<Address> implements AddressService {
	
	private final AddressRepo  addressRepo ;
	
	public AddressServiceImpl() {
		addressRepo = new AddressRepoImpl(()->ServiceProvider.newSession());
	}
	public List<Address> getListAccountId(int accountId) {
		return addressRepo.getAddressesByAccount(accountId);
	}

	public AddressInitDataWrapperDto getInitData() {
		return addressRepo.getInitData();
	}

	@Override
	protected Repo<Address> getRepo() {
		return addressRepo;
	}
	


}
