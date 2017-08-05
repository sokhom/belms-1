package com.belms.dream.workspace.customer;

import com.belms.dream.api.service.ServiceFactory;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.address.AddressService;
import com.belms.dream.api.service.customer.CustomerService;
import com.belms.dream.api.view.event.EventBusProvider;
import com.belms.dream.api.view.event.OpenViewEvent;
import com.belms.dream.api.view.event.OpenViewEvent.OPEN_AS;
import com.google.common.eventbus.Subscribe;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet.Tab;
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
			 
			 return;
		}
		
		
		if("view_customer".equals(event.getViewId()) && OPEN_AS.TAB == event.getAs() ) {
			
			
			String id =String.format("customer_%d", event.getFilterItemList().getId());
			
			for (int i = 0; i < event.getParent().getComponentCount(); i++) {

				Tab tab = event.getParent().getTab(i);
				if(tab!=null && id.equals(tab.getId())) {
					event.getParent().setSelectedTab(tab);
					return;
				}
				
			}
			final Panel panel = new CustomerViewImpl(eventBusProvider, event.getFilterItemList());
			panel.setCaption(String.format("Customer-%s", event.getFilterItemList().getName()));
			event.getParent().addComponent(panel);
			Tab tab = event.getParent().getTab(panel);
			tab.setId(id);
			tab.setClosable(true);
			event.getParent().setSelectedTab(tab);
		}
	}
	
	
	

}
