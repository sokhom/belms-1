/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.service.employee;

import com.belms.dream.api.service.LookupService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceFactory;

public class EmployeeServiceFactory implements ServiceFactory {
	
	private static final String EMPOYEE_SERIVCE = "EMPOYEE_SERIVCE";

	public String getId() {
		return EMPOYEE_SERIVCE;
	}

	public ProcessingService getService() {
		// TODO Auto-generated method stub
		return null;
	}

	public LookupService getLookupService() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public Service<Employee> getService() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
