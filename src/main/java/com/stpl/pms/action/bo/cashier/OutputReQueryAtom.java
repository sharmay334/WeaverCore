package com.stpl.pms.action.bo.cashier;




import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "VerifyOutput")
public class OutputReQueryAtom implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private String merchantID;
	private String merchantTxnID;
	private String amt;
	private String verified;
	private String bid;
	private String bankname;
	private String atomtxnId;
	private String discriminator;
	private String surcharge;
	private String cardNumber;
	private String txnDate;
	
	
	
	
	@XmlAttribute(name="MerchantID")
	public String getMerchantID() {
		return merchantID;
	}
	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}
	
	@XmlAttribute(name="MerchantTxnID")
	public String getMerchantTxnID() {
		return merchantTxnID;
	}
	public void setMerchantTxnID(String merchantTxnID) {
		this.merchantTxnID = merchantTxnID;
	}
	
	@XmlAttribute(name="AMT")
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	
	@XmlAttribute(name="VERIFIED")
	public String getVerified() {
		return verified;
	}
	public void setVerified(String verified) {
		this.verified = verified;
	}
	
	@XmlAttribute(name="BID")
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	
	@XmlAttribute(name="bankname")
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	
	@XmlAttribute
	public String getAtomtxnId() {
		return atomtxnId;
	}
	public void setAtomtxnId(String atomtxnId) {
		this.atomtxnId = atomtxnId;
	}
	@XmlAttribute
	public String getDiscriminator() {
		return discriminator;
	}
	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}
	@XmlAttribute
	public String getSurcharge() {
		return surcharge;
	}
	public void setSurcharge(String surcharge) {
		this.surcharge = surcharge;
	}
	@XmlAttribute(name="CardNumber")
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	@XmlAttribute(name="TxnDate")
	public String getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
