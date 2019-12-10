package com.stpl.pms.hibernate.mapping;

/**
 * StPortalGameLobbyMapping entity. @author MyEclipse Persistence Tools
 */

public class StPortalGameLobbyMapping implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Integer mappingId;
	private Integer lobbyId;
	private Integer showOrder;
	private short domainId;
	private String status;
	private StPortalGamesMaster stPortalGamesMaster;
	private StPortalGameThemeMaster stPortalGameThemeMaster;
	
	

	// Constructors
	/** default constructor */
	public StPortalGameLobbyMapping() {
	}

	public Integer getMappingId() {
		return mappingId;
	}



	public Integer getLobbyId() {
		return lobbyId;
	}


	public String getStatus() {
		return status;
	}

	public void setMappingId(Integer mappingId) {
		this.mappingId = mappingId;
	}



	public void setLobbyId(Integer lobbyId) {
		this.lobbyId = lobbyId;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	



	public short getDomainId() {
		return domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public StPortalGamesMaster getStPortalGamesMaster() {
		return stPortalGamesMaster;
	}

	public void setStPortalGamesMaster(StPortalGamesMaster stPortalGamesMaster) {
		this.stPortalGamesMaster = stPortalGamesMaster;
	}

	public Integer getShowOrder() {
		return showOrder;
	}

	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}

	public void setStPortalGameThemeMaster(StPortalGameThemeMaster stPortalGameThemeMaster) {
		this.stPortalGameThemeMaster = stPortalGameThemeMaster;
	}

	public StPortalGameThemeMaster getStPortalGameThemeMaster() {
		return stPortalGameThemeMaster;
	}


}