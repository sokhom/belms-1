package com.belms.dream.service.po;

import java.util.List;

import com.belms.dream.api.dto.customer.po.PoInitDataWrapperDto;
import com.belms.dream.api.service.LookupService;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.repository.po.PoRepo;
import com.blems.dream.api.model.po.Po;

public class PoLookupService implements LookupService<PoInitDataWrapperDto, Po> {

	private static PoRepo poRepo;
	
	public PoLookupService() {
		poRepo = new PoRepo(ServiceProvider.newSession());
	}
	
	public PoInitDataWrapperDto getInitData() {
		return new PoInitDataWrapperDto();
	}

	public List<Po> getDataList() {
		return poRepo.getAll();
	}

	public List<Po> getDataList(String search) {
		return poRepo.search(search);
	}

	public Po getDataItemById(int id) {
		return poRepo.getById(id);
	}

}
