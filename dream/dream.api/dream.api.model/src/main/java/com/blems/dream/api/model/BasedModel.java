/***
 * @author ngounphanny
 * 
 */

package com.blems.dream.api.model;

import java.io.Serializable;

public abstract class BasedModel implements Serializable {

	public enum OPER {
		ADD, EDIT, DELETE, NONE
	};

	private static final long serialVersionUID = 1L;

	private int id;
	private OPER oper = OPER.NONE;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OPER getOper() {
		return oper;
	}

	public void setOper(OPER oper) {
		this.oper = oper;
	}

}
