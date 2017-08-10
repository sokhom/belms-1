package com.belms.dream.service.common;

import com.belms.dream.api.service.AbstractServiceFactory;
import com.belms.dream.api.service.LookupService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceFactory;
import com.belms.dream.api.service.ServiceIds;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.repository.inventory.mapper.PartMapper;
import com.belms.dream.repository.vendor.VendorRepo;
import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.vendor.Vendor;


public class DefaultServiceFactory extends AbstractServiceFactory implements ServiceFactory {

	public String getId() {
		return ServiceIds.DEFAULT_SERVICE_ID;
	}

	@SuppressWarnings("unchecked")
	public <T extends BasedModel> ProcessingService<T> getService() {

		if (ServiceIds.VENDOR_SERVICE_ID.equalsIgnoreCase(getSubServiceId())) {
			DefaultProcessingService<Vendor> defaultProcessingService= new DefaultProcessingService<>(new VendorRepo(()->ServiceProvider.newSession()));
			return (ProcessingService<T>) defaultProcessingService;
		}else if(ServiceIds.PART_SERVICE_ID.equalsIgnoreCase(getSubServiceId())) {
			return (ProcessingService<T>)  new DefaultProcessingService<>(PartMapper.class);
		}
		throw new RuntimeException(String.format("The service (%s - %s) is not be provided",
				ServiceIds.DEFAULT_SERVICE_ID, getSubServiceId()));
	}

	@SuppressWarnings("unchecked")
	public <E, T extends BasedModel> LookupService<E, T> getLookupService() {
	
		if (ServiceIds.VENDOR_SERVICE_ID.equalsIgnoreCase(getSubServiceId())) {
			DefaultLookupService<Object, Vendor> defaultLookupService=	new DefaultLookupService<>(new VendorRepo(()->ServiceProvider.newSession()));
			return (LookupService<E, T>) defaultLookupService;
		}
		return null;
	}

}
