package com.belms.dream.api.service.action;

import com.belms.dream.api.service.security.Authorize;

public class DefaultAction implements Action {
	
	private String actionId;
	private String serviceId;
	private String actionName;
	private Authorize authorize;
	
	public DefaultAction(String actionId, String serviceId, String actionName) {
		setActionId(actionId);
		setServiceId(serviceId);
		setActionName(actionName);
	}
	
	public Authorize getAuthorize() {
		return authorize;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	@Override
	public String getActionId() {

		return actionId;
	}

	@Override
	public String getServiceId() {
		return serviceId;
	}

	@Override
	public String getActionName() {
		return actionName;
	}

	@Override
	public void setAuthorize(Authorize authorize) {
		this.authorize =authorize;
		
	}

}
