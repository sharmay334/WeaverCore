package com.stpl.pms.javabeans;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown= true)
public class PlayerRegAPIBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String userName;
	private String emailId;
	private Long mobileNo;
	private String dob;
	private String firstName;
	private String lastName;
	private String requestIp;
	private String countryCode;

	public PlayerRegAPIBean() {
	}

	public PlayerRegAPIBean(String userName, String emailId, Long mobileNo,
			String dob, String firstName, String lastName, String requestIp,
			String countryCode) {
		this.userName = userName;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.dob = dob;
		this.firstName = firstName;
		this.lastName = lastName;
		this.requestIp = requestIp;
		this.countryCode = countryCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}

	public String getRequestIp() {
		return requestIp;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

}
