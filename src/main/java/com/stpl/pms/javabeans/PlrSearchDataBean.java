package com.stpl.pms.javabeans;

import java.util.Date;
import java.sql.Timestamp;

public class PlrSearchDataBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long playerId;
	private String fname;
	private String lname;
	private String userName;
	private String email;
	private Long mobile;
	private String regIp;
	private Timestamp firstDepositDate;
	private Double firstDepositAmount;
	private short domainId;
	private String regStatus;
	private Integer currencyId;
	private Date dateOfBrith;
	private String gender;
	private Double totalBal;
	private Double cashBalance;
	private Double bonusBalance;
	private Double praBalance;
	private Timestamp lastLoginDate;
	private String referSource;
	private Long referSourceId;
	private String regDevice;
	private String device;
	private String browser;
	private String OS;
	private int index;
	private short aliasId;
	private String pokerNickName;
	private String rummyNickName;
	private String casinoNickName;
	private String firstDepositReferSource;
	private String commPromo;
	private String plrStatus;
	private String isPlay2x;
	
	public Double getTotalBal() {
		return totalBal;
	}

	public void setTotalBal(Double totalBal) {
		this.totalBal = totalBal;
	}

	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	/*public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}*/

	public String getRegStatus() {
		return regStatus;
	}

	public void setRegStatus(String regStatus) {
		this.regStatus = regStatus;
	}
	public Integer getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}

	

	public Date getDateOfBrith() {
		return dateOfBrith;
	}

	public void setDateOfBrith(Date dateOfBrith) {
		this.dateOfBrith = dateOfBrith;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public short getDomainId() {
		return domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}
	
	public Double getCashBalance() {
		return cashBalance;
	}

	public void setCashBalance(Double cashBalance) {
		this.cashBalance = cashBalance;
	}

	public Double getBonusBalance() {
		return bonusBalance;
	}

	public void setBonusBalance(Double bonusBalance) {
		this.bonusBalance = bonusBalance;
	}

	public Double getPraBalance() {
		return praBalance;
	}

	public void setPraBalance(Double praBalance) {
		this.praBalance = praBalance;
	}

	public String getReferSource() {
		return referSource;
	}

	public void setReferSource(String referSource) {
		this.referSource = referSource;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Long getReferSourceId() {
		return referSourceId;
	}

	public void setReferSourceId(Long referSourceId) {
		this.referSourceId = referSourceId;
	}

	public String getRegIp() {
		return regIp;
	}

	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}

	public String getRegDevice() {
		return regDevice;
	}

	public void setRegDevice(String regDevice) {
		this.regDevice = regDevice;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getOS() {
		return OS;
	}

	public void setOS(String oS) {
		this.OS = oS;
	}

	public Timestamp getFirstDepositDate() {
		return firstDepositDate;
	}

	public void setFirstDepositDate(Timestamp firstDepositDate) {
		this.firstDepositDate = firstDepositDate;
	}

	public Double getFirstDepositAmount() {
		return firstDepositAmount;
	}

	public void setFirstDepositAmount(Double firstDepositAmount) {
		this.firstDepositAmount = firstDepositAmount;
	}

	public short getAliasId() {
		return aliasId;
	}

	public void setAliasId(short aliasId) {
		this.aliasId = aliasId;
	}

	public String getPokerNickName() {
		return pokerNickName;
	}

	public void setPokerNickName(String pokerNickName) {
		this.pokerNickName = pokerNickName;
	}

	public String getRummyNickName() {
		return rummyNickName;
	}

	public void setRummyNickName(String rummyNickName) {
		this.rummyNickName = rummyNickName;
	}

	public String getCasinoNickName() {
		return casinoNickName;
	}

	public void setCasinoNickName(String casinoNickName) {
		this.casinoNickName = casinoNickName;
	}

	public String getFirstDepositReferSource() {
		return firstDepositReferSource;
	}

	public void setFirstDepositReferSource(String firstDepositReferSource) {
		this.firstDepositReferSource = firstDepositReferSource;
	}

	public String getCommPromo() {
		return commPromo;
	}

	public void setCommPromo(String commPromo) {
		this.commPromo = commPromo;
	}

	public String getPlrStatus() {
		return plrStatus;
	}

	public void setPlrStatus(String plrStatus) {
		this.plrStatus = plrStatus;
	}

	public String getIsPlay2x() {
		return isPlay2x;
	}

	public void setIsPlay2x(String isPlay2x) {
		this.isPlay2x = isPlay2x;
	}	
	
	
}
