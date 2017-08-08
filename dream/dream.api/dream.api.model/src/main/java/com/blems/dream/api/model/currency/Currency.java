/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.currency;

import org.apache.ibatis.type.Alias;

import com.blems.dream.api.model.DefaultModel;

@Alias("Currency")
public class Currency extends DefaultModel {

	private static final long serialVersionUID = 1L;
	
	private String code;
	private double rate;
	private boolean homeCurrencyFlag;
	
	
	public Currency() {
	
	}
	
	public Currency(int id, String code , String name) {
		setId(id);
		setCode(code);
		setName(name);
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public boolean isHomeCurrencyFlag() {
		return homeCurrencyFlag;
	}

	public void setHomeCurrencyFlag(boolean homeCurrencyFlag) {
		this.homeCurrencyFlag = homeCurrencyFlag;
	}

	@Override
	public String toString() {
		return String.format("%s (%s)", getName(), getCode());
	}
	
	
	

}
