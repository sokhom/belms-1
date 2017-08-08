package com.blems.dream.api.model.tax;

import org.apache.ibatis.type.Alias;

import com.blems.dream.api.model.DefaultModel;
import com.blems.dream.api.model.coa.ChartAccount;
import com.blems.dream.api.model.common.ObjectType;

@Alias("TaxRate")
public class TaxRate extends DefaultModel{
	private static final long serialVersionUID = 1L;
	private ChartAccount coa;
	private ObjectType orderType;
	private ObjectType type;
	private String code;
	private String description;
	private double rate;
	private boolean defaultFlag;
	
	public TaxRate() {
		
	}
	public TaxRate(int id) {
		super(id);
	}
	
	
	public ChartAccount getCoa() {
		return coa;
	}
	public void setCoa(ChartAccount coa) {
		this.coa = coa;
	}
	public ObjectType getOrderType() {
		return orderType;
	}
	public void setOrderType(ObjectType orderType) {
		this.orderType = orderType;
	}
	public ObjectType getType() {
		return type;
	}
	public void setType(ObjectType type) {
		this.type = type;
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
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public boolean isDefaultFlag() {
		return defaultFlag;
	}
	public void setDefaultFlag(boolean defaultFlag) {
		this.defaultFlag = defaultFlag;
	}

		

}
