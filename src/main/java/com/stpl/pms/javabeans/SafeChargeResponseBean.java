package com.stpl.pms.javabeans;

import java.io.Serializable;

public class SafeChargeResponseBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String status;
	private String totalamount;
	private String transactionid;
	private String clientuniqueid;
	private String errcode;
	private String exerrcode;
	private String authcode;
	private String reason;
	private String reasoncode;
	private String token;
	private String tokenid;
	private String responsechecksum;
	private String advanceresponsechecksum;

	private String cardcompany;
	private String nameoncard;
	private String currency;

	private String customdata;
	private String merchant_unique_id;
	private String merchant_site_id;
	private String merchant_id;
	private String requestversion;
	private String message;
	private String error;
	private String ppp_transactionid;
	private String productid;
	private String ppp_status;
	private String merchantlocale;

	private String item_number_1;
	private String item_amount_1;
	private String item_quantity_1;

	private String payment_method;
	private String responsetimestamp;

	private String dynamicdescriptor;
	private String uniquecc;

	private String first_name;
	private String last_name;
	private String address1;
	private String city;
	private String country;
	private String email;
	private String state;
	private String zip;
	private String phone1;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(String totalamount) {
		this.totalamount = totalamount;
	}

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public String getClientuniqueid() {
		return clientuniqueid;
	}

	public void setClientuniqueid(String clientuniqueid) {
		this.clientuniqueid = clientuniqueid;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getExerrcode() {
		return exerrcode;
	}

	public void setExerrcode(String exerrcode) {
		this.exerrcode = exerrcode;
	}

	public String getAuthcode() {
		return authcode;
	}

	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getReasoncode() {
		return reasoncode;
	}

	public void setReasoncode(String reasoncode) {
		this.reasoncode = reasoncode;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenid() {
		return tokenid;
	}

	public void setTokenid(String tokenid) {
		this.tokenid = tokenid;
	}

	public String getResponsechecksum() {
		return responsechecksum;
	}

	public void setResponsechecksum(String responsechecksum) {
		this.responsechecksum = responsechecksum;
	}

	public String getAdvanceresponsechecksum() {
		return advanceresponsechecksum;
	}

	public void setAdvanceresponsechecksum(String advanceresponsechecksum) {
		this.advanceresponsechecksum = advanceresponsechecksum;
	}

	public String getCardcompany() {
		return cardcompany;
	}

	public void setCardcompany(String cardcompany) {
		this.cardcompany = cardcompany;
	}

	public String getNameoncard() {
		return nameoncard;
	}

	public void setNameoncard(String nameoncard) {
		this.nameoncard = nameoncard;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCustomdata() {
		return customdata;
	}

	public void setCustomdata(String customdata) {
		this.customdata = customdata;
	}

	public String getMerchant_unique_id() {
		return merchant_unique_id;
	}

	public void setMerchant_unique_id(String merchantUniqueId) {
		merchant_unique_id = merchantUniqueId;
	}

	public String getMerchant_site_id() {
		return merchant_site_id;
	}

	public void setMerchant_site_id(String merchantSiteId) {
		merchant_site_id = merchantSiteId;
	}

	public String getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(String merchantId) {
		merchant_id = merchantId;
	}

	public String getRequestversion() {
		return requestversion;
	}

	public void setRequestversion(String requestversion) {
		this.requestversion = requestversion;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getPpp_transactionid() {
		return ppp_transactionid;
	}

	public void setPpp_transactionid(String pppTransactionid) {
		ppp_transactionid = pppTransactionid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getPpp_status() {
		return ppp_status;
	}

	public void setPpp_status(String pppStatus) {
		ppp_status = pppStatus;
	}

	public String getMerchantlocale() {
		return merchantlocale;
	}

	public void setMerchantlocale(String merchantlocale) {
		this.merchantlocale = merchantlocale;
	}

	public String getItem_number_1() {
		return item_number_1;
	}

	public void setItem_number_1(String itemNumber_1) {
		item_number_1 = itemNumber_1;
	}

	public String getItem_amount_1() {
		return item_amount_1;
	}

	public void setItem_amount_1(String itemAmount_1) {
		item_amount_1 = itemAmount_1;
	}

	public String getItem_quantity_1() {
		return item_quantity_1;
	}

	public void setItem_quantity_1(String itemQuantity_1) {
		item_quantity_1 = itemQuantity_1;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String paymentMethod) {
		payment_method = paymentMethod;
	}

	public String getResponsetimestamp() {
		return responsetimestamp;
	}

	public void setResponsetimestamp(String responsetimestamp) {
		this.responsetimestamp = responsetimestamp;
	}

	public String getDynamicdescriptor() {
		return dynamicdescriptor;
	}

	public void setDynamicdescriptor(String dynamicdescriptor) {
		this.dynamicdescriptor = dynamicdescriptor;
	}

	public String getUniquecc() {
		return uniquecc;
	}

	public void setUniquecc(String uniquecc) {
		this.uniquecc = uniquecc;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String firstName) {
		first_name = firstName;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String lastName) {
		last_name = lastName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	@Override
	public String toString() {
		return "SafeChargeResponseBean [address1=" + address1
				+ ", advanceresponsechecksum=" + advanceresponsechecksum
				+ ", authcode=" + authcode + ", cardcompany=" + cardcompany
				+ ", city=" + city + ", clientuniqueid=" + clientuniqueid
				+ ", country=" + country + ", currency=" + currency
				+ ", customdata=" + customdata + ", dynamicdescriptor="
				+ dynamicdescriptor + ", email=" + email + ", errcode="
				+ errcode + ", error=" + error + ", exerrcode=" + exerrcode
				+ ", first_name=" + first_name + ", item_amount_1="
				+ item_amount_1 + ", item_number_1=" + item_number_1
				+ ", item_quantity_1=" + item_quantity_1 + ", last_name="
				+ last_name + ", merchant_id=" + merchant_id
				+ ", merchant_site_id=" + merchant_site_id
				+ ", merchant_unique_id=" + merchant_unique_id
				+ ", merchantlocale=" + merchantlocale + ", message=" + message
				+ ", nameoncard=" + nameoncard + ", payment_method="
				+ payment_method + ", phone1=" + phone1 + ", ppp_status="
				+ ppp_status + ", ppp_transactionid=" + ppp_transactionid
				+ ", productid=" + productid + ", reason=" + reason
				+ ", reasoncode=" + reasoncode + ", requestversion="
				+ requestversion + ", responsechecksum=" + responsechecksum
				+ ", responsetimestamp=" + responsetimestamp + ", state="
				+ state + ", status=" + status + ", token=" + token
				+ ", tokenid=" + tokenid + ", totalamount=" + totalamount
				+ ", transactionid=" + transactionid + ", uniquecc=" + uniquecc
				+ ", zip=" + zip + "]";
	}

}
