package com.belms.dream.workspace.search;

import com.belms.dream.api.view.event.EventBusProvider;
import com.belms.dream.api.view.event.OpenViewEvent;
import com.belms.dream.api.view.event.OpenViewEvent.OPEN_AS;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutListener;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class SearchViewImpl extends Panel implements SearchView {
	private static final long serialVersionUID = 1L;
	private final TabSheet tabsheet = new TabSheet();
	private final EventBusProvider eventBusProvider;

	public SearchViewImpl(final EventBusProvider eventBusProvider) {
		this.eventBusProvider = eventBusProvider;
		new SearchViewPresenter(this);
	}

	@Override
	public void initView() {
		eventBusProvider.register(this);
		setContent(tabsheet );
		final VerticalLayout mainViewArea = new VerticalLayout();
		mainViewArea.setCaption("Main");
		tabsheet.addComponent(mainViewArea);
		
		mainViewArea.setMargin(false);
		mainViewArea.setSpacing(false);
		mainViewArea.setSizeFull();
		buildToolbar(mainViewArea);
		buildGrid(mainViewArea);
	}
	
	private void buildToolbar(VerticalLayout root) {
		
		final HorizontalLayout layout = new HorizontalLayout();
		root.addComponent(layout);
		layout.setWidth(100, Unit.PERCENTAGE);
		layout.setHeight(100,Unit.PIXELS);
		layout.setWidth(100, Unit.PERCENTAGE);
		
		final MenuBar menuBar = new MenuBar();
		layout.addComponent(menuBar);
		menuBar.setHeightUndefined();
		menuBar.addStyleName(ValoTheme.MENUBAR_BORDERLESS);
		
		final MenuItem newMenuItem = menuBar.addItem("Actions", VaadinIcons.MENU, null);
		newMenuItem.addItem("Sale Order", selectedItem->{});
		newMenuItem.addItem("Purchase Order", selectedItem->{});
		newMenuItem.addItem("Transfer Order", selectedItem->{});
		newMenuItem.addSeparator();
		newMenuItem.addItem("New Customer", selectedItem->{
			eventBusProvider.post(new OpenViewEvent(OPEN_AS.SUB_WINDOW, "new_customer" ));
		});
		newMenuItem.addSeparator();
		newMenuItem.addItem("Picking", selectedItem->{});
		newMenuItem.addItem("Shipping", selectedItem->{});
		newMenuItem.addItem("Receiving", selectedItem->{});
		newMenuItem.addSeparator();
		newMenuItem.addItem("Inventory", selectedItem->{});
		newMenuItem.addSeparator();
		newMenuItem.addItem("Part", selectedItem->{});
		newMenuItem.addItem("Product", selectedItem->{});
		
		final HorizontalLayout searchLayout = new HorizontalLayout();
		
		layout.addComponent(searchLayout);
		layout.setExpandRatio(searchLayout, 1);
		searchLayout.setSpacing(false);
		searchLayout.setMargin(false);
		searchLayout.setWidth(100, Unit.PERCENTAGE);
		
		
		final TextField search = new TextField();
		searchLayout.addComponent(search);
		searchLayout.setExpandRatio(search, 1);
		search.setPlaceholder("Filter");
		search.setIcon(VaadinIcons.SEARCH);
		search.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
		search.setWidth(100, Unit.PERCENTAGE);
		search.addShortcutListener(new ShortcutListener("Clear", KeyCode.ESCAPE, null) {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void handleAction(final Object sender, final Object target) {
				search.setValue("");
			}
		});
		search.addValueChangeListener(event -> {
//			if (filterListener != null) {
//				filterListener.actionPerformed(event.getValue());
//			}
		});

	
		final Button button = new Button(VaadinIcons.ELLIPSIS_CIRCLE_O);
		searchLayout.addComponent(button);
		
		
	}
	
	
	private void buildGrid(VerticalLayout root) {
		final VerticalLayout layout = new VerticalLayout();
		root.addComponent(layout);
		root.setExpandRatio(layout, 1);
		
	}
	
	

}
