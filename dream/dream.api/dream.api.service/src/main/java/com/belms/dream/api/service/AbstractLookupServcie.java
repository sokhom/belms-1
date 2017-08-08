package com.belms.dream.api.service;

import java.util.List;

import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.Repo;

public abstract class AbstractLookupServcie<E, T extends BasedModel>  implements LookupService<E, T>{

	public E getInitData() {

		throw new RuntimeException("Not implemented");
	}
	
	public List<T> getDataList() {
		return getRepo().getAll();
	}

	
	public List<T> getDataList(String search) {
		return getRepo().search(search);
	}

	
	public T getDataItemById(int id) {
		return getRepo().getById(id);
	}

	protected abstract Repo<T> getRepo();
	
}
