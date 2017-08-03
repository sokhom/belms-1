package com.belms.dream.repository.common.mapper;

import java.util.List;

import com.blems.dream.api.model.location.LocationGroup;

public interface LocationGroupMapper {
	List<LocationGroup> selectAll();
	LocationGroup selectById(int id);
	void insert(LocationGroup locationGroup);
	void update(LocationGroup locationGroup);
	void delete(LocationGroup locationGroup);

}
