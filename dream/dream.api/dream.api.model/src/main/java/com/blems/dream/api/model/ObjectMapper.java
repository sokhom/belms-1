package com.blems.dream.api.model;

import java.util.List;

public interface ObjectMapper<T extends BasedModel> {
	
	List<T> selectAll();
	void insert(T t);
	void update(T t);
	T selectById(int id);
	void remove(T t);
	
}
