/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.service.employee;

import com.belms.dream.api.service.AbstractServiceFactory;
import com.belms.dream.api.service.LookupService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceFactory;
import com.blems.dream.api.model.BasedModel;

public class EmployeeServiceFactory extends AbstractServiceFactory implements ServiceFactory {
	
	private static final String EMPOYEE_SERIVCE = "EMPOYEE_SERIVCE";

	public String getId() {
		return EMPOYEE_SERIVCE;
	}

	public <T extends BasedModel> ProcessingService<T> getService() {
		return null;
	}

	public <E, T extends BasedModel> LookupService<E, T> getLookupService() {
		return null;
	}

	

}
