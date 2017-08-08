package com.belms.dream.service.common.setup;

import com.belms.dream.api.service.AbstractService;
import com.belms.dream.api.service.CrudOper;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.setup.SetupService;
import com.belms.dream.repository.common.location.LocationGroupRepo;
import com.belms.dream.repository.common.location.LocationRepo;
import com.blems.dream.api.model.Repo;
import com.blems.dream.api.model.location.Location;
import com.blems.dream.api.model.location.LocationGroup;

@SuppressWarnings("rawtypes")
public class SetupServiceImpl extends AbstractService implements SetupService {

	public CrudOper<Location> locationCrudOper() {
		return new CrudOperImpl<Location>(new LocationRepo(()->ServiceProvider.newSession()));
	}

	public CrudOper<LocationGroup> locationGroupCrudOper() {
		return new CrudOperImpl<LocationGroup>(new LocationGroupRepo(()->ServiceProvider.newSession()));
	}

	@Override
	protected Repo getRepo() {
		return  null;
	}
	
}
