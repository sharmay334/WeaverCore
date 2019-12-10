package com.stpl.pms.hibernate.mapping;

/**
 * StTxnPlrBonusWgrReqMaster entity. @author MyEclipse Persistence Tools
 */

public class StTxnPlrBonusWgrReqMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short domainId;
	private Short serviceId;
	private String gameType;
	private Double wagerContribution;
	private String wrStatus;

	// Constructors

	/** default constructor */
	public StTxnPlrBonusWgrReqMaster() {
	}

	/** minimal constructor */
	public StTxnPlrBonusWgrReqMaster(Short domainId, Double wagerContribution,
			String wrStatus) {
		this.domainId = domainId;
		this.wagerContribution = wagerContribution;
		this.wrStatus = wrStatus;
	}

	/** full constructor */
	public StTxnPlrBonusWgrReqMaster(Short domainId, Short serviceId,
			String gameType, Double wagerContribution, String wrStatus) {
		this.domainId = domainId;
		this.serviceId = serviceId;
		this.gameType = gameType;
		this.wagerContribution = wagerContribution;
		this.wrStatus = wrStatus;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Short getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Short serviceId) {
		this.serviceId = serviceId;
	}

	public String getGameType() {
		return this.gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public Double getWagerContribution() {
		return this.wagerContribution;
	}

	public void setWagerContribution(Double wagerContribution) {
		this.wagerContribution = wagerContribution;
	}

	public String getWrStatus() {
		return this.wrStatus;
	}

	public void setWrStatus(String wrStatus) {
		this.wrStatus = wrStatus;
	}

}