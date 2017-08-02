/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.repository.common.address;

import java.util.List;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.belms.dream.repository.common.Repo;
import com.blems.dream.api.model.address.Address;

public interface AddressRepo  extends Repo<Address>{
	
	List<Address> getAddressesByAccount(int accountId);
	AddressInitDataWrapperDto getInitData();

}
