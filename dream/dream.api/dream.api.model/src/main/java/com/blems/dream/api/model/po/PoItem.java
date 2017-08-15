package com.blems.dream.api.model.po;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.blems.dream.api.model.AutoCalc;
import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.common.ObjectStatus;
import com.blems.dream.api.model.common.ObjectType;
import com.blems.dream.api.model.customer.Customer;
import com.blems.dream.api.model.part.Part;
import com.blems.dream.api.model.tax.TaxRate;
import com.blems.dream.api.model.uom.Uom;

@Alias("PoItem")
public class PoItem extends BasedModel implements AutoCalc {

	private static final long serialVersionUID = 1L;
	
	
	public static final ObjectStatus STATUS_ITEM_ENTERED = new ObjectStatus(10, "Enterd");
	public static final ObjectStatus STATUS_ITEM_PICKING = new ObjectStatus(10, "Picking");
	public static final ObjectStatus STATUS_ITEM_PARTIAL = new ObjectStatus(10, "Partial");
	public static final ObjectStatus STATUS_ITEM_PICKED = new ObjectStatus(10, "Picked");
	public static final ObjectStatus STATUS_ITEM_SHIPPED = new ObjectStatus(10, "Shipped");
	public static final ObjectStatus STATUS_ITEM_FULFILLED = new ObjectStatus(10, "Fulfilled");
	public static final ObjectStatus STATUS_ITEM_CLOSED_SHORT = new ObjectStatus(10, "Closed Short");
	public static final ObjectStatus STATUS_ITEM_VOID = new ObjectStatus(10, "Void");
	
	public static final ObjectType TYPE_PURCHASE = new  ObjectType(10, "Purchase");
	public static final ObjectType TYPE_MISC_PURCHASE = new  ObjectType(11, "Misc. Purchase");
	public static final ObjectType TYPE_CREDIT_RETURN = new  ObjectType(20, "Credit Return");
	public static final ObjectType TYPE_MISC_CREDIT = new  ObjectType(20, "Misc. Credit");
	public static final ObjectType TYPE_OUT_SOURCE = new  ObjectType(20, "Out Sourced");
	
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
	private double qtyToFulfill;
	private double qtyPicked;
	private double qtyFulfilled;
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

	

	public double getQtyPicked() {
		return qtyPicked;
	}

	public void setQtyPicked(double qtyPicked) {
		this.qtyPicked = qtyPicked;
	}

	

	public double getQtyToFulfill() {
		return qtyToFulfill;
	}

	public void setQtyToFulfill(double qtyToFulfill) {
		this.qtyToFulfill = qtyToFulfill;
	}

	public double getQtyFulfilled() {
		return qtyFulfilled;
	}

	public void setQtyFulfilled(double qtyFulfilled) {
		this.qtyFulfilled = qtyFulfilled;
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
	
	public  void initData(Part part) {
		this.setDescription(part.getDescription());
		this.setOper(OPER.ADD);
		this.setPart(part);
		this.setPartNum(part.getNum());
		this.setQtyToFulfill(1);
		this.setRepairFlag(false);
		this.setSeq(1);
		this.setStatus(STATUS_ITEM_ENTERED); //enter
		this.setUnitCost(0);
		this.setTotalCost(0);
		this.setType(TYPE_PURCHASE); //purchase
		this.setUom(part.getUom());
	}

	@Override
	public void calc() {
		setTotalCost(this.getQtyToFulfill() * this.getUnitCost());
		
	}

}
