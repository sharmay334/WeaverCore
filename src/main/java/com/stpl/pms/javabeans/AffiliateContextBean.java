package com.stpl.pms.javabeans;

public class AffiliateContextBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer affiliateId;
	private Integer affiliateCode;
	private String userName;
	private String emailId;
	private Double balance;
	private Long visitors;
	private Long registered;
	private Long deposited;
	private int errorCode=0;
	
	public Long getVisitors() {
		return visitors;
	}

	public void setVisitors(Long visitors) {
		this.visitors = visitors;
	}

	public Long getRegistered() {
		return registered;
	}

	public void setRegistered(Long registered) {
		this.registered = registered;
	}

	public Long getDeposited() {
		return deposited;
	}

	public void setDeposited(Long deposited) {
		this.deposited = deposited;
	}

	public String toString()
	{
		 return new String
		 (
				 "["+
				 this.affiliateId +","+this.affiliateCode +","+this.userName+","+this.emailId+","+this.balance+","+this.visitors+","+this.registered+","+this.deposited				 
				 +"]"
		 
		    );		
	}

	public Integer getAffiliateId() {
		return affiliateId;
	}

	public void setAffiliateId(Integer affiliateId) {
		this.affiliateId = affiliateId;
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

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getAffiliateCode() {
		return affiliateCode;
	}

	public void setAffiliateCode(Integer affiliateCode) {
		this.affiliateCode = affiliateCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
