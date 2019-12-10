package com.stpl.pms.javabeans;

import java.sql.Timestamp;

public class WeaverEcoNetSaleBean {
	private Timestamp txnDate;
	private Double ecoAmount;
	private Double weaverAmount;

	public Timestamp getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(Timestamp txnDate) {
		this.txnDate = txnDate;
	}

	public Double getEcoAmount() {
		return ecoAmount;
	}

	public void setEcoAmount(Double ecoAmount) {
		this.ecoAmount = ecoAmount;
	}

	public Double getWeaverAmount() {
		return weaverAmount;
	}

	public void setWeaverAmount(Double weaverAmount) {
		this.weaverAmount = weaverAmount;
	}
}
