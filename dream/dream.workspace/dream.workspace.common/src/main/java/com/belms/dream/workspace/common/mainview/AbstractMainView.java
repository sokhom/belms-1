package com.belms.dream.workspace.common.mainview;

import java.util.ArrayList;
import java.util.List;

import com.belms.dream.api.view.event.EventBusProvider;
import com.belms.dream.workspace.common.newview.AbstractNewView;
import com.blems.dream.api.model.DefaultModel;
import com.blems.dream.api.model.ui.FilterItemList;
import com.vaadin.data.Binder;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutListener;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public abstract class AbstractMainView<T extends FilterItemList, E extends DefaultModel, W> extends Panel
		implements MainLayoutView<T, E, W> {

	private static final long serialVersionUID = 1L;
	private FilterListener filterListener;
	private ShowSlectedItemListener<T> showSlectedItemListener;
	private List<T> itemList = new ArrayList<>();
	private W dataInitWrapperDto;
	private final EventBusProvider eventBusProvider;
	private final TabSheet tabsheet = new TabSheet();

	protected final Binder<E> binder = new Binder<>();

	public AbstractMainView(final EventBusProvider eventBusProvider) {
		this.eventBusProvider = eventBusProvider;
	}

	@Override
	public EventBusProvider getEventBusProvider() {
		return eventBusProvider;
	}

	public abstract AbstractNewView getNewView();

	@Override
	public void initView() {
		final VerticalLayout mainViewArea = new VerticalLayout();

		mainViewArea.setMargin(false);
		mainViewArea.setSpacing(false);
		mainViewArea.setSizeFull();
		mainViewArea.addComponent(buildMenuber());
		buildViewArea(mainViewArea);
	
		final HorizontalSplitPanel splitPanel = new HorizontalSplitPanel(buildItemListLayout(), mainViewArea);
		setContent(splitPanel);
		splitPanel.setSizeFull();
		splitPanel.setSplitPosition(200, Unit.PIXELS);
		splitPanel.setMinSplitPosition(100, Unit.PIXELS);
		splitPanel.setMaxSplitPosition(600, Unit.PIXELS);
		setSizeFull();

	}

	private Component buildMenuber() {

		final MenuBar menubar = new MenuBar();
		menubar.setWidth(100.0f, Unit.PERCENTAGE);
		menubar.addStyleName(ValoTheme.MENUBAR_BORDERLESS);
		menubar.addItem("New", VaadinIcons.FILE_ADD, selectedItem-> UI.getCurrent().addWindow(getNewView()));
		menubar.addItem("Edit", VaadinIcons.EDIT, selectedItem -> {
		});
		final MenuItem saveItem = menubar.addItem("Save", VaadinIcons.CHECK, selectedItem -> {
		});
		saveItem.setEnabled(false);

		final MenuItem removeItem = menubar.addItem("Remove", VaadinIcons.FILE_REMOVE, selectedItem -> {
		});
		removeItem.setEnabled(false);
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
	
	protected void addTab(Component component) {
		tabsheet.addComponent(component);
	}

	private Component buildItemListLayout() {
		VerticalLayout itemListLayout = new VerticalLayout();
		final Component itemList = buildItemList();
		itemListLayout.addStyleName("itemlist");
		itemListLayout.setMargin(false);
		itemListLayout.setSpacing(false);
		itemListLayout.addComponent(buildFilterLayout());
		itemListLayout.addComponent(itemList);
		itemListLayout.setExpandRatio(itemList, 1);
		itemListLayout.setSizeFull();
		itemList.setSizeFull();
		return itemListLayout;
	}

	private Component buildFilterLayout() {
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setMargin(false);
		horizontalLayout.setSpacing(false);
		horizontalLayout.setWidth(100, Unit.PERCENTAGE);
		final Component component = buildFilter();
		horizontalLayout.addComponent(component);
		horizontalLayout.addComponent(buildAdvanceSearch());
		horizontalLayout.setExpandRatio(component, 1);
		return horizontalLayout;
	}

	private Component buildAdvanceSearch() {

		final Button button = new Button(VaadinIcons.ELLIPSIS_CIRCLE_O);
		return button;
	}

	@SuppressWarnings("serial")
	private Component buildFilter() {
		final TextField filter = new TextField();
		filter.setPlaceholder("Filter");
		filter.setIcon(VaadinIcons.SEARCH);
		filter.addStyleName(ValoTheme.TEXTFIELD_INLINE_ICON);
		filter.setWidth(100, Unit.PERCENTAGE);
		filter.addShortcutListener(new ShortcutListener("Clear", KeyCode.ESCAPE, null) {
			@Override
			public void handleAction(final Object sender, final Object target) {
				filter.setValue("");
			}
		});
		filter.addValueChangeListener(event -> {
			if (filterListener != null) {
				filterListener.actionPerformed(event.getValue());
			}
		});

		return filter;

	}

	private Component buildItemList() {
		final Grid<T> itemListGrid = new Grid<>();
		itemListGrid.setSizeFull();

		itemListGrid.setDataProvider(
				new CallbackDataProvider<>(query -> this.itemList.stream(), query -> this.itemList.size()));

		itemListGrid.setSelectionMode(SelectionMode.SINGLE);
		itemListGrid.addColumn(FilterItemList::getName).setCaption("Name");
		itemListGrid.addColumn(FilterItemList::getDescription).setCaption("Description");
		itemListGrid.addSelectionListener(event -> {
			if (event.getFirstSelectedItem().isPresent()) {
				this.showSlectedItemListener.itemSelected(event.getFirstSelectedItem().get());
			}

		});
		return itemListGrid;
	}

	@Override
	public void setDataInitWrapper(W data) {
		this.dataInitWrapperDto = data;

	}

	@Override
	public W getDataInitWrapper() {

		if (this.dataInitWrapperDto == null) {
			throw new RuntimeException("No init data found.");
		}
		return this.dataInitWrapperDto;
	}

	@Override
	public void loadData(E data) {
		binder.setBean(data);
	}

	public void setFilterListener(FilterListener filterListener) {
		this.filterListener = filterListener;
	}

	@Override
	public void setItemListData(List<T> itemList) {
		this.itemList = itemList;

	}

	@Override
	public void setShowItemListener(ShowSlectedItemListener<T> showSlectedItemListener) {
		this.showSlectedItemListener = showSlectedItemListener;

	}

}
