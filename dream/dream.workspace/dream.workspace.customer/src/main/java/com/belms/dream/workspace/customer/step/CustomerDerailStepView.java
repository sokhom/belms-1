package com.belms.dream.workspace.customer.step;

import com.belms.dream.api.dto.customer.CustomerInitDataWrapperDto;
import com.belms.dream.workspace.common.newview.AbstractStepView;
import com.belms.dream.workspace.customer.subview.CustomerDetailView;
import com.blems.dream.api.model.customer.Customer;
import com.vaadin.data.Binder;
import com.vaadin.ui.Component;

public class CustomerDerailStepView extends AbstractStepView {

	private final static String NAME ="Customer Detail";
	private final Binder<Customer> binder;
	private final CustomerInitDataWrapperDto initDataWrapperDto ;
	
	public CustomerDerailStepView(final Customer customer,final CustomerInitDataWrapperDto initDataWrapperDto) {
		this.binder = new Binder<>();
		binder.setBean(customer);
		this.initDataWrapperDto = initDataWrapperDto;
	}
	
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public boolean isValid() {
		return binder.validate().isOk();
	}

	@Override
	protected Component buildView() {
		return new CustomerDetailView(binder, initDataWrapperDto);
	}
	

}
 