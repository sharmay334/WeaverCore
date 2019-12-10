package com.stpl.pms.hibernate.mapping;

import com.stpl.pms.javabeans.SafeChargeResponseBean;

/**
 * StCshPlrDepositResponseSafecharge entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrDepositResponseSafecharge implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
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

	// Constructors

	/** default constructor */
	public StCshPlrDepositResponseSafecharge() {
	}

	/** full constructor */

	// Property accessors

	public Long getId() {
		return id;
	}

	public StCshPlrDepositResponseSafecharge(String status, String totalamount,
			String transactionid, String clientuniqueid, String errcode,
			String exerrcode, String authcode, String reason,
			String reasoncode, String token, String tokenid,
			String responsechecksum, String advanceresponsechecksum,
			String cardcompany, String nameoncard, String currency,
			String customdata, String merchantUniqueId, String merchantSiteId,
			String merchantId, String requestversion, String message,
			String error, String pppTransactionid, String productid,
			String pppStatus, String merchantlocale, String itemNumber_1,
			String itemAmount_1, String itemQuantity_1, String paymentMethod,
			String responsetimestamp, String dynamicdescriptor,
			String uniquecc, String firstName, String lastName,
			String address1, String city, String country, String email,
			String state, String zip, String phone1) {
		this.status = status;
		this.totalamount = totalamount;
		this.transactionid = transactionid;
		this.clientuniqueid = clientuniqueid;
		this.errcode = errcode;
		this.exerrcode = exerrcode;
		this.authcode = authcode;
		this.reason = reason;
		this.reasoncode = reasoncode;
		this.token = token;
		this.tokenid = tokenid;
		this.responsechecksum = responsechecksum;
		this.advanceresponsechecksum = advanceresponsechecksum;
		this.cardcompany = cardcompany;
		this.nameoncard = nameoncard;
		this.currency = currency;
		this.customdata = customdata;
		this.merchant_unique_id = merchantUniqueId;
		this.merchant_site_id = merchantSiteId;
		this.merchant_id = merchantId;
		this.requestversion = requestversion;
		this.message = message;
		this.error = error;
		this.ppp_transactionid = pppTransactionid;
		this.productid = productid;
		this.ppp_status = pppStatus;
		this.merchantlocale = merchantlocale;
		this.item_number_1 = itemNumber_1;
		this.item_amount_1 = itemAmount_1;
		this.item_quantity_1 = itemQuantity_1;
		this.payment_method = paymentMethod;
		this.responsetimestamp = responsetimestamp;
		this.dynamicdescriptor = dynamicdescriptor;
		this.uniquecc = uniquecc;
		this.first_name = firstName;
		this.last_name = lastName;
		this.address1 = address1;
		this.city = city;
		this.country = country;
		this.email = email;
		this.state = state;
		this.zip = zip;
		this.phone1 = phone1;
	}
	public StCshPlrDepositResponseSafecharge(SafeChargeResponseBean resp) {
		this.status = resp.getStatus();
		this.totalamount = resp.getTotalamount();
		this.transactionid = resp.getTransactionid();
		this.clientuniqueid = resp.getClientuniqueid();
		this.errcode = resp.getErrcode();
		this.exerrcode = resp.getExerrcode();
		this.authcode = resp.getAuthcode();
		this.reason = resp.getReason();
		this.reasoncode = resp.getReasoncode();
		this.token = resp.getToken();
		this.tokenid = resp.getTokenid();
		this.responsechecksum = resp.getResponsechecksum();
		this.advanceresponsechecksum = resp.getAdvanceresponsechecksum();
		this.cardcompany = resp.getCardcompany();
		this.nameoncard = resp.getNameoncard();
		this.currency = resp.getCurrency();
		this.customdata = resp.getCustomdata();
		this.merchant_unique_id = resp.getMerchant_unique_id();
		this.merchant_site_id = resp.getMerchant_site_id();
		this.merchant_id = resp.getMerchant_id();
		this.requestversion = resp.getRequestversion();
		this.message = resp.getMessage();
		this.error = resp.getError();
		this.ppp_transactionid = resp.getPpp_transactionid();
		this.productid = resp.getProductid();
		this.ppp_status = resp.getPpp_status();
		this.merchantlocale = resp.getMerchantlocale();
		this.item_number_1 = resp.getItem_number_1();
		this.item_amount_1 = resp.getItem_amount_1();
		this.item_quantity_1 = resp.getItem_quantity_1();
		this.payment_method = resp.getPayment_method();
		this.responsetimestamp = resp.getResponsetimestamp();
		this.dynamicdescriptor = resp.getDynamicdescriptor();
		this.uniquecc = resp.getUniquecc();
		this.first_name = resp.getFirst_name();
		this.last_name = resp.getLast_name();
		this.address1 = resp.getAddress1();
		this.city = resp.getCity();
		this.country = resp.getCity();
		this.email = resp.getEmail();
		this.state = resp.getState();
		this.zip = resp.getZip();
		this.phone1 = resp.getPhone1();
	}
	public void setId(Long id) {
		this.id = id;
	}

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

}