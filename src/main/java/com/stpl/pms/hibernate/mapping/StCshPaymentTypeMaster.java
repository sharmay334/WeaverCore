package com.stpl.pms.hibernate.mapping;



/**
 * StCshPaymentTypeMaster entity. @author MyEclipse Persistence Tools
 */

public class StCshPaymentTypeMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer paymentTypeId;
	private String paymentTypeDispCode;
	private String paymentTypeCode;
	private String imagePath;
	private String status;
	private String paymentTypeMode;
	private String isDepositApproval;
	private String isWithdrawApproval;
	private Integer uiOrder;
	private Integer uiOrderWithdrawal;
	// Constructors

	/** default constructor */
	public StCshPaymentTypeMaster() {
	}

	// Property accessors

	public Integer getPaymentTypeId() {
		return this.paymentTypeId;
	}

	public void setPaymentTypeId(Integer paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public String getPaymentTypeDispCode() {
		return this.paymentTypeDispCode;
	}

	public void setPaymentTypeDispCode(String paymentTypeDispCode) {
		this.paymentTypeDispCode = paymentTypeDispCode;
	}

	public String getPaymentTypeCode() {
		return this.paymentTypeCode;
	}

	public void setPaymentTypeCode(String paymentTypeCode) {
		this.paymentTypeCode = paymentTypeCode;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentTypeMode() {
		return this.paymentTypeMode;
	}

	public void setPaymentTypeMode(String paymentTypeMode) {
		this.paymentTypeMode = paymentTypeMode;
	}


	public void setIsDepositApproval(String isDepositApproval) {
		this.isDepositApproval = isDepositApproval;
	}

	public String getIsDepositApproval() {
		return isDepositApproval;
	}

	public void setIsWithdrawApproval(String isWithdrawApproval) {
		this.isWithdrawApproval = isWithdrawApproval;
	}

	public String getIsWithdrawApproval() {
		return isWithdrawApproval;
	}

	public Integer getUiOrder() {
		return uiOrder;
	}

	public void setUiOrder(Integer uiOrder) {
		this.uiOrder = uiOrder;
	}

	public Integer getUiOrderWithdrawal() {
		return uiOrderWithdrawal;
	}

	public void setUiOrderWithdrawal(Integer uiOrderWithdrawal) {
		this.uiOrderWithdrawal = uiOrderWithdrawal;
	}
}