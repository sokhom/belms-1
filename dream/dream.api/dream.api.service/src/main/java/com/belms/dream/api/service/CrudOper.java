package com.belms.dream.api.service;

import java.util.List;

import com.blems.dream.api.model.BasedModel;

public interface CrudOper<T extends BasedModel> {
	List<T> findAll();
	T findById(int id);
	void add(T object);
	void edit(T object);
	void delete(T object);
	
}
