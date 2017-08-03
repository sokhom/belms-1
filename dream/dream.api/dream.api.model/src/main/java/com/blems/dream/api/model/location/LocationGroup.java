package com.blems.dream.api.model.location;

import org.apache.ibatis.type.Alias;

import com.blems.dream.api.model.DefaultModel;

@Alias("LocationGroup")
public class LocationGroup extends DefaultModel {

	private static final long serialVersionUID = 1L;
	
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
