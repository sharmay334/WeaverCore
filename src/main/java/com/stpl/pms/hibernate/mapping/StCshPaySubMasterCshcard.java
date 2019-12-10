package com.stpl.pms.hibernate.mapping;

/**
 * StCshPaySubMasterCshcard entity. @author MyEclipse Persistence Tools
 */

public class StCshPaySubMasterCshcard extends StCshPaySubMaster implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer subTypeId;
	private String cardName;
	private String status;

	// Constructors

	/** default constructor */
	public StCshPaySubMasterCshcard() {
	}

	/** full constructor */
	public StCshPaySubMasterCshcard(Integer subTypeId, String cardName,
			String status) {
		this.subTypeId = subTypeId;
		this.cardName = cardName;
		this.status = status;
	}

	// Property accessors

	public Integer getSubTypeId() {
		return this.subTypeId;
	}

	public void setSubTypeId(Integer subTypeId) {
		this.subTypeId = subTypeId;
	}

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

}