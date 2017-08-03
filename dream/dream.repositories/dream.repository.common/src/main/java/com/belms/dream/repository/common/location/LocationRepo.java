package com.belms.dream.repository.common.location;

import java.util.List;

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

	public List<Location> getAll() {
		return null;
	}

	@Override
	public Location getById(int id) {
		return super.getById(id);
	}

	@Override
	public Location add(Location t) {
		
		return super.add(t);
	}

	@Override
	public void remove(Location t) {	
		super.remove(t);
	}

	@Override
	public Location edit(Location t) {
		return super.edit(t);
	}

	
	
	
}
