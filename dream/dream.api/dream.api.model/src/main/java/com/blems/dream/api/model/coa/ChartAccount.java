package com.blems.dream.api.model.coa;

import org.apache.ibatis.type.Alias;

import com.blems.dream.api.model.DefaultModel;
import com.blems.dream.api.model.common.ObjectType;

@Alias("ChartAccount")
public class ChartAccount extends DefaultModel {
	private static final long serialVersionUID = 1L;
	
	private ObjectType type;

	public ChartAccount() {

	}
	
	public ChartAccount(int id) {
		super(id);
	}
	
	public ObjectType getType() {
		return type;
	}

	public void setType(ObjectType type) {
		this.type = type;
	}
	
	

}
