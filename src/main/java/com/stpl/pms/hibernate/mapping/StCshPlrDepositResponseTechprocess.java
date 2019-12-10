package com.stpl.pms.hibernate.mapping;

/**
 * StCshPlrDepositResponseTechprocess entity. @author MyEclipse Persistence
 * Tools
 */

public class StCshPlrDepositResponseTechprocess implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String merchantId;
	private String refRequestId;
	private String tpslTxnId;
	private String tpslBankCd;
	private String txnAmt;
	private String txnStatus;
	private String txnMsg;
	private String txnErrMsg;
	private String tpslTxnTime;
	private String clntRqstMeta;
	private String tpslRfndId;
	private String balAmt;
	private String rqstToken;
	private String hash;

	// Constructors

	/** default constructor */
	public StCshPlrDepositResponseTechprocess() {
	}

	/** full constructor */
	public StCshPlrDepositResponseTechprocess(String merchantId,
			String refRequestId, String tpslTxnId, String tpslBankCd,
			String txnAmt, String txnStatus, String txnMsg, String txnErrMsg,
			String tpslTxnTime, String clntRqstMeta, String tpslRfndId,
			String balAmt, String rqstToken, String hash) {
		this.merchantId = merchantId;
		this.refRequestId = refRequestId;
		this.tpslTxnId = tpslTxnId;
		this.tpslBankCd = tpslBankCd;
		this.txnAmt = txnAmt;
		this.txnStatus = txnStatus;
		this.txnMsg = txnMsg;
		this.txnErrMsg = txnErrMsg;
		this.tpslTxnTime = tpslTxnTime;
		this.clntRqstMeta = clntRqstMeta;
		this.tpslRfndId = tpslRfndId;
		this.balAmt = balAmt;
		this.rqstToken = rqstToken;
		this.hash = hash;
	}

	// Property accessors

	public StCshPlrDepositResponseTechprocess(String merchantId, String[] response) {
		this.merchantId = merchantId;
		this.refRequestId = response[3].split("=")[1];
		this.tpslTxnId = response[5].split("=")[1];
		this.tpslBankCd = response[4].split("=")[1];
		this.txnAmt = response[6].split("=")[1];
		this.txnStatus = response[0].split("=")[1];
		this.txnMsg = response[1].split("=")[1];
		this.txnErrMsg = response[2].split("=")[1];
		this.tpslTxnTime = response[8].split("=")[1];
		this.clntRqstMeta = response[7].split("=")[1];
		this.tpslRfndId = response[9].split("=")[1];
		this.balAmt = response[10].split("=")[1];
		this.rqstToken = response[11].split("=")[1];
		this.hash = response[12].split("=")[1];
	}

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

	public String getTpslTxnId() {
		return this.tpslTxnId;
	}

	public void setTpslTxnId(String tpslTxnId) {
		this.tpslTxnId = tpslTxnId;
	}

	public String getTpslBankCd() {
		return this.tpslBankCd;
	}

	public void setTpslBankCd(String tpslBankCd) {
		this.tpslBankCd = tpslBankCd;
	}

	public String getTxnAmt() {
		return this.txnAmt;
	}

	public void setTxnAmt(String txnAmt) {
		this.txnAmt = txnAmt;
	}

	public String getTxnStatus() {
		return this.txnStatus;
	}

	public void setTxnStatus(String txnStatus) {
		this.txnStatus = txnStatus;
	}

	public String getTxnMsg() {
		return this.txnMsg;
	}

	public void setTxnMsg(String txnMsg) {
		this.txnMsg = txnMsg;
	}

	public String getTxnErrMsg() {
		return this.txnErrMsg;
	}

	public void setTxnErrMsg(String txnErrMsg) {
		this.txnErrMsg = txnErrMsg;
	}

	public String getTpslTxnTime() {
		return this.tpslTxnTime;
	}

	public void setTpslTxnTime(String tpslTxnTime) {
		this.tpslTxnTime = tpslTxnTime;
	}

	public String getClntRqstMeta() {
		return this.clntRqstMeta;
	}

	public void setClntRqstMeta(String clntRqstMeta) {
		this.clntRqstMeta = clntRqstMeta;
	}

	public String getTpslRfndId() {
		return this.tpslRfndId;
	}

	public void setTpslRfndId(String tpslRfndId) {
		this.tpslRfndId = tpslRfndId;
	}

	public String getBalAmt() {
		return this.balAmt;
	}

	public void setBalAmt(String balAmt) {
		this.balAmt = balAmt;
	}

	public String getRqstToken() {
		return this.rqstToken;
	}

	public void setRqstToken(String rqstToken) {
		this.rqstToken = rqstToken;
	}

	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	@Override
	public String toString() {
		return "StCshPlrDepositResponseTechprocess [balAmt=" + balAmt
				+ ", clntRqstMeta=" + clntRqstMeta + ", hash=" + hash + ", id="
				+ id + ", merchantId=" + merchantId + ", refRequestId="
				+ refRequestId + ", rqstToken=" + rqstToken + ", tpslBankCd="
				+ tpslBankCd + ", tpslRfndId=" + tpslRfndId + ", tpslTxnId="
				+ tpslTxnId + ", tpslTxnTime=" + tpslTxnTime + ", txnAmt="
				+ txnAmt + ", txnErrMsg=" + txnErrMsg + ", txnMsg=" + txnMsg
				+ ", txnStatus=" + txnStatus + "]";
	}

}