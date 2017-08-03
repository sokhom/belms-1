package com.belms.dream.repository.common.mapper;

import java.util.List;

import com.blems.dream.api.model.BasedModel;

public interface ObjectMapper<T extends BasedModel> {
	List<T> selectAll();
	T selectById(int id);
	void insert(T object);
	void update(T object);
	void delete(T object);

}
