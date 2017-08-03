package com.blems.dream.api.model.location;

import org.apache.ibatis.type.Alias;

import com.blems.dream.api.model.DefaultModel;
import com.blems.dream.api.model.common.ObjectType;

@Alias("Location")
public class Location extends DefaultModel {
	private static final long serialVersionUID = 1L;
	
	private String description;
	private boolean defaultFlag;
	private LocationGroup locationGroup;
	private ObjectType type;
	private boolean pickable;
	private boolean receivable;
	private boolean availableForSale;
	private int seq;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDefaultFlag() {
		return defaultFlag;
	}
	public void setDefaultFlag(boolean defaultFlag) {
		this.defaultFlag = defaultFlag;
	}
	public LocationGroup getLocationGroup() {
		return locationGroup;
	}
	public void setLocationGroup(LocationGroup locationGroup) {
		this.locationGroup = locationGroup;
	}
	public ObjectType getType() {
		return type;
	}
	public void setType(ObjectType type) {
		this.type = type;
	}
	public boolean isPickable() {
		return pickable;
	}
	public void setPickable(boolean pickable) {
		this.pickable = pickable;
	}
	public boolean isReceivable() {
		return receivable;
	}
	public void setReceivable(boolean receivable) {
		this.receivable = receivable;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public boolean isAvailableForSale() {
		return availableForSale;
	}
	public void setAvailableForSale(boolean availableForSale) {
		this.availableForSale = availableForSale;
	}
	
}
