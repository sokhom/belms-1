/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.service.common.address;

import com.belms.dream.api.service.LookupService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceFactory;
import com.belms.dream.api.service.address.AddressService;
import com.blems.dream.api.model.BasedModel;

public class AddressServiceFactory implements ServiceFactory {

	public String getId() {
		
		return AddressService.ID;
	}

	public ProcessingService getService() {
		return null;
	}

	public <E, T extends BasedModel> LookupService<E, T> getLookupService() {
		return null;
	}
}
