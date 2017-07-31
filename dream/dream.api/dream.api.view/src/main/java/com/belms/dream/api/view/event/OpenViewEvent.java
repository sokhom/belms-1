package com.belms.dream.api.view.event;

import com.vaadin.ui.Component;

public class OpenViewEvent {
	
	public enum OPEN_AS { NORMAL , TAB, SUB_WINDOW  }
	private OPEN_AS as;
	private String viewId;
	private int id;
	private Component parent;
	public OpenViewEvent(OPEN_AS as, String viewId, Component parent, int id ) {
		this(as, viewId,parent);
		this.id= id;
	}
	
	public OpenViewEvent(OPEN_AS as, String viewId, Component parent ) {
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

	public Component getParent() {
		return parent;
	}

	public int getId() {
		return id;
	}
	
}
