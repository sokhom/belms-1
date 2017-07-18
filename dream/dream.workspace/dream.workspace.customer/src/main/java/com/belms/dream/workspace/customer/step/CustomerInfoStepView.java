package com.belms.dream.workspace.customer.step;

import com.belms.dream.workspace.common.newview.AbstractStepView;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

public class CustomerInfoStepView  extends AbstractStepView {
	
	private static final String NAME = "Customer Info";
	
	@Override
	public String getName() {
		return NAME;
	}


	@Override
	public boolean isValid() {
		return true;
	}
	
	
	@Override
	protected Component buildView(){
		final FormLayout formLayout = new FormLayout();
		formLayout.setSizeFull();
		formLayout.setSpacing(false);
		formLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		
		final TextField customerNameTextField = new TextField("Name");
		formLayout.addComponent(customerNameTextField);
		
		final TextField urlTextField = new TextField("Website");
		formLayout.addComponent(urlTextField);
		
		final CheckBox activeCheckBox = new CheckBox("Active");
		formLayout.addComponent(activeCheckBox);
		//binder.bind(activeCheckBox, Customer::isActiveFlag, Customer::setActiveFlag);
		
		return formLayout;	
	}

}
