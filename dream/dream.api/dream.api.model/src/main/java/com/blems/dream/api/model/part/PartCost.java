package com.blems.dream.api.model.part;

import com.blems.dream.api.model.BasedModel3;

public class PartCost extends BasedModel3 {

	private static final long serialVersionUID = 1L;
	private Part part;
	private double qty;
	private double totalCost;
	private double avgCost;

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getAvgCost() {
		return avgCost;
	}

	public void setAvgCost(double avgCost) {
		this.avgCost = avgCost;
	}

}
