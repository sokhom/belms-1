package com.belms.dream.repository.common.location;

import org.apache.ibatis.session.SqlSession;

import com.belms.dream.repository.common.AbstractRepo;
import com.belms.dream.repository.common.mapper.LocationGroupMapper;
import com.blems.dream.api.model.location.LocationGroup;

public class LocationGroupRepo extends AbstractRepo<LocationGroup> {

	public LocationGroupRepo(SqlSession session) {
		super(session);
		setObjectMapper(session.getMapper(LocationGroupMapper.class));
	}
}
