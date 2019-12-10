package com.stpl.pms.javabeans;

import java.io.Serializable;

public class RegistrationFieldBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String fieldName;
	private String fieldValue;
	private String isUnique;
	private String returnStr;	
	
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getIsUnique() {
		return isUnique;
	}

	public void setIsUnique(String isUnique) {
		this.isUnique = isUnique;
	}

	public String getReturnStr() {
		return returnStr;
	}

	public void setReturnStr(String returnStr) {
		this.returnStr = returnStr;
	}
	
}
