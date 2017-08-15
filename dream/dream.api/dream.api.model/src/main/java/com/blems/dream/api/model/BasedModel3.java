package com.blems.dream.api.model;

import java.util.Date;

public abstract class BasedModel3 extends BasedModel {

	private static final long serialVersionUID = 1L;

	private Date dateCreated;
	private Date dateLastModified;
	private int lastChangedUserId;

	public BasedModel3() {
	
	}
	
	public BasedModel3(int id) {
		super(id);
	}
	
	public Date getDateCreated() {
		if(dateCreated==null) {
			dateCreated = new Date();
		}
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateLastModified() {
		if(dateLastModified == null) {
			dateLastModified = new Date();
		}
		return dateLastModified;
	}

	public void setDateLastModified(Date dateLastModified) {
		this.dateLastModified = dateLastModified;
	}

	public int getLastChangedUserId() {
		return lastChangedUserId;
	}

	public void setLastChangedUserId(int lastChangedUserId) {
		this.lastChangedUserId = lastChangedUserId;
	}

}
