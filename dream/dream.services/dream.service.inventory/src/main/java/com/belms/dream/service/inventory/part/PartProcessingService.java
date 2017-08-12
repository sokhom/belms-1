package com.belms.dream.service.inventory.part;

import java.util.List;

import com.belms.dream.api.service.AbstractProcessService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.action.Action;
import com.belms.dream.api.service.security.Authorize;
import com.blems.dream.api.model.Repo;
import com.blems.dream.api.model.part.Part;

public class PartProcessingService extends AbstractProcessService<Part> implements ProcessingService<Part> {

	@Override
	public ProcessingService<Part> setAction(Action action) {

		return null;
	}

	@Override
	public List<Action> getValidActions(Part object, Authorize authorize) {
		return null;
	}


	@Override
	protected Repo<Part> getRepo() {
		// TODO Auto-generated method stub
		return null;
	}

}
