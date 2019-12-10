package com.stpl.pms.hibernate.mapping;

import java.io.Serializable;
import java.sql.Timestamp;

public class StPmPlrRegOtpData implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long mobileNo;
	private String verificationCode;
	private Timestamp mobVerificationExpiry;

	public StPmPlrRegOtpData() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public Timestamp getMobVerificationExpiry() {
		return mobVerificationExpiry;
	}

	public void setMobVerificationExpiry(Timestamp mobVerificationExpiry) {
		this.mobVerificationExpiry = mobVerificationExpiry;
	}
}
