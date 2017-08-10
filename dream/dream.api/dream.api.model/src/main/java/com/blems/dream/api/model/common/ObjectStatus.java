package com.blems.dream.api.model.common;

import org.apache.ibatis.type.Alias;

import com.blems.dream.api.model.BasedModel2;

@Alias("ObjectStatus")
public class ObjectStatus extends BasedModel2 {
	
	private static final long serialVersionUID = 1L;
	
	
	public static final int PO=2;
	
	
	private ObjectName objectName;

	public ObjectStatus() {}
	
	public ObjectStatus(int id) {
		setId(id);
	}
	
	public ObjectName getObjectName() {
		return objectName;
	}

	public void setObjectName(ObjectName objectName) {
		this.objectName = objectName;
	}
	
	public static ObjectStatus get(int id) {
		return new ObjectStatus(id);
	}
}
