package com.belms.dream.service.common.setup;

import com.belms.dream.api.service.AbstractService;
import com.belms.dream.api.service.CrudOper;
import com.belms.dream.api.service.setup.SetupService;
import com.belms.dream.repository.common.location.LocationGroupRepo;
import com.belms.dream.repository.common.location.LocationRepo;
import com.blems.dream.api.model.location.Location;
import com.blems.dream.api.model.location.LocationGroup;

public class SetupServiceImpl extends AbstractService implements SetupService {

	public CrudOper<Location> locationCrudOper() {
		return new CrudOperImpl<Location>(new LocationRepo(getSqlSession()));
	}

	public CrudOper<LocationGroup> locationGroupCrudOper() {
		return new CrudOperImpl<LocationGroup>(new LocationGroupRepo(getSqlSession()));
	}
	
}
