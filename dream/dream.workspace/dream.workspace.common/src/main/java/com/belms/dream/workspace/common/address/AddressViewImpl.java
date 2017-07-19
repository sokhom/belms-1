package com.belms.dream.workspace.common.address;


import java.util.List;

import com.belms.dream.api.dto.address.AddressInitDataWrapperDto;
import com.belms.dream.api.view.event.SaveEntityListener;
import com.belms.dream.workspace.common.address.newview.AddressAddNewView;
import com.blems.dream.api.model.address.Address;
import com.blems.dream.api.model.contact.Contact;
import com.vaadin.data.Binder;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class AddressViewImpl extends VerticalLayout implements AddressView, SaveEntityListener<Address> {

	private static final long serialVersionUID = 1L;
	
	private final ListSelect<Address> addressListSelect = new ListSelect<>();
	private final Binder<Address> binder = new Binder<>();
	private AddressInitDataWrapperDto addressInitDataWrapperDto;
//	private final List<Address> addresses ;
	
	public AddressViewImpl(AddressInitDataWrapperDto addressInitDataWrapperDto) {
//		new AddressViewPresenter(this);
		setInitDataWrapperDto(addressInitDataWrapperDto);
	}
	
	
	@Override
	public void setAddressListProvider(DataProvider<Address, String> dataProvider) {
		addressListSelect.setDataProvider(dataProvider);
		addressListSelect.getDataProvider().refreshAll();
	}

	private void buildUI() {
		setCaption("Address");
		setIcon(VaadinIcons.WORKPLACE);
		setSizeFull();
		setMargin(false);
		HorizontalLayout root = new HorizontalLayout();
		root.setMargin(false);
		root.setSpacing(false);
		root.setSizeFull();
		root.addStyleName("profile-form");
		
		VerticalLayout layoutDetail = new VerticalLayout();
		layoutDetail.setSizeFull();
		layoutDetail.setMargin(false);
		layoutDetail.setSpacing(false);
		
		buildAddressDetail(layoutDetail);
		buildContactList(layoutDetail);
		root.addComponent(layoutDetail);
		root.setExpandRatio(layoutDetail, 1);
		buildAddressList(root);
		addComponent(root);
	}
	
	
	private void buildAddressList(HorizontalLayout parent){
		Panel panel = new Panel();
	
		parent.addComponent(panel);
		panel.setCaption("Addresss List");
		panel.setIcon(VaadinIcons.LIST);
		panel.setWidth(200.0f, Unit.PIXELS);
		panel.setHeight(100.0f, Unit.PERCENTAGE);
		
		final VerticalLayout layout = new VerticalLayout();
		panel.setContent(layout);
		layout.setSizeFull();
		layout.setMargin(false);
		layout.setSpacing(false);
	
		final MenuBar menuBar = new MenuBar();
		menuBar.setWidth(100,Unit.PERCENTAGE);
		menuBar.addStyleName(ValoTheme.MENUBAR_BORDERLESS);
		menuBar.addStyleName(ValoTheme.MENUBAR_SMALL);
		menuBar.addItem("", VaadinIcons.FILE_ADD , event-> {
			
			AddressAddNewView addNewView = new AddressAddNewView(this, OPER_TYPE.ADD, addressInitDataWrapperDto) ;
			addNewView.initView();
			
			UI.getCurrent().addWindow(addNewView);
		});
		menuBar.addItem("",VaadinIcons.EDIT, null);
		menuBar.addItem("",VaadinIcons.FILE_REMOVE, null);
		layout.addComponent(menuBar);
		
		layout.addComponent(addressListSelect);
		layout.setExpandRatio(addressListSelect, 1);
		addressListSelect.setSizeFull();
		addressListSelect.addSelectionListener(event->{
			if(event.getFirstSelectedItem().isPresent()){
				binder.setBean(event.getFirstSelectedItem().get());
			}else{
				binder.removeBean();
			}
		});
		
	}
	
	private void buildAddressDetail(VerticalLayout parent){
		Panel layout = new Panel();
		parent.addComponent(layout);
		layout.setIcon(VaadinIcons.BUILDING);
		layout.setCaption("Address Info");
		layout.setSizeFull();
		parent.setExpandRatio(layout, 1);
		
		layout.setSizeFull();
		
		FormLayout formLayout = new FormLayout();
		formLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
		
		final TextField addressTypeTextField = new TextField("Address Type");
		formLayout.addComponent(addressTypeTextField);
		
		final TextField nameTextField = new TextField("Address Name");
		nameTextField.setValue("Phanny co. LTD");
		formLayout.addComponent(nameTextField);
		
		
		final TextArea addressTextArea = new TextArea("Address");
		formLayout.addComponent(addressTextArea);
		addressTextArea.setRows(2);
		
		final HorizontalLayout wrap = new HorizontalLayout();
		formLayout.addComponent(wrap);
        wrap.setSpacing(false);
        wrap.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
        wrap.setCaption("City/State/Zip");
		
        final TextField cityTextField = new TextField();
        wrap.addComponent(cityTextField);
        cityTextField.setWidth(100,Unit.PIXELS);
        cityTextField.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        wrap.addComponent(new Label("/"));
        
        final TextField stateTextField = new TextField();
        wrap.addComponent(stateTextField);
        stateTextField.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        stateTextField.setWidth(100,Unit.PIXELS);
        wrap.addComponent(new Label("/"));
        
        final TextField zipTextField = new TextField();
        zipTextField.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);
        zipTextField.setWidth(100,Unit.PIXELS);
        wrap.addComponent(zipTextField);
		
		final TextField countryTextField = new TextField("Country");
		formLayout.addComponent(countryTextField);
		
		final CheckBox residentialAddressCheckBox = new CheckBox("Residential Address");
		formLayout.addComponent(residentialAddressCheckBox);
		
		final CheckBox defaultAddress = new CheckBox("Default Address");
		formLayout.addComponent(defaultAddress);
		
		layout.setContent(formLayout);
	}
	
	private void buildContactList(VerticalLayout parent){
		final Panel layout = new Panel();
		layout.setHeight(150.0f, Unit.PIXELS);
		layout.setIcon(VaadinIcons.GROUP);
		layout.setCaption("Contact List");
		parent.addComponent(layout);
		
		
		final Grid<Contact> contactGrid = new Grid<>();
		layout.setContent(contactGrid);
		contactGrid.addColumn(Contact::getName).setCaption("Name");
		contactGrid.addColumn(Contact::getContact).setCaption("Value");
		contactGrid.addColumn(Contact::getType).setCaption("Contact Type");
		contactGrid.addColumn(Contact::isDefaultFlag).setCaption("Default");
		contactGrid.setSizeFull();
		contactGrid.setSelectionMode(SelectionMode.SINGLE);
	}

	@Override
	public void setAddresses(List<Address> addresses) {
//		if(addressesListener!=null){
//			addressesListener.loaded(addresses);
//		}
		
		setAddressListProvider(new CallbackDataProvider<Address, String>(query-> addresses.stream(),query-> addresses.size()));
	}

	@Override
	public void initView() {
		buildUI();
	}

//	@Override
//	public void setLoadAddressesListener(LoadAddressesListener addressesListener) {
//		this.addressesListener = addressesListener;
//	}

	@Override
	public void setInitDataWrapperDto(final AddressInitDataWrapperDto addressInitDataWrapperDto) {
		this.addressInitDataWrapperDto = addressInitDataWrapperDto;
		
	}

	@Override
	public void save(Address bean, OPER_TYPE type) {
		System.out.println(bean);
		
	}

	@Override
	public Address getBean(OPER_TYPE type) {
		if(OPER_TYPE.ADD == type) {
			return new Address();
		}
		return null;
	}

}
