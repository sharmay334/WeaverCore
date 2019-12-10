package com.stpl.pms.hibernate.mapping;

/**
 * StCshPaySubMasterDc entity. @author MyEclipse Persistence Tools
 */

public class StCshPaySubMasterDc extends StCshPaySubMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private String cardName;
	private String status;
	private int uiOrder;

	// Constructors

	/** default constructor */
	public StCshPaySubMasterDc() {
	}

	/** full constructor */
	public StCshPaySubMasterDc(String cardName, String status) {
		this.cardName = cardName;
		this.status = status;
	}

	// Property accessors

	public String getCardName() {
		return this.cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUiOrder() {
		return uiOrder;
	}

	public void setUiOrder(int uiOrder) {
		this.uiOrder = uiOrder;
	}

}