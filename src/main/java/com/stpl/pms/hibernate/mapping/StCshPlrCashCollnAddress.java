package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;
import java.util.Calendar;

import com.stpl.pms.javabeans.PlayerInfoBean;
import com.stpl.pms.javabeans.PlrCashCollnAddressBean;

/**
 * StCshPlrCollnAddressGharpay entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrCashCollnAddress implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long playerId;
	private String houseNum;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String pincode;
	private String contactNum;
	private Timestamp updateDate;

	// Constructors

	/** default constructor */
	public StCshPlrCashCollnAddress() {
	}

	public StCshPlrCashCollnAddress(PlayerInfoBean playerInfo) {
		this.playerId = playerInfo.getPlayerId();
		this.houseNum = playerInfo.getHouseNum();
		this.addressLine1 = playerInfo.getAddressLine1();
		this.addressLine2 = playerInfo.getAddressLine2();
		this.city = playerInfo.getCity();
		this.contactNum=String.valueOf(playerInfo.getMobileNo());
		this.pincode = playerInfo.getPostalCode();
		this.updateDate = new Timestamp(Calendar.getInstance()
				.getTimeInMillis());
	}
	public StCshPlrCashCollnAddress(PlrCashCollnAddressBean cshCollAddress) {
		this.playerId = cshCollAddress.getPlayerId();
		this.houseNum = cshCollAddress.getHouseNum();
		this.addressLine1 = cshCollAddress.getAddressLine1();
		this.addressLine2 = cshCollAddress.getAddressLine2();
		this.city = cshCollAddress.getCity();
		this.contactNum=cshCollAddress.getContactNum();
		this.pincode = cshCollAddress.getPincode();
		this.updateDate = new Timestamp(Calendar.getInstance()
				.getTimeInMillis());
	}
	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getHouseNum() {
		return this.houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getContactNum() {
		return this.contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

}