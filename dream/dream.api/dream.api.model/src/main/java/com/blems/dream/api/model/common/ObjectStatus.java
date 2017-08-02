package com.blems.dream.api.model.common;

import org.apache.ibatis.type.Alias;

import com.blems.dream.api.model.BasedModel2;

@Alias("ObjectStatus")
public class ObjectStatus extends BasedModel2 {

	private static final long serialVersionUID = 1L;
	
	private ObjectName objectName;

	public ObjectName getObjectName() {
		return objectName;
	}

	public void setObjectName(ObjectName objectName) {
		this.objectName = objectName;
	}
	
	
}
