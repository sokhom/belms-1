package com.belms.dream.api.service.action;

import com.belms.dream.api.service.security.Authorize;

public interface Action {
	String getActionId();
	String getServiceId();
	String getActionName();
	void setAuthorize(Authorize authorize);
}
