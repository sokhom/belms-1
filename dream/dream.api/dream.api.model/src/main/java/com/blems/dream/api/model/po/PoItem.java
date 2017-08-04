package com.blems.dream.api.model.po;

import java.util.Date;

import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.common.ObjectStatus;
import com.blems.dream.api.model.common.ObjectType;
import com.blems.dream.api.model.customer.Customer;
import com.blems.dream.api.model.part.Part;
import com.blems.dream.api.model.tax.TaxRate;
import com.blems.dream.api.model.uom.Uom;

public class PoItem extends BasedModel {

	private static final long serialVersionUID = 1L;

	private Po po;
	private Customer customer;
	private ObjectStatus status;
	private ObjectType type;
	private Part part;
	private String description;
	private boolean repairFlag;
	private String note;
	private String partNum;
	private String vendorPartNum;
	private Uom uom;
	private double qtyToFullFill;
	private double qtyPicked;
	private double qtyFullFilled;
	private double unitCost;
	private TaxRate taxRate;
	private double taxRateValue;
	private double totalCost;
	private Date dateScheduledFulfillment;
	private Date dateLastFulfillment;
	private int seq;

	public Po getPo() {
		return po;
	}

	public void setPo(Po po) {
		this.po = po;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ObjectStatus getStatus() {
		return status;
	}

	public void setStatus(ObjectStatus status) {
		this.status = status;
	}

	public ObjectType getType() {
		return type;
	}

	public void setType(ObjectType type) {
		this.type = type;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isRepairFlag() {
		return repairFlag;
	}

	public void setRepairFlag(boolean repairFlag) {
		this.repairFlag = repairFlag;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPartNum() {
		return partNum;
	}

	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}

	public String getVendorPartNum() {
		return vendorPartNum;
	}

	public void setVendorPartNum(String vendorPartNum) {
		this.vendorPartNum = vendorPartNum;
	}

	public Uom getUom() {
		return uom;
	}

	public void setUom(Uom uom) {
		this.uom = uom;
	}

	public double getQtyToFullFill() {
		return qtyToFullFill;
	}

	public void setQtyToFullFill(double qtyToFullFill) {
		this.qtyToFullFill = qtyToFullFill;
	}

	public double getQtyPicked() {
		return qtyPicked;
	}

	public void setQtyPicked(double qtyPicked) {
		this.qtyPicked = qtyPicked;
	}

	public double getQtyFullFilled() {
		return qtyFullFilled;
	}

	public void setQtyFullFilled(double qtyFullFilled) {
		this.qtyFullFilled = qtyFullFilled;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	public TaxRate getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(TaxRate taxRate) {
		this.taxRate = taxRate;
	}

	public double getTaxRateValue() {
		return taxRateValue;
	}

	public void setTaxRateValue(double taxRateValue) {
		this.taxRateValue = taxRateValue;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Date getDateScheduledFulfillment() {
		return dateScheduledFulfillment;
	}

	public void setDateScheduledFulfillment(Date dateScheduledFulfillment) {
		this.dateScheduledFulfillment = dateScheduledFulfillment;
	}

	public Date getDateLastFulfillment() {
		return dateLastFulfillment;
	}

	public void setDateLastFulfillment(Date dateLastFulfillment) {
		this.dateLastFulfillment = dateLastFulfillment;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

}
