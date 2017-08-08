package com.belms.dream.api.service;

public abstract class AbstractServiceFactory implements ServiceFactory {
	
	private String subServiceId;
	
	public ServiceFactory setSubServiceId(String id) {
		this.subServiceId = id;
		return this;
	}

	protected String getSubServiceId() {
		if(subServiceId==null) {
			throw new RuntimeException("No subservcie ID provided");
		}
		return subServiceId;
	}
	
}
