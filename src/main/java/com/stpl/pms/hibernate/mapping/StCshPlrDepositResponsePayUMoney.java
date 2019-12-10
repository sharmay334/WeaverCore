package com.stpl.pms.hibernate.mapping;

public class StCshPlrDepositResponsePayUMoney implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String mihpayId;
	private String mode;
	private String status;
	private String key;
	private String txnid;
	private String amount;
	private String discount;
	private String offer;
	private String productInfo;
	private String firstName;
	private String lastName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	private String email;
	private String phone;
	private String udf1;
	private String udf2;
	private String udf3;
	private String udf4;
	private String udf5;
	private String hash;
	private String error;
	private String pgType;
	private String bankCode;
	private String bankRefNum;
	private String unmappedStatus;
	private String payuMoneyId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMihpayId() {
		return mihpayId;
	}
	public void setMihpayId(String mihpayId) {
		this.mihpayId = mihpayId;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getTxnid() {
		return txnid;
	}
	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUdf1() {
		return udf1;
	}
	public void setUdf1(String udf1) {
		this.udf1 = udf1;
	}
	public String getUdf2() {
		return udf2;
	}
	public void setUdf2(String udf2) {
		this.udf2 = udf2;
	}
	public String getUdf3() {
		return udf3;
	}
	public void setUdf3(String udf3) {
		this.udf3 = udf3;
	}
	public String getUdf4() {
		return udf4;
	}
	public void setUdf4(String udf4) {
		this.udf4 = udf4;
	}
	public String getUdf5() {
		return udf5;
	}
	public void setUdf5(String udf5) {
		this.udf5 = udf5;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getPgType() {
		return pgType;
	}
	public void setPgType(String pgType) {
		this.pgType = pgType;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public String getBankRefNum() {
		return bankRefNum;
	}
	public void setBankRefNum(String bankRefNum) {
		this.bankRefNum = bankRefNum;
	}
	public String getUnmappedStatus() {
		return unmappedStatus;
	}
	public void setUnmappedStatus(String unmappedStatus) {
		this.unmappedStatus = unmappedStatus;
	}
	public String getPayuMoneyId() {
		return payuMoneyId;
	}
	public void setPayuMoneyId(String payuMoneyId) {
		this.payuMoneyId = payuMoneyId;
	}
	public StCshPlrDepositResponsePayUMoney()
	{
		
	}
	public StCshPlrDepositResponsePayUMoney(String mihpayId, String mode,
			String status, String key, String txnid, String amount,
			String discount, String offer, String productInfo,
			String firstName, String lastName, String addressLine1,
			String addressLine2, String city, String state, String country,
			String zipcode, String email, String phone, String udf1,
			String udf2, String udf3, String udf4, String udf5, String hash,
			String error, String pgType, String bankCode, String bankRefNum,
			String unmappedStatus, String payuMoneyId) {
		this.mihpayId = mihpayId;
		this.mode = mode;
		this.status = status;
		this.key = key;
		this.txnid = txnid;
		this.amount = amount;
		this.discount = discount;
		this.offer = offer;
		this.productInfo = productInfo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.email = email;
		this.phone = phone;
		this.udf1 = udf1;
		this.udf2 = udf2;
		this.udf3 = udf3;
		this.udf4 = udf4;
		this.udf5 = udf5;
		this.hash = hash;
		this.error = error;
		this.pgType = pgType;
		this.bankCode = bankCode;
		this.bankRefNum = bankRefNum;
		this.unmappedStatus = unmappedStatus;
		this.payuMoneyId = payuMoneyId;
	}
	
	
	
}
