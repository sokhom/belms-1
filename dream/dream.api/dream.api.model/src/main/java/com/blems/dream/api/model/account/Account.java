/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.account;

import org.apache.ibatis.type.Alias;

import com.blems.dream.api.model.BasedModel;
import com.blems.dream.api.model.common.ObjectType;

@Alias("Account")
public class Account extends BasedModel {
	
	private static final long serialVersionUID = 1L;
	private ObjectType type;
	
	public ObjectType getType() {
		return type;
	}
	public void setType(ObjectType type) {
		this.type = type;
	}
	

}
