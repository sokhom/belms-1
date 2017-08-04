package com.blems.dream.api.model.part;

import com.blems.dream.api.model.BasedModel2;
import com.blems.dream.api.model.common.ObjectType;

public class PartTracking extends BasedModel2 {

	private static final long serialVersionUID = 1L;
	private boolean activeFlag;
	private String abbr;
	private String name;
	private ObjectType type;
	private String description;
	private int seq;

	public boolean isActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ObjectType getType() {
		return type;
	}

	public void setType(ObjectType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

}
