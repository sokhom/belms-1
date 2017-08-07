package com.belms.dream.repository.common.location;

import org.apache.ibatis.session.SqlSession;

import com.belms.dream.repository.common.AbstractRepo;
import com.belms.dream.repository.common.mapper.LocationMapper;
import com.blems.dream.api.model.location.Location;

public class LocationRepo extends AbstractRepo<Location> {

	private LocationMapper locationMapper ;
	public LocationRepo(SqlSession session) {
		super(session);
		locationMapper = session.getMapper(LocationMapper.class);
		setObjectMapper(locationMapper);
	}
	
}
