package com.stpl.pms.javabeans;

public class VoucherBean {
	private int voucherId;
	private String voucherName;
	private String voucherType;
	private String voucherNumbering;
	private String effctvDateOfVchr;
	private String narrationAllowed;

	public String getVoucherName() {
		return voucherName;
	}

	public void setVoucherName(String voucherName) {
		this.voucherName = voucherName;
	}

	public String getVoucherType() {
		return voucherType;
	}

	public void setVoucherType(String voucherType) {
		this.voucherType = voucherType;
	}

	public String getVoucherNumbering() {
		return voucherNumbering;
	}

	public void setVoucherNumbering(String voucherNumbering) {
		this.voucherNumbering = voucherNumbering;
	}

	public String getEffctvDateOfVchr() {
		return effctvDateOfVchr;
	}

	public void setEffctvDateOfVchr(String effctvDateOfVchr) {
		this.effctvDateOfVchr = effctvDateOfVchr;
	}

	public String getNarrationAllowed() {
		return narrationAllowed;
	}

	public void setNarrationAllowed(String narrationAllowed) {
		this.narrationAllowed = narrationAllowed;
	}

	public int getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}

}
