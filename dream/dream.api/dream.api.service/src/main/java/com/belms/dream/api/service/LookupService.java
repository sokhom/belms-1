package com.belms.dream.api.service;

import java.util.List;

import com.blems.dream.api.model.BasedModel;

public interface LookupService<E,T extends BasedModel> {
	E getInitData();
	List<T> getDataList();
	List<T> getDataList(String search);
	T getDataItemById(int id);
}
