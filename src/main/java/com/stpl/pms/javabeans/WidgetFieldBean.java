package com.stpl.pms.javabeans;

public class WidgetFieldBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String fieldName;
	private String fieldDispCode;
	private String validationExp;
	private String fieldInputType;
	private String url;
	private String isUnique;
	
	public WidgetFieldBean(){}
	
	public WidgetFieldBean(String fieldName, String fieldDispCode,
			String validationExp, String fieldInputType, String url, String isUnique) {
		super();
		this.fieldName = fieldName;
		this.fieldDispCode = fieldDispCode;
		this.validationExp = validationExp;
		this.fieldInputType = fieldInputType;
		this.url = url;
		this.isUnique = isUnique;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldDispCode() {
		return fieldDispCode;
	}
	public void setFieldDispCode(String fieldDispCode) {
		this.fieldDispCode = fieldDispCode;
	}
	public String getValidationExp() {
		return validationExp;
	}
	public void setValidationExp(String validationExp) {
		this.validationExp = validationExp;
	}
	public String getFieldInputType() {
		return fieldInputType;
	}
	public void setFieldInputType(String fieldInputType) {
		this.fieldInputType = fieldInputType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getIsUnique() {
		return isUnique;
	}

	public void setIsUnique(String isUnique) {
		this.isUnique = isUnique;
	}
	

}
