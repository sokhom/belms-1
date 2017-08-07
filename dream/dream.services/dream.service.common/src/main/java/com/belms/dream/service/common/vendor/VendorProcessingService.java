package com.belms.dream.service.common.vendor;

import com.belms.dream.api.service.AbstractProcessService;
import com.belms.dream.api.service.ProcessingService;
import com.blems.dream.api.model.Repo;
import com.blems.dream.api.model.vendor.Vendor;

public class VendorProcessingService  extends AbstractProcessService<Vendor> implements ProcessingService<Vendor> {

	@Override
	protected Repo<Vendor> getRepo() {
		return null;
	}
}
