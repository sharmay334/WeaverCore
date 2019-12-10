package com.stpl.pms.hibernate.mapping;

/**
 * StCshPlrDepositResponseCitrus entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrDepositResponseCitrus implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private String citrusTxId;
	private Long refRequestId;
	private String issuerRefNo;
	private String authIdCode;
	private String citrusRespCode;
	private Double amount;
	private String citrusSignature;
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private String zipCode;
	private String citrusMsg;
	private String citrusStatus;
	private String sigMatchStatus;

	// Constructors

	/** default constructor */
	public StCshPlrDepositResponseCitrus() {
	}

	/** full constructor */
	public StCshPlrDepositResponseCitrus(String citrusTxId, Long refRequestId,
			String issuerRefNo, String authIdCode, String citrusRespCode,
			Double amount, String citrusSignature, String firstName,
			String lastName, String email, String mobile, String zipCode,
			String citrusMsg, String citrusStatus, String sigMatchStatus) {
		this.citrusTxId = citrusTxId;
		this.refRequestId = refRequestId;
		this.issuerRefNo = issuerRefNo;
		this.authIdCode = authIdCode;
		this.citrusRespCode = citrusRespCode;
		this.amount = amount;
		this.citrusSignature = citrusSignature;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.zipCode = zipCode;
		this.citrusMsg = citrusMsg;
		this.citrusStatus = citrusStatus;
		this.sigMatchStatus = sigMatchStatus;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCitrusTxId() {
		return this.citrusTxId;
	}

	public void setCitrusTxId(String citrusTxId) {
		this.citrusTxId = citrusTxId;
	}

	public Long getRefRequestId() {
		return this.refRequestId;
	}

	public void setRefRequestId(Long refRequestId) {
		this.refRequestId = refRequestId;
	}

	public String getIssuerRefNo() {
		return this.issuerRefNo;
	}

	public void setIssuerRefNo(String issuerRefNo) {
		this.issuerRefNo = issuerRefNo;
	}

	public String getAuthIdCode() {
		return this.authIdCode;
	}

	public void setAuthIdCode(String authIdCode) {
		this.authIdCode = authIdCode;
	}

	public String getCitrusRespCode() {
		return this.citrusRespCode;
	}

	public void setCitrusRespCode(String citrusRespCode) {
		this.citrusRespCode = citrusRespCode;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCitrusSignature() {
		return this.citrusSignature;
	}

	public void setCitrusSignature(String citrusSignature) {
		this.citrusSignature = citrusSignature;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCitrusMsg() {
		return this.citrusMsg;
	}

	public void setCitrusMsg(String citrusMsg) {
		this.citrusMsg = citrusMsg;
	}

	public String getCitrusStatus() {
		return this.citrusStatus;
	}

	public void setCitrusStatus(String citrusStatus) {
		this.citrusStatus = citrusStatus;
	}

	public String getSigMatchStatus() {
		return this.sigMatchStatus;
	}

	public void setSigMatchStatus(String sigMatchStatus) {
		this.sigMatchStatus = sigMatchStatus;
	}

}