package com.belms.dream.repository.common.location;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.belms.dream.repository.common.AbstractRepo;
import com.blems.dream.api.model.location.LocationGroup;

public class LocationGroupRepo extends AbstractRepo<LocationGroup> {

	public LocationGroupRepo(SqlSession session) {
		super(session);
	}

	public List<LocationGroup> getAll() {
		return null;
	}

}
