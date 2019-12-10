package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(include = Inclusion.NON_NULL)
public class PaymentTypeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int payTypeId;
	private String payTypeCode;
	private String payTypeDispCode;
	private String imagePath;
	private HashMap<Integer, String> subTypeMap;
	private HashMap<Integer, String> subTypeMapPortal;
	private HashMap<Integer, String> providerMap;
	private HashMap<Integer, String> currencyMap;
	private String contentPath;
	private int uiOrder;
	private LinkedHashMap<Integer,String> finalMap;

	private Double minValue;
	private Double maxValue;

	public String getPayTypeCode() {
		return payTypeCode;
	}

	public void setPayTypeCode(String payTypeCode) {
		this.payTypeCode = payTypeCode;
	}

	public String getPayTypeDispCode() {
		return payTypeDispCode;
	}

	public void setPayTypeDispCode(String payTypeDispCode) {
		this.payTypeDispCode = payTypeDispCode;
	}

	public void setPayTypeId(int payTypeId) {
		this.payTypeId = payTypeId;
	}

	public int getPayTypeId() {
		return payTypeId;
	}

	public HashMap<Integer, String> getSubTypeMap() {
		return subTypeMap;
	}

	public void setSubTypeMap(HashMap<Integer, String> subTypeMap) {
		this.subTypeMap = subTypeMap;
	}

	public void setCurrencyMap(HashMap<Integer, String> currencyMap) {
		this.currencyMap = currencyMap;
	}

	public HashMap<Integer, String> getCurrencyMap() {
		return currencyMap;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}

	public String getContentPath() {
		return contentPath;
	}

	public void setProviderMap(HashMap<Integer, String> providerMap) {
		this.providerMap = providerMap;
	}

	public HashMap<Integer, String> getProviderMap() {
		return providerMap;
	}

	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}

	public Double getMinValue() {
		return minValue;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public Double getMaxValue() {
		return maxValue;
	}

	public int getUiOrder() {
		return uiOrder;
	}

	public void setUiOrder(int uiOrder) {
		this.uiOrder = uiOrder;
	}

	public LinkedHashMap<Integer, String> getFinalMap() {
		return finalMap;
	}

	public void setFinalMap(LinkedHashMap<Integer, String> finalMap) {
		this.finalMap = finalMap;
	}
	public HashMap<Integer, String> getSubTypeMapPortal() {
		return subTypeMapPortal;
	}

	public void setSubTypeMapPortal(HashMap<Integer, String> subTypeMapPortal) {
		this.subTypeMapPortal = subTypeMapPortal;
	}

}
