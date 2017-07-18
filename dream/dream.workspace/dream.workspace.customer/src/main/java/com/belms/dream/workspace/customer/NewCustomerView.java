package com.belms.dream.workspace.customer;

import java.util.ArrayList;
import java.util.List;

import com.belms.dream.api.dto.customer.CustomerInitDataWrapperDto;
import com.belms.dream.api.service.address.AddressService;
import com.belms.dream.api.view.event.EventBusProvider;
import com.belms.dream.workspace.common.newview.AbstractNewView;
import com.belms.dream.workspace.common.newview.StepView;
import com.belms.dream.workspace.customer.step.AddressStepView;
import com.belms.dream.workspace.customer.step.CustomerDerailStepView;
import com.belms.dream.workspace.customer.step.CustomerInfoStepView;
import com.blems.dream.api.model.customer.Customer;
import com.vaadin.data.Binder;

public class NewCustomerView extends AbstractNewView {

	private static final long serialVersionUID = 1L;
	private final Binder<Customer> binder;
	private final CustomerInitDataWrapperDto initDataWrapperDto;
	private final AddressService addressService;
	private final static String CAPTION = "<h3><b>New Customer wizard</b></h3>"; 

	public NewCustomerView(final AddressService addressService, final EventBusProvider eventBusProvider, final Binder<Customer> binder,final CustomerInitDataWrapperDto initDataWrapperDto) {
		super(eventBusProvider);
		this.binder = binder;
		this.initDataWrapperDto = initDataWrapperDto;
		this.addressService = addressService;
		eventBusProvider.register(this);
		setCaption(CAPTION);
		setCaptionAsHtml(true);
		center();
		setWidth(900, Unit.PIXELS);
		setHeight(700, Unit.PIXELS);
		initView();
	}

	@Override
	protected List<StepView> getStepViews() {
		List<StepView> stepViews = new ArrayList<>();
		stepViews.add(new CustomerInfoStepView());
		stepViews.add(new CustomerDerailStepView(binder, initDataWrapperDto));
		stepViews.add(new AddressStepView(this.addressService));
		return stepViews;
	}

}
