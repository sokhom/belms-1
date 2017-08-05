/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.api.dto.address;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.blems.dream.api.model.address.Country;
import com.blems.dream.api.model.address.State;
import com.blems.dream.api.model.common.ObjectType;

public class AddressInitDataWrapperDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<ObjectType> addressTypes;
	private List<Country> countries;
	private List<State> states;
	private List<ObjectType> contactTypes;
	
	public void addAddressType(ObjectType addressType){
		if(addressTypes == null ){
			addressTypes = new ArrayList<>();
		}
		addressTypes.add(addressType);
	}
	
	public void addCountry(Country country){
		if(countries == null ){
			countries = new ArrayList<>();
		}
		
		countries.add(country);
	}
	
	public void addState(State state) {
		if(states==null){
			states = new ArrayList<>();
		}
		states.add(state);
	}
	
	
	public void addContactType(ObjectType contactType){
		if(contactTypes==null){
			contactTypes = new ArrayList<>();
		}
		
		contactTypes.add(contactType);
	}
	
	
	public List<Country> getCountries() {
		return countries;
	}
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	public List<State> getStates() {
		return states;
	}
	public void setStates(List<State> states) {
		this.states = states;
	}

	public List<ObjectType> getAddressTypes() {
		return addressTypes;
	}

	public void setAddressTypes(List<ObjectType> addressTypes) {
		this.addressTypes = addressTypes;
	}

	public List<ObjectType> getContactTypes() {
		return contactTypes;
	}

	public void setContactTypes(List<ObjectType> contactTypes) {
		this.contactTypes = contactTypes;
	}

	
	
	

}
