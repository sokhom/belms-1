package com.blems.dream.api.model.part;

import com.blems.dream.api.model.BasedModel;

public class PartToTracking extends BasedModel{

	private static final long serialVersionUID = 1L;
	
	private Part part;
	private PartTracking partTracking;
	private boolean primaryFlag;
	private String nextValue;
	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
	}
	
	public PartTracking getPartTracking() {
		return partTracking;
	}
	public void setPartTracking(PartTracking partTracking) {
		this.partTracking = partTracking;
	}
	public boolean isPrimaryFlag() {
		return primaryFlag;
	}
	public void setPrimaryFlag(boolean primaryFlag) {
		this.primaryFlag = primaryFlag;
	}
	public String getNextValue() {
		return nextValue;
	}
	public void setNextValue(String nextValue) {
		this.nextValue = nextValue;
	}
	
	
	

}
