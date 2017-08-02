/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.payment;

import com.blems.dream.api.model.DefaultModel;
import com.blems.dream.api.model.common.ObjectType;

public class PaymentTerm extends DefaultModel{

	private static final long serialVersionUID = 1L;
	
	
	private ObjectType type;
	private boolean defaultTerm;
	
	private int netDays;
	private int nextMonth;
	
	private int discountDays;
	private double discount;
	
	private boolean readOnly;

	public PaymentTerm() {}
	
	public PaymentTerm(int id, String name) {
		setId(id);
		setName(name);
	}
	
	
	public ObjectType getType() {
		return type;
	}

	public void setType(ObjectType type) {
		this.type = type;
	}

	public boolean isDefaultTerm() {
		return defaultTerm;
	}

	public void setDefaultTerm(boolean defaultTerm) {
		this.defaultTerm = defaultTerm;
	}

	public int getNetDays() {
		return netDays;
	}

	public void setNetDays(int netDays) {
		this.netDays = netDays;
	}

	public int getNextMonth() {
		return nextMonth;
	}

	public void setNextMonth(int nextMonth) {
		this.nextMonth = nextMonth;
	}

	public int getDiscountDays() {
		return discountDays;
	}

	public void setDiscountDays(int discountDays) {
		this.discountDays = discountDays;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	@Override
	public String toString() {
		return getName();
	}
	
	
	
}

