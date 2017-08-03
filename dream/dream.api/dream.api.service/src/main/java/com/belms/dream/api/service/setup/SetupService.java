package com.belms.dream.api.service.setup;

import com.belms.dream.api.service.CrudOper;
import com.belms.dream.api.service.Service;
import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.location.Location;
import com.blems.dream.api.model.location.LocationGroup;

public interface SetupService extends Service<BasedModel> {
	
	public final static String ID = "SETUP_SERVICE";
	
	CrudOper<Location> locationCrudOper();
	CrudOper<LocationGroup> locationGroupCrudOper();
	

}
