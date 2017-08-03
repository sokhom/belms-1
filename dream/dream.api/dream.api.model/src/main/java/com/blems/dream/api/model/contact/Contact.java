/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.contact;

import org.apache.ibatis.type.Alias;

import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.account.Account;
import com.blems.dream.api.model.address.Address;
import com.blems.dream.api.model.common.ObjectType;


@Alias("Contact")
public class Contact extends BasedModel {

	private static final long serialVersionUID = 1L;
	private Account account;
	private Address address;
	private String name;
	private String contact;
	private ObjectType type;
	private boolean defaultFlag;
	
	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	public ObjectType getType() {
		return type;
	}


	public void setType(ObjectType type) {
		this.type = type;
	}


	public boolean isDefaultFlag() {
		return defaultFlag;
	}
	public void setDefaultFlag(boolean defaultFlag) {
		this.defaultFlag = defaultFlag;
	}

	
}
