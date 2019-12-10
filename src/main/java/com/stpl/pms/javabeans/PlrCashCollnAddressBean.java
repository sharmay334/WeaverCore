package com.stpl.pms.javabeans;

import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.commons.lang.WordUtils;

public class PlrCashCollnAddressBean implements java.io.Serializable {
	// Fields
	private static final long serialVersionUID = 1L;
	private long id;
	private long playerId;
	private String houseNum;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String pincode;
	private String contactNum;
	private Timestamp updateDate;
	private String firstName;
	private String lastName;

	// Constructors

	/** default constructor */
	public PlrCashCollnAddressBean() {
	}

	public PlrCashCollnAddressBean(PlayerInfoBean playerInfo) {
		this.playerId = playerInfo.getPlayerId();
		this.houseNum = playerInfo.getHouseNum();
		this.addressLine1 = playerInfo.getAddressLine1();
		this.addressLine2 = playerInfo.getAddressLine2();
		this.city = WordUtils.capitalize(playerInfo.getCity().toLowerCase());
		this.contactNum = String.valueOf(playerInfo.getMobileNo());
		this.pincode = playerInfo.getPostalCode();
		this.updateDate = new Timestamp(Calendar.getInstance()
				.getTimeInMillis());
		this.firstName = playerInfo.getFirstName();
		this.lastName = playerInfo.getLastName();
	}

	public PlrCashCollnAddressBean(long playerId, String houseNum,
			String addressLine1, String addressLine2, String city,
			String pincode, String contactNum, String firstName, String lastName) {
		this.playerId = playerId;
		this.houseNum = houseNum;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = WordUtils.capitalize(city.toLowerCase());
		this.pincode = pincode;
		this.contactNum = contactNum;
		this.updateDate = new Timestamp(Calendar.getInstance()
				.getTimeInMillis());
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// Property accessors

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(long playerId) {
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

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

}
