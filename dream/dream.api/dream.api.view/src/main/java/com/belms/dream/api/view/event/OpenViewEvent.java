package com.belms.dream.api.view.event;

import com.blems.dream.api.model.ui.FilterItemList;
import com.vaadin.ui.TabSheet;

public class OpenViewEvent {
	
	public enum OPEN_AS { NORMAL , TAB, SUB_WINDOW  }
	private OPEN_AS as;
	private String viewId;
	private FilterItemList  filterItemList;
	private TabSheet parent;
	public OpenViewEvent(OPEN_AS as, String viewId, TabSheet parent, FilterItemList  filterItemList) {
		this(as, viewId,parent);
		this.filterItemList= filterItemList;
	}
	
	public OpenViewEvent(OPEN_AS as, String viewId, TabSheet parent ) {
		this(as, viewId);
		this.parent = parent;
	}
	
	public OpenViewEvent(OPEN_AS as, String viewId ) {
		this.as = as;
		this.viewId = viewId;
	}

	public OPEN_AS getAs() {
		return as;
	}

	public String getViewId() {
		return viewId;
	}

	public TabSheet getParent() {
		return parent;
	}

	public FilterItemList getFilterItemList() {
		return filterItemList;
	}

	
	
}
