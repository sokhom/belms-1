/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.service.common.address;

import com.belms.dream.api.service.LookupService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceFactory;
import com.blems.dream.api.model.BasedModel;

public class AddressServiceFactory implements ServiceFactory {

	public final static String ID = "ADDRESS_SERVICE";
	
	public String getId() {
		return ID;
	}

	public ProcessingService getService() {
		return null;
	}

	@SuppressWarnings("unchecked")
	public <E, T extends BasedModel> LookupService<E, T> getLookupService() {
		return (LookupService<E, T>) new AddressLookupService();
	}
}
