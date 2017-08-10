package com.blems.dream.api.model.po;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.blems.dream.api.model.BasedModel3;
import com.blems.dream.api.model.address.Country;
import com.blems.dream.api.model.address.State;
import com.blems.dream.api.model.carrier.Carrier;
import com.blems.dream.api.model.common.ObjectStatus;
import com.blems.dream.api.model.currency.Currency;
import com.blems.dream.api.model.location.LocationGroup;
import com.blems.dream.api.model.payment.PaymentTerm;
import com.blems.dream.api.model.ship.ShipTerm;
import com.blems.dream.api.model.vendor.Vendor;

@Alias("Po")
public class Po extends BasedModel3 {

	private static final long serialVersionUID = 1L;
	
	private int num;
	private LocationGroup locationGroup;
	private ObjectStatus status;
	private int buyerId;
	private Currency currency;
	private double currencyRate;
	private String customerSo;
	private String vendorSo;
	private PaymentTerm paymentTerm;
	private Vendor vendor;
	private String vendorContact;
	private String vendorAddress;
	private String vendorCity;
	private Country vendorCountry;
	private State vendorState;
	private String vendorZip;
	private Carrier carrier;
	private ShipTerm shipTerm;
	private String shipToAddress;
	private String shipToCity;
	private Country shipToCountry;
	private State shipToState;
	private String shipToZip;
	private Date dateIssued;
	private Date dateFirstShip;
	private Date dateConfirmed;
	private Date dateCompleted;

	private List<PoItem> items;

	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public LocationGroup getLocationGroup() {
		return locationGroup;
	}

	public void setLocationGroup(LocationGroup locationGroup) {
		this.locationGroup = locationGroup;
	}

	public ObjectStatus getStatus() {
		return status;
	}

	public void setStatus(ObjectStatus status) {
		this.status = status;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
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

	public String getCustomerSo() {
		return customerSo;
	}

	public void setCustomerSo(String customerSo) {
		this.customerSo = customerSo;
	}

	public String getVendorSo() {
		return vendorSo;
	}

	public void setVendorSo(String vendorSo) {
		this.vendorSo = vendorSo;
	}

	public PaymentTerm getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(PaymentTerm paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public String getVendorContact() {
		return vendorContact;
	}

	public void setVendorContact(String vendorContact) {
		this.vendorContact = vendorContact;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorCity() {
		return vendorCity;
	}

	public void setVendorCity(String vendorCity) {
		this.vendorCity = vendorCity;
	}

	public Country getVendorCountry() {
		return vendorCountry;
	}

	public void setVendorCountry(Country vendorCountry) {
		this.vendorCountry = vendorCountry;
	}

	public State getVendorState() {
		return vendorState;
	}

	public void setVendorState(State vendorState) {
		this.vendorState = vendorState;
	}

	public String getVendorZip() {
		return vendorZip;
	}

	public void setVendorZip(String vendorZip) {
		this.vendorZip = vendorZip;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public ShipTerm getShipTerm() {
		return shipTerm;
	}

	public void setShipTerm(ShipTerm shipTerm) {
		this.shipTerm = shipTerm;
	}

	public String getShipToAddress() {
		return shipToAddress;
	}

	public void setShipToAddress(String shipToAddress) {
		this.shipToAddress = shipToAddress;
	}

	public String getShipToCity() {
		return shipToCity;
	}

	public void setShipToCity(String shipToCity) {
		this.shipToCity = shipToCity;
	}

	public Country getShipToCountry() {
		return shipToCountry;
	}

	public void setShipToCountry(Country shipToCountry) {
		this.shipToCountry = shipToCountry;
	}

	public State getShipToState() {
		return shipToState;
	}

	public void setShipToState(State shipToState) {
		this.shipToState = shipToState;
	}

	public String getShipToZip() {
		return shipToZip;
	}

	public void setShipToZip(String shipToZip) {
		this.shipToZip = shipToZip;
	}

	public Date getDateIssued() {
		return dateIssued;
	}

	public void setDateIssued(Date dateIssued) {
		this.dateIssued = dateIssued;
	}

	public Date getDateFirstShip() {
		return dateFirstShip;
	}

	public void setDateFirstShip(Date dateFirstShip) {
		this.dateFirstShip = dateFirstShip;
	}

	public Date getDateConfirmed() {
		return dateConfirmed;
	}

	public void setDateConfirmed(Date dateConfirmed) {
		this.dateConfirmed = dateConfirmed;
	}

	public Date getDateCompleted() {
		return dateCompleted;
	}

	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public List<PoItem> getItems() {
		return items;
	}

	public void setItems(List<PoItem> items) {
		this.items = items;
	}
	
	
	

}
