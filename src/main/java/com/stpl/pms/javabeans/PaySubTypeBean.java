package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

public class PaySubTypeBean implements Serializable {

	private static final long serialVersionUID = 5121969714801351835L;
	
	private String typeCode;
	private Blob pinCode;
	private Integer typeId;
	private String cardName;
	private Integer subTypeId;
	private String status;
	private String city;
	private String cshpayTypeDispCode;
	private String bankNameDispCode;
	private Integer countryId;
	private Integer[] subTypeIdArr;
	
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public Integer getSubTypeId() {
		return subTypeId;
	}
	public void setSubTypeId(Integer subTypeId) {
		this.subTypeId = subTypeId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCshpayTypeDispCode() {
		return cshpayTypeDispCode;
	}
	public void setCshpayTypeDispCode(String cshpayTypeDispCode) {
		this.cshpayTypeDispCode = cshpayTypeDispCode;
	}
	public String getBankNameDispCode() {
		return bankNameDispCode;
	}
	public void setBankNameDispCode(String bankNameDispCode) {
		this.bankNameDispCode = bankNameDispCode;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public String getWalletName() {
		return walletName;
	}
	public void setWalletName(String walletName) {
		this.walletName = walletName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public Blob getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		try {
			this.pinCode=new javax.sql.rowset.serial.SerialBlob(pinCode.getBytes());
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Integer[] getSubTypeIdArr() {
		return subTypeIdArr;
	}
	public void setSubTypeIdArr(Integer[] subTypeIdArr) {
		this.subTypeIdArr = subTypeIdArr;
	}
	private String walletName;

}
