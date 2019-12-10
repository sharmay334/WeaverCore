package com.stpl.pms.hibernate.mapping;

/**
 * StPortalLobbyDetails entity. @author MyEclipse Persistence Tools
 */

public class StPortalLobbyDetails implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer lobbyDetailId;
	private Integer lobbyId;
	private Integer serviceId;
	private Integer domainId;
	private Integer venderId;
	private String status;

	// Constructors

	/** default constructor */
	public StPortalLobbyDetails() {
	}

	/** minimal constructor */
	public StPortalLobbyDetails(Integer lobbyId, Integer domainId,
			Integer venderId) {
		this.lobbyId = lobbyId;
		this.domainId = domainId;
		this.venderId = venderId;
	}

	/** full constructor */
	public StPortalLobbyDetails(Integer lobbyId, Integer serviceId,
			Integer domainId, Integer venderId, String status) {
		this.lobbyId = lobbyId;
		this.serviceId = serviceId;
		this.domainId = domainId;
		this.venderId = venderId;
		this.status = status;
	}

	// Property accessors

	public Integer getLobbyDetailId() {
		return this.lobbyDetailId;
	}

	public void setLobbyDetailId(Integer lobbyDetailId) {
		this.lobbyDetailId = lobbyDetailId;
	}

	public Integer getLobbyId() {
		return this.lobbyId;
	}

	public void setLobbyId(Integer lobbyId) {
		this.lobbyId = lobbyId;
	}

	public Integer getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}

	public Integer getVenderId() {
		return this.venderId;
	}

	public void setVenderId(Integer venderId) {
		this.venderId = venderId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}