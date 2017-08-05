/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.common.mainview;

import java.util.ArrayList;
import java.util.List;

import com.belms.dream.api.view.EntryView;
import com.belms.dream.api.view.event.EventBusProvider;
import com.belms.dream.api.view.event.RefreshEntityListener;
import com.belms.dream.api.view.event.SaveEnityListener;
import com.belms.dream.api.view.event.SaveEntityListener.OPER_TYPE;
import com.belms.dream.workspace.common.dialog.ConfirmDialog;
import com.blems.dream.api.model.DefaultModel;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

public abstract class AbstractMainView< T extends DefaultModel, E> extends Panel
		implements MainLayoutView<T, E> {

	private OPER_TYPE operType =OPER_TYPE.VIEW;
	private static final long serialVersionUID = 1L;

	private SaveEnityListener<T> saveEnityListener;
	private RefreshEntityListener<T> refreshEntityListener;
	private E dataInitWrapperDto;
	private final EventBusProvider eventBusProvider;
	private final TabSheet tabsheet = new TabSheet();

	private final List<EntryView<T>> entryViews = new ArrayList<>();
	private T data;
	

	public AbstractMainView(final EventBusProvider eventBusProvider) {
		this.eventBusProvider = eventBusProvider;
	}

	@Override
	public EventBusProvider getEventBusProvider() {
		return eventBusProvider;
	}

	
	protected void setOperType(OPER_TYPE type) {
		this.operType = type;
	}
	
	public abstract Window getNewView();

	@Override
	public void initView() {
		final VerticalLayout mainViewArea = new VerticalLayout();

		mainViewArea.setMargin(false);
		mainViewArea.setSpacing(false);
		mainViewArea.setSizeFull();
		mainViewArea.addComponent(buildMenuber());
		buildViewArea(mainViewArea);
		setContent(mainViewArea);
		setSizeFull();

	}

	private Component buildMenuber() {

		final MenuBar menubar = new MenuBar();
		menubar.setWidth(100.0f, Unit.PERCENTAGE);
		menubar.addStyleName(ValoTheme.MENUBAR_BORDERLESS);
		menubar.addItem("New", VaadinIcons.FILE_ADD, selectedItem-> UI.getCurrent().addWindow(getNewView()));
		final MenuItem editItem = menubar.addItem("Edit", VaadinIcons.EDIT, null);
		final MenuItem saveItem = menubar.addItem("Save", VaadinIcons.CHECK, null);
		saveItem.setEnabled(false);
		final MenuItem cancelItem = menubar.addItem("Cancel", VaadinIcons.FILE_REMOVE, null);
		cancelItem.setEnabled(false);
		
		
		
		Command command = new Command() {
		
			private static final long serialVersionUID = 1L;

			@Override
			public void menuSelected(MenuItem selectedItem) {
				if(data==null) {
					return;
				}
				if(editItem.equals(selectedItem)) {
					if(OPER_TYPE.VIEW == operType ) {
						setOperType(OPER_TYPE.EDIT);
						saveItem.setEnabled(true);
						cancelItem.setEnabled(true);
						editItem.setEnabled(false);	
					}
					
				}else if(saveItem.equals(selectedItem)) {
					if(OPER_TYPE.EDIT == operType) {
						
						for (EntryView<T> entryView : entryViews) {
							if(!entryView.isValid()) {
								tabsheet.setSelectedTab(entryView.getView());
								Notification.show("Input Data is not valid.", Type.ERROR_MESSAGE);
								return;
							}
						}
						
						ConfirmDialog.showDialog("Are you sure to save?", new ClickListener() {
						
							private static final long serialVersionUID = 1L;

							@Override
							public void buttonClick(ClickEvent event) {
								try {
									saveEnityListener.save(data);
									
									saveItem.setEnabled(false);
									cancelItem.setEnabled(false);
									editItem.setEnabled(true);
									Notification.show("Saved sucessfully", Type.HUMANIZED_MESSAGE);
								}catch (Exception e) {
									Notification.show(e.getMessage(), Type.ERROR_MESSAGE);
								}
							}
						});
						
						setOperType(OPER_TYPE.VIEW);
						
						
					}
				}else if(cancelItem .equals(selectedItem)) {
					loadData(refreshEntityListener.refresh(data));
					tabsheet.setSelectedTab(0);
					setOperType(OPER_TYPE.VIEW);
					saveItem.setEnabled(false);
					cancelItem.setEnabled(false);
					editItem.setEnabled(true);
				}
					
			}
		};
		
		editItem.setCommand(command);
		saveItem.setCommand(command);
		cancelItem.setCommand(command);
	
		return menubar;
	}

	protected void buildViewArea(final VerticalLayout mainViewArea) {
		
		final VerticalLayout layout = new VerticalLayout();
		mainViewArea.addComponent(layout);
		mainViewArea.setExpandRatio(layout, 1);
		layout.setSizeFull();
		layout.setMargin(false);
		layout.setSpacing(false);
		tabsheet.setSizeFull();
		tabsheet.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
		layout.addComponent(tabsheet);
	
	}
	
	protected void addTab(EntryView<T> view) {
		entryViews.add(view);
		tabsheet.addComponent(view.getView());
	}
	
	protected void addTab(Component view) {
		tabsheet.addComponent(view);
	}

	
	@Override
	public void setDataInitWrapper(E data) {
		this.dataInitWrapperDto = data;

	}

	@Override
	public E getDataInitWrapper() {

		if (this.dataInitWrapperDto == null) {
			throw new RuntimeException("No init data found.");
		}
		return this.dataInitWrapperDto;
	}

	@Override
	public void loadData(T data) {
		this.data = data;
		for (EntryView<T> entryView : entryViews) {
			entryView.loadData(this.data);
		}
	}

	@Override
	public void setSaveEntityListener(SaveEnityListener<T> saveEnityListener) {
		this.saveEnityListener = saveEnityListener;
	}

	@Override
	public void setRefreshEntityListener(RefreshEntityListener<T> refreshEntityListener) {
		this.refreshEntityListener = refreshEntityListener;
		
	}

	
	

}
