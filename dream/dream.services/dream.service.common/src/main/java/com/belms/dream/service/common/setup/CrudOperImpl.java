package com.belms.dream.service.common.setup;

import java.util.List;

import com.belms.dream.api.service.CrudOper;
import com.belms.dream.repository.common.Repo;
import com.blems.dream.api.model.BasedModel;

public class CrudOperImpl<T extends BasedModel> implements CrudOper<T>  {

	private Repo<T> repo;
	
	public CrudOperImpl(Repo<T> repo) {
		this.repo = repo;
	}
	
	public List<T> findAll() {
	
		return repo.getAll();
	}

	public T findById(int id) {
		return repo.getById(id);
	}

	public void add(T object) {
		repo.add(object);
		
	}

	public void edit(T object) {
		repo.edit(object);
		
	}

	public void delete(T object) {
		repo.remove(object);
		
	}

}
