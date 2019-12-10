package com.stpl.pms.hibernate.mapping;

/**
 * StCshPlrDepositResponseTspl entity. @author MyEclipse Persistence Tools
 */

public class StCshPlrDepositResponseTspl implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Long id;
	private String merchantId;
	private String refRequestId;
	private String txnReferenceNo;
	private String bankReferenceNo;
	private String txnAmount;
	private String bankId;
	private String bankTsplId;
	private String txnType;
	private String currencyName;
	private String itemCode;
	private String securityType;
	private String securityId;
	private String securityPassword;
	private String txnDate;
	private String authStatus;
	private String settlementType;
	private String additionalInfo1;
	private String additionalInfo2;
	private String additionalInfo3;
	private String additionalInfo4;
	private String additionalInfo5;
	private String additionalInfo6;
	private String additionalInfo7;
	private String errorStatus;
	private String errorDescription;
	private String checkSum;
	private String refCheckSum;

	// Constructors

	/** default constructor */
	public StCshPlrDepositResponseTspl() {
	}

	/** full constructor */
	public StCshPlrDepositResponseTspl(String valueArr[]) {
		this.merchantId = valueArr[0];
		this.refRequestId = valueArr[1];
		this.txnReferenceNo = valueArr[2];
		this.bankReferenceNo = valueArr[3];
		this.txnAmount = valueArr[4];
		this.bankId = valueArr[5];
		this.bankTsplId = valueArr[6];
		this.txnType = valueArr[7];
		this.currencyName = valueArr[8];
		this.itemCode = valueArr[9];
		this.securityType = valueArr[10];
		this.securityId = valueArr[11];
		this.securityPassword = valueArr[12];
		this.txnDate = valueArr[13];
		this.authStatus = valueArr[14];
		this.settlementType = valueArr[15];
		this.additionalInfo1 = valueArr[16];
		this.additionalInfo2 = valueArr[17];
		this.additionalInfo3 = valueArr[18];
		this.additionalInfo4 = valueArr[19];
		this.additionalInfo5 = valueArr[20];
		this.additionalInfo6 = valueArr[21];
		this.additionalInfo7 = valueArr[22];
		this.errorStatus = valueArr[23];
		this.errorDescription = valueArr[24];
		this.checkSum = valueArr[25];
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMerchantId() {
		return this.merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getRefRequestId() {
		return this.refRequestId;
	}

	public void setRefRequestId(String refRequestId) {
		this.refRequestId = refRequestId;
	}

	public String getTxnReferenceNo() {
		return this.txnReferenceNo;
	}

	public void setTxnReferenceNo(String txnReferenceNo) {
		this.txnReferenceNo = txnReferenceNo;
	}

	public String getBankReferenceNo() {
		return this.bankReferenceNo;
	}

	public void setBankReferenceNo(String bankReferenceNo) {
		this.bankReferenceNo = bankReferenceNo;
	}

	public String getTxnAmount() {
		return this.txnAmount;
	}

	public void setTxnAmount(String txnAmount) {
		this.txnAmount = txnAmount;
	}

	public String getBankId() {
		return this.bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBankTsplId() {
		return this.bankTsplId;
	}

	public void setBankTsplId(String bankTsplId) {
		this.bankTsplId = bankTsplId;
	}

	public String getTxnType() {
		return this.txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getCurrencyName() {
		return this.currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getSecurityType() {
		return this.securityType;
	}

	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}

	public String getSecurityId() {
		return this.securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	public String getSecurityPassword() {
		return this.securityPassword;
	}

	public void setSecurityPassword(String securityPassword) {
		this.securityPassword = securityPassword;
	}

	public String getTxnDate() {
		return this.txnDate;
	}

	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}

	public String getAuthStatus() {
		return this.authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public String getSettlementType() {
		return this.settlementType;
	}

	public void setSettlementType(String settlementType) {
		this.settlementType = settlementType;
	}

	public String getAdditionalInfo1() {
		return this.additionalInfo1;
	}

	public void setAdditionalInfo1(String additionalInfo1) {
		this.additionalInfo1 = additionalInfo1;
	}

	public String getAdditionalInfo2() {
		return this.additionalInfo2;
	}

	public void setAdditionalInfo2(String additionalInfo2) {
		this.additionalInfo2 = additionalInfo2;
	}

	public String getAdditionalInfo3() {
		return this.additionalInfo3;
	}

	public void setAdditionalInfo3(String additionalInfo3) {
		this.additionalInfo3 = additionalInfo3;
	}

	public String getAdditionalInfo4() {
		return this.additionalInfo4;
	}

	public void setAdditionalInfo4(String additionalInfo4) {
		this.additionalInfo4 = additionalInfo4;
	}

	public String getAdditionalInfo5() {
		return this.additionalInfo5;
	}

	public void setAdditionalInfo5(String additionalInfo5) {
		this.additionalInfo5 = additionalInfo5;
	}

	public String getAdditionalInfo6() {
		return this.additionalInfo6;
	}

	public void setAdditionalInfo6(String additionalInfo6) {
		this.additionalInfo6 = additionalInfo6;
	}

	public String getAdditionalInfo7() {
		return this.additionalInfo7;
	}

	public void setAdditionalInfo7(String additionalInfo7) {
		this.additionalInfo7 = additionalInfo7;
	}

	public String getErrorStatus() {
		return this.errorStatus;
	}

	public void setErrorStatus(String errorStatus) {
		this.errorStatus = errorStatus;
	}

	public String getErrorDescription() {
		return this.errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getCheckSum() {
		return this.checkSum;
	}

	public void setCheckSum(String checkSum) {
		this.checkSum = checkSum;
	}

	public String getRefCheckSum() {
		return this.refCheckSum;
	}

	public void setRefCheckSum(String refCheckSum) {
		this.refCheckSum = refCheckSum;
	}
}