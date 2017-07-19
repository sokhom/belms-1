package com.belms.dream.workspace.customer.subview;

import com.belms.dream.api.dto.customer.CustomerInitDataWrapperDto;
import com.belms.dream.workspace.common.validator.RequiredValidator;
import com.blems.dream.api.model.carrier.Carrier;
import com.blems.dream.api.model.carrier.CarrierService;
import com.blems.dream.api.model.currency.Currency;
import com.blems.dream.api.model.customer.Customer;
import com.blems.dream.api.model.customer.CustomerStatus;
import com.blems.dream.api.model.payment.PaymentTerm;
import com.blems.dream.api.model.ship.ShipTerm;
import com.vaadin.data.Binder;
import com.vaadin.data.converter.StringToDoubleConverter;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class CustomerDetailView extends VerticalLayout{

	private static final long serialVersionUID = 1L;
	
	public CustomerDetailView(final Binder<Customer> binder,final CustomerInitDataWrapperDto initDataWrapperDto) {
		buildView(binder, initDataWrapperDto);
	}

	private void buildView(final Binder<Customer> binder,final CustomerInitDataWrapperDto initDataWrapperDto){
		addStyleName("profile-form");
		setCaption("Detail");
		setIcon(VaadinIcons.INFO_CIRCLE_O);
		final FormLayout formLayout = new FormLayout();
		formLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		formLayout.setMargin(new MarginInfo(true, true, false, true));
		addComponent(formLayout);
		final ComboBox<Currency> currencyComboBox = new ComboBox<>("Currency");
		binder.bind(currencyComboBox, Customer::getCurrency, Customer::setCurrency);
		currencyComboBox.setDataProvider(new CallbackDataProvider<Currency, String>(query->initDataWrapperDto.getCurrencies().stream(), qyery->initDataWrapperDto.getCurrencies().size()));
		
		formLayout.addComponent(currencyComboBox);

		final TextField creditLimitField = new TextField("Credit Limit");
		binder.forField(creditLimitField)
				.withConverter(new StringToDoubleConverter("Only number is accepted"))
				.bind(Customer::getCreditLimit, Customer::setCreditLimit);
		formLayout.addComponent(creditLimitField);
		
		final ComboBox<CustomerStatus> statusComboBox = new ComboBox<>("Status");
		binder.forField(statusComboBox).withValidator(new RequiredValidator()).bind(Customer::getStatus, Customer::setStatus);
		statusComboBox.setDataProvider(new CallbackDataProvider<CustomerStatus,String>(query->initDataWrapperDto.getStatusList().stream(), query->initDataWrapperDto.getStatusList().size()));
		statusComboBox.setRequiredIndicatorVisible(true);
		
		
		formLayout.addComponent(statusComboBox);
		
		final ComboBox<PaymentTerm> paymentTermComboBox = new ComboBox<PaymentTerm>("Default Payment Term");
		binder.bind(paymentTermComboBox, Customer::getDefultPaymentTerm, Customer::setDefultPaymentTerm);
		paymentTermComboBox.setDataProvider(new CallbackDataProvider<PaymentTerm,String>(query->initDataWrapperDto.getPaymentTerms().parallelStream(),query->initDataWrapperDto.getPaymentTerms().size()));
		formLayout.addComponent(paymentTermComboBox);
		
		
		
		final ComboBox<ShipTerm> shipTermComboBox = new ComboBox<ShipTerm>("Default Ship Term");
		binder.bind(shipTermComboBox, Customer::getDefaultShipTerm, Customer::setDefaultShipTerm);
		shipTermComboBox.setDataProvider(new CallbackDataProvider<ShipTerm,String>(query->initDataWrapperDto.getShipTerms().stream(), query->initDataWrapperDto.getShipTerms().size()));
		formLayout.addComponent(shipTermComboBox);
		
		final ComboBox<Carrier> carrierComboBox = new ComboBox<Carrier>("Default Carrier");
		binder.bind(carrierComboBox, Customer::getDefaultCarrier, Customer::setDefaultCarrier);
		carrierComboBox.setDataProvider(new CallbackDataProvider<Carrier,String>(query->initDataWrapperDto.getCarriers().stream(), query->initDataWrapperDto.getCarriers().size()));
		formLayout.addComponent(carrierComboBox);
		
		final ComboBox<CarrierService> carrierServiceComboBox = new ComboBox<CarrierService>("Default Carrier Service");
		binder.bind(carrierServiceComboBox, Customer::getCarrierService, Customer::setCarrierService);
		carrierServiceComboBox.setDataProvider(new CallbackDataProvider<CarrierService, String>(query->initDataWrapperDto.getCarrierServices().stream(),query->initDataWrapperDto.getCarrierServices().size()));
		formLayout.addComponent(carrierServiceComboBox);
		
		final ComboBox<String> salePersonComboBox = new ComboBox<String>("Saleperson");
		formLayout.addComponent(salePersonComboBox);
		
		CheckBox toBeEmailed = new CheckBox("To be emailed");
		binder.bind(toBeEmailed, Customer::isToBeEmailed, Customer::setToBeEmailed);
		formLayout.addComponent(toBeEmailed);
		
		CheckBox toBePrinted = new CheckBox("To be printed");
		binder.bind(toBeEmailed, Customer::isToBePrinted, Customer::setToBePrinted);
		formLayout.addComponent(toBePrinted);
		
		TextArea noteTextArrea = new TextArea("Note");
		noteTextArrea.setRows(5);
		binder.bind(noteTextArrea, Customer::getNote, Customer::setNote);
		formLayout.addComponent(noteTextArrea);
	}
	
}
