package com.blems.dream.api.model.uom;

import com.blems.dream.api.model.DefaultModel;
import com.blems.dream.api.model.common.ObjectType;

public class Uom extends DefaultModel{

	private static final long serialVersionUID = 1L;
	private boolean defaultFlag;
	private String code;
	private String description;
	private ObjectType type;
	private boolean readOnlyFlag;
	
	public Uom() {
		
	}
	
	public Uom(int id) {
		super(id);
	}
	
	
	public boolean isDefaultFlag() {
		return defaultFlag;
	}

	public void setDefaultFlag(boolean defaultFlag) {
		this.defaultFlag = defaultFlag;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ObjectType getType() {
		return type;
	}
	public void setType(ObjectType type) {
		this.type = type;
	}
	public boolean isReadOnlyFlag() {
		return readOnlyFlag;
	}
	public void setReadOnlyFlag(boolean readOnlyFlag) {
		this.readOnlyFlag = readOnlyFlag;
	}
	
	

}
