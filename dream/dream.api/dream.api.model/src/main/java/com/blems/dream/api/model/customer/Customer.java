/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.customer;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.blems.dream.api.model.DefaultModel;
import com.blems.dream.api.model.account.Account;
import com.blems.dream.api.model.address.Address;
import com.blems.dream.api.model.carrier.Carrier;
import com.blems.dream.api.model.carrier.CarrierService;
import com.blems.dream.api.model.common.ObjectStatus;
import com.blems.dream.api.model.currency.Currency;
import com.blems.dream.api.model.payment.PaymentTerm;
import com.blems.dream.api.model.ship.ShipTerm;
import com.blems.dream.api.model.ui.FilterItemList;

@Alias("Customer")
public class Customer extends DefaultModel implements FilterItemList  {
	
	private static final long serialVersionUID = 1L;
	
	public final static String OBJECT_NAME = "Customer";
	
	
	private Account account;
	private CarrierService carrierService;
	private Carrier defaultCarrier;
	private PaymentTerm defaultPaymentTerm;
	private int defaultSalePersonId;
	private ShipTerm defaultShipTerm;
	private ObjectStatus status;
	private String url;
	private String note;
	private double creditLimit;
	private Currency currency;
	private boolean toBeEmailed;
	private boolean toBePrinted;
	private List<Address> addresses;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

	public CarrierService getCarrierService() {
		return carrierService;
	}
	public void setCarrierService(CarrierService carrierService) {
		this.carrierService = carrierService;
	}
	public Carrier getDefaultCarrier() {
		return defaultCarrier;
	}
	public void setDefaultCarrier(Carrier defaultCarrier) {
		this.defaultCarrier = defaultCarrier;
	}
	public PaymentTerm getDefaultPaymentTerm() {
		return defaultPaymentTerm;
	}
	public void setDefaultPaymentTerm(PaymentTerm defaultPaymentTerm) {
		this.defaultPaymentTerm = defaultPaymentTerm;
	}
	public int getDefaultSalePersonId() {
		return defaultSalePersonId;
	}
	public void setDefaultSalePersonId(int defaultSalePersonId) {
		this.defaultSalePersonId = defaultSalePersonId;
	}
	public ShipTerm getDefaultShipTerm() {
		return defaultShipTerm;
	}
	public void setDefaultShipTerm(ShipTerm defaultShipTerm) {
		this.defaultShipTerm = defaultShipTerm;
	}
	
	public ObjectStatus getStatus() {
		return status;
	}
	public void setStatus(ObjectStatus status) {
		this.status = status;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public boolean isToBeEmailed() {
		return toBeEmailed;
	}
	public void setToBeEmailed(boolean toBeEmailed) {
		this.toBeEmailed = toBeEmailed;
	}
	public boolean isToBePrinted() {
		return toBePrinted;
	}
	public void setToBePrinted(boolean toBePrinted) {
		this.toBePrinted = toBePrinted;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getAddress(){
		
		String addresss ="N/A";
		
		if(getAddresses()!=null && !getAddresses().isEmpty()){
			addresss= getAddresses().get(0).getFullAddress();
			for (Address address : addresses) {
				if(address.isDefaultFlag()){
					addresss= getAddresses().get(0).getFullAddress();
					break;
				}
			}
		}
		
		
		
		return addresss;
	}
	@Override
	public String getDescription() {
		return null;
	}
	@Override
	public String getObjectName() {
		return OBJECT_NAME;
	}
	@Override
	public String getObjectIndentifier() {
		return "customer";
	}
	
	
}
