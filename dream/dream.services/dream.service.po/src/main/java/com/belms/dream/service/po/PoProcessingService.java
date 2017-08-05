package com.belms.dream.service.po;

import com.belms.dream.api.service.AbstractProcessService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.repository.po.PoRepo;
import com.blems.dream.api.model.Repo;
import com.blems.dream.api.model.po.Po;

public class PoProcessingService  extends AbstractProcessService<Po> implements ProcessingService {

	private Repo<Po> poRepo;
	
	public PoProcessingService() {
		poRepo = new PoRepo(ServiceProvider.newSession());
	}
	
	@Override
	protected Repo<Po> getRepo() {
		
		return poRepo;
	}

	


}
