package com.blems.dream.api.model.vendor;

import com.blems.dream.api.model.BasedModel3;
import com.blems.dream.api.model.part.Part;
import com.blems.dream.api.model.uom.Uom;

public class VendorPart extends BasedModel3 {

	private static final long serialVersionUID = 1L;
	private Part part;
	private Vendor vendor;
	private String vendorPartNumber;
	private int qtyMin;
	private int qtyMax;
	private Uom uom;
	private int leadTime;
	private double lastCost;

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public String getVendorPartNumber() {
		return vendorPartNumber;
	}

	public void setVendorPartNumber(String vendorPartNumber) {
		this.vendorPartNumber = vendorPartNumber;
	}

	public int getQtyMin() {
		return qtyMin;
	}

	public void setQtyMin(int qtyMin) {
		this.qtyMin = qtyMin;
	}

	public int getQtyMax() {
		return qtyMax;
	}

	public void setQtyMax(int qtyMax) {
		this.qtyMax = qtyMax;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public int getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(int leadTime) {
		this.leadTime = leadTime;
	}

	public double getLastCost() {
		return lastCost;
	}

	public void setLastCost(double lastCost) {
		this.lastCost = lastCost;
	}

}
