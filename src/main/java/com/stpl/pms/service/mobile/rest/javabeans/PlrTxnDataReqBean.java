package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.stpl.pms.exception.PMSErrorCode;
import com.stpl.pms.exception.PMSErrorMessage;
import com.stpl.pms.exception.PMSException;

public class PlrTxnDataReqBean extends CommonRequestBean implements
		Serializable {

	private static final long serialVersionUID = 1L;
	private String fromDate;
	private String toDate;
	private String txnType;
	private String walletType;
	private Long transactionId;

	public PlrTxnDataReqBean() {
	}

	public PlrTxnDataReqBean(String fromDate, String toDate, String txnType,
			String walletType, Long transactionId) {
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.txnType = txnType;
		this.walletType = walletType;
		this.transactionId = transactionId;
	}

	public Timestamp getFromDate() throws PMSException {
		try {
			DateFormat DATETIME_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
			return new Timestamp(DATETIME_FORMAT.parse(fromDate).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_INVALID_DATE_FORMAT,
					PMSErrorMessage.GEN_INVALID_DATE_FORMAT);
		}
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public Timestamp getToDate() throws PMSException {
		try {
			DateFormat DATETIME_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
			return new Timestamp(DATETIME_FORMAT.parse(toDate).getTime() + 24
					* 60 * 60 * 1000 - 1000);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new PMSException(PMSErrorCode.GEN_INVALID_DATE_FORMAT,
					PMSErrorMessage.GEN_INVALID_DATE_FORMAT);
		}
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setWalletType(String walletType) {
		this.walletType = walletType;
	}

	public String getWalletType() {
		return walletType;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getTransactionId() {
		return transactionId;
	}

}
