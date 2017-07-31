package com.belms.dream.workspace.customer;

import com.belms.dream.api.service.ServiceFactory;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.address.AddressService;
import com.belms.dream.api.service.customer.CustomerService;
import com.belms.dream.api.view.event.EventBusProvider;
import com.belms.dream.api.view.event.OpenViewEvent;
import com.belms.dream.api.view.event.OpenViewEvent.OPEN_AS;
import com.google.common.eventbus.Subscribe;
import com.vaadin.ui.UI;

public class ViewManaged {
	
	private final EventBusProvider eventBusProvider;
	
	public ViewManaged(EventBusProvider eventBusProvider) {
		eventBusProvider.register(this);
		this.eventBusProvider = eventBusProvider;
	}
	
	@Subscribe
	public void openView (final OpenViewEvent event) {
		
		if(event.getAs() == OPEN_AS.SUB_WINDOW  && "new_customer".equalsIgnoreCase(event.getViewId())  ) {
			ServiceFactory factory = ServiceProvider.get(CustomerService.ID);
			CustomerService customerService = (CustomerService) factory.getService();
			factory = ServiceProvider.get(AddressService.ID);
			AddressService addressService = (AddressService) factory.getService();
			 UI.getCurrent().addWindow(new NewCustomerViewImpl(eventBusProvider, customerService.getInitData(), addressService.getInitData()));
		}
	}
	

}
