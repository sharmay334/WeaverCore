package com.stpl.pms.hibernate.mapping;

/**
 * StCshPaySubMasterCc entity. @author MyEclipse Persistence Tools
 */

public class StCshPaySubMasterCc extends StCshPaySubMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private String cardName;
	private String status;
	private int uiOrder;
	// Constructors

	/** default constructor */
	public StCshPaySubMasterCc() {
	}

	/** full constructor */
	public StCshPaySubMasterCc(String cardName, String status,int uiOrder) {
		this.cardName = cardName;
		this.status = status;
		this.uiOrder = uiOrder;
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