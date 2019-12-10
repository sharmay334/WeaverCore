package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

public class StRpSummaryTable implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private short summaryId;
	private short domainId;
	private Double wagerAmount;
	private Double winningAmount;
	private Double netAmount;
	private Timestamp summaryDate;

	public short getSummaryId() {
		return summaryId;
	}

	public void setSummaryId(short summaryId) {
		this.summaryId = summaryId;
	}

	public short getDomainId() {
		return domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public Double getWagerAmount() {
		return wagerAmount;
	}

	public void setWagerAmount(Double wagerAmount) {
		this.wagerAmount = wagerAmount;
	}

	public Double getWinningAmount() {
		return winningAmount;
	}

	public void setWinningAmount(Double winningAmount) {
		this.winningAmount = winningAmount;
	}

	public Double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}

	public Timestamp getSummaryDate() {
		return summaryDate;
	}

	public void setSummaryDate(Timestamp summaryDate) {
		this.summaryDate = summaryDate;
	}
}
