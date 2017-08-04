/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.repository.common.address;

import java.util.List;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.blems.dream.api.model.Repo;
import com.blems.dream.api.model.address.Address;

public interface AddressRepo  extends Repo<Address>{
	
	List<Address> getAddressesByAccount(int accountId);
	AddressInitDataWrapperDto getInitData();

}
