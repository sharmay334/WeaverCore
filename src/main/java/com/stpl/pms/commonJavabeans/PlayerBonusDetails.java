package com.stpl.pms.commonJavabeans;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerBonusDetails implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long bonusId;
	private String bonusCode;
	private Double amount;
	private Double redeemedAmount;
	private Double target;
	private Double contribution;
	private Double pendingAmt;
	private Timestamp receivedDate;
	private Timestamp expiredDate;
	private String status;
	private Double redeemedAmtToCash;
	private Double wrContributionAtTransfer;
	private Timestamp transactionDate;
	private int startIndex;
	private String bonusCriteria;

	public Long getBonusId() {
		return bonusId;
	}

	public void setBonusId(Long bonusId) {
		this.bonusId = bonusId;
	}

	public String getBonusCode() {
		return bonusCode;
	}

	public void setBonusCode(String bonusCode) {
		this.bonusCode = bonusCode;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getRedeemedAmount() {
		return redeemedAmount;
	}

	public void setRedeemedAmount(Double redeemedAmount) {
		this.redeemedAmount = redeemedAmount;
	}

	public Double getTarget() {
		return target;
	}

	public void setTarget(Double target) {
		this.target = target;
	}

	public Double getContribution() {
		return contribution;
	}

	public void setContribution(Double contribution) {
		this.contribution = contribution;
	}

	public Double getPendingAmt() {
		return pendingAmt;
	}

	public void setPendingAmt(Double pendingAmt) {
		this.pendingAmt = pendingAmt;
	}

	public Timestamp getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Timestamp receivedDate) {
		this.receivedDate = receivedDate;
	}

	public Timestamp getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Timestamp expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getWrContributionAtTransfer() {
		return wrContributionAtTransfer;
	}

	public void setWrContributionAtTransfer(Double wrContributionAtTransfer) {
		this.wrContributionAtTransfer = wrContributionAtTransfer;
	}

	public Double getRedeemedAmtToCash() {
		return redeemedAmtToCash;
	}

	public void setRedeemedAmtToCash(Double redeemedAmtToCash) {
		this.redeemedAmtToCash = redeemedAmtToCash;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public String getBonusCriteria() {
		return bonusCriteria;
	}

	public void setBonusCriteria(String bonusCriteria) {
		this.bonusCriteria = bonusCriteria;
	}

	
}
