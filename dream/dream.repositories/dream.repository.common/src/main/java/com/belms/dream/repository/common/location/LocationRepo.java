package com.belms.dream.repository.common.location;

import com.belms.dream.repository.common.AbstractRepo;
import com.belms.dream.repository.common.SqlSessionProvider;
import com.belms.dream.repository.common.mapper.LocationMapper;
import com.blems.dream.api.model.location.Location;

public class LocationRepo extends AbstractRepo<Location> {

	public LocationRepo(SqlSessionProvider sqlSessionProvider) {
		super(sqlSessionProvider, session->session.getMapper(LocationMapper.class));
	}
	
}
