package com.blems.dream.api.model.common;

import org.apache.ibatis.type.Alias;

import com.blems.dream.api.model.BasedModel2;


@Alias("ObjectType")
public class ObjectType extends BasedModel2 {

	private static final long serialVersionUID = 1L;
	private ObjectName objectName;

	
	public ObjectType() {
	}
	
	public ObjectType(int id) {
		 setId(id);
	}
	
	public ObjectName getObjectName() {
		return objectName;
	}

	public void setObjectName(ObjectName objectName) {
		this.objectName = objectName;
	}
	
}
