package com.blems.dream.api.model.vendor;

import org.apache.ibatis.type.Alias;

import com.blems.dream.api.model.DefaultModel;
import com.blems.dream.api.model.account.Account;
import com.blems.dream.api.model.carrier.Carrier;
import com.blems.dream.api.model.common.ObjectStatus;
import com.blems.dream.api.model.currency.Currency;
import com.blems.dream.api.model.payment.PaymentTerm;
import com.blems.dream.api.model.ship.ShipTerm;

@Alias("Vendor")
public class Vendor extends DefaultModel {
	private static final long serialVersionUID = 1L;
	private Account account;
	private ObjectStatus status;
	private String node;
	private Currency currency;
	private double currencyRate;
	private double creditLimit;
	private double minQtyOrderAmount;
	private int leadTime;
	private PaymentTerm defaultPaymentTerm;
	private ShipTerm defaultShipTerm;
	private Carrier defaultCarrier;
	private String url;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public ObjectStatus getStatus() {
		return status;
	}
	public void setStatus(ObjectStatus status) {
		this.status = status;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public double getCurrencyRate() {
		return currencyRate;
	}
	public void setCurrencyRate(double currencyRate) {
		this.currencyRate = currencyRate;
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	public double getMinQtyOrderAmount() {
		return minQtyOrderAmount;
	}
	public void setMinQtyOrderAmount(double minQtyOrderAmount) {
		this.minQtyOrderAmount = minQtyOrderAmount;
	}
	public int getLeadTime() {
		return leadTime;
	}
	public void setLeadTime(int leadTime) {
		this.leadTime = leadTime;
	}
	public PaymentTerm getDefaultPaymentTerm() {
		return defaultPaymentTerm;
	}
	public void setDefaultPaymentTerm(PaymentTerm defaultPaymentTerm) {
		this.defaultPaymentTerm = defaultPaymentTerm;
	}
	public ShipTerm getDefaultShipTerm() {
		return defaultShipTerm;
	}
	public void setDefaultShipTerm(ShipTerm defaultShipTerm) {
		this.defaultShipTerm = defaultShipTerm;
	}
	public Carrier getDefaultCarrier() {
		return defaultCarrier;
	}
	public void setDefaultCarrier(Carrier defaultCarrier) {
		this.defaultCarrier = defaultCarrier;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	

}
