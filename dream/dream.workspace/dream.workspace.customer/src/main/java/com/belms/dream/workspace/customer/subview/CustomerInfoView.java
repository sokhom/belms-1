package com.belms.dream.workspace.customer.subview;

import com.belms.dream.api.dto.customer.CustomerInitDataWrapperDto;
import com.blems.dream.api.model.customer.Customer;
import com.vaadin.data.Binder;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ExternalResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class CustomerInfoView extends VerticalLayout{
	private static final long serialVersionUID = 1L;

	public CustomerInfoView(final Binder<Customer> binder,final CustomerInitDataWrapperDto initDataWrapperDto) {
		buildLayout(binder, initDataWrapperDto);
	}
	
	private void buildLayout(final Binder<Customer> binder,final CustomerInitDataWrapperDto initDataWrapperDto){
		addStyleName("profile-form");
		setIcon(VaadinIcons.USER);
		setCaption("Info");

		final FormLayout formLayout = new FormLayout();
		formLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		formLayout.setMargin(new MarginInfo(true, true, false, true));
		addComponent(formLayout);

		final TextField nameTextField = new TextField("Name");
		binder.bind(nameTextField, Customer::getName, Customer::setName);

		formLayout.addComponent(nameTextField);

		final TextField addressTextField = new TextField("Default Address");
		addressTextField.setReadOnly(true);
		binder.bind(addressTextField, Customer::getAddress, null);

		formLayout.addComponent(addressTextField);

		final CheckBox activeCheckBox = new CheckBox("Active");

		binder.bind(activeCheckBox, Customer::isActiveFlag, Customer::setActiveFlag);

		formLayout.addComponent(activeCheckBox);

		Link urlLink = new Link("URL", new ExternalResource("http://vaadin.com/"));

		formLayout.addComponent(urlLink);

		Label section = new Label("Contact Info");
		section.addStyleName(ValoTheme.LABEL_H4);
		section.addStyleName(ValoTheme.LABEL_COLORED);
		formLayout.addComponent(section);

		Label contact = new Label(
				"Email :<b>  <a href='mailto:webmaster@example.com'>phannny.ngoun@gmail.com </a></b>, Name: Phanny");
		contact.setContentMode(ContentMode.HTML);
		formLayout.addComponent(contact);
		contact = new Label("Phone : <b>069522622</b>, Name: Good");
		contact.setContentMode(ContentMode.HTML);
		formLayout.addComponent(contact);
	
	}
	
	
}
