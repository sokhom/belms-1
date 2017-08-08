package com.belms.dream.service.po;

import com.belms.dream.api.service.AbstractService;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.po.PoService;
import com.belms.dream.repository.po.PoRepo;
import com.blems.dream.api.model.Repo;
import com.blems.dream.api.model.po.Po;

public class PoServiceImpl extends AbstractService<Po> implements PoService {

	@Override
	protected Repo<Po> getRepo() {
		return new PoRepo(()->ServiceProvider.newSession(),true);
	}

}
