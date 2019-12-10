package com.stpl.pms.hibernate.mapping;

/**
 * StCshPlrRedeemAccInfoCheque entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrRedeemAccInfoCheque extends StCshPlrRedeemAccMaster implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long redeemAccId;
	private String firstName;
	private String lastName;
	private String houseNum;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String stateCode;
	private String countryCode;
	private String postalCode;
	private String status;

	public StCshPlrRedeemAccInfoCheque() {
	}
	/** full constructor 
	 * @param status 
	 * @param redAccMaster */
	public StCshPlrRedeemAccInfoCheque(StCshPlrRedeemAccMaster redAccMaster, String firstName,
			String lastName, String houseNum, String addressLine1,
			String addressLine2, String city, String stateCode,
			String countryCode, String postalCode, String status) {
		super(redAccMaster.getPaymentType(),
				redAccMaster.getProviderId(), redAccMaster.getPlayerId(),
				redAccMaster.getStatus(), redAccMaster.getPaymentTypeMas());
		this.firstName = firstName;
		this.lastName = lastName;
		this.houseNum = houseNum;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.stateCode = stateCode;
		this.countryCode = countryCode;
		this.postalCode = postalCode;
		this.status = status;
	}

	// Property accessors

	public Long getRedeemAccId() {
		return this.redeemAccId;
	}

	public void setRedeemAccId(Long redeemAccId) {
		this.redeemAccId = redeemAccId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getStateCode() {
		return this.stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}