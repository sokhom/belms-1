package com.belms.dream.repository.common.location;

import com.belms.dream.repository.common.AbstractRepo;
import com.belms.dream.repository.common.SqlSessionProvider;
import com.belms.dream.repository.common.mapper.LocationGroupMapper;
import com.blems.dream.api.model.location.LocationGroup;

public class LocationGroupRepo extends AbstractRepo<LocationGroup> {

	public LocationGroupRepo(SqlSessionProvider sqlSessionProvider) {
		super(sqlSessionProvider, session->session.getMapper(LocationGroupMapper.class));
	}
}
