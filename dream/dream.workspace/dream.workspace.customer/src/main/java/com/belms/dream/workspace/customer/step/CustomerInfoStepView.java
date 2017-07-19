package com.belms.dream.workspace.customer.step;

import com.belms.dream.workspace.common.newview.AbstractStepView;
import com.belms.dream.workspace.common.validator.TextRequiredValidator;
import com.blems.dream.api.model.customer.Customer;
import com.vaadin.data.Binder;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

public class CustomerInfoStepView  extends AbstractStepView {
	
	private static final String NAME = "Customer Info";
	
	private final  Binder<Customer> binder;
	
	public CustomerInfoStepView(final Customer customer) {
		binder = new Binder<Customer>();
		binder.setBean(customer);
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
	protected Component buildView(){
		final FormLayout formLayout = new FormLayout();
		formLayout.setSizeFull();
		formLayout.setSpacing(false);
		formLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		
		final TextField customerNameTextField = new TextField("Name");
		formLayout.addComponent(customerNameTextField);
		binder.forField(customerNameTextField).withValidator(new TextRequiredValidator()).bind(Customer::getName, Customer::setName);
		customerNameTextField.setRequiredIndicatorVisible(true);
		
		final TextField urlTextField = new TextField("Website");
		formLayout.addComponent(urlTextField);
		binder.bind(urlTextField, Customer::getUrl, Customer::setUrl);
		
		final CheckBox activeCheckBox = new CheckBox("Active");
		formLayout.addComponent(activeCheckBox);
		binder.bind(activeCheckBox, Customer::isActiveFlag, Customer::setActiveFlag);
		
		return formLayout;	
	}

}
