package com.stpl.pms.hibernate.mapping;

/**
 * StPortalLobbyMaster entity. @author MyEclipse Persistence Tools
 */

public class StPortalLobbyMaster implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer lobbyId;
	private String lobbyName;
	private String lobbyCode;
	private String relatedToGroup;

	// Constructors

	/** default constructor */
	public StPortalLobbyMaster() {
	}

	/** minimal constructor */
	public StPortalLobbyMaster(String lobbyCode, String relatedToGroup) {
		this.lobbyCode = lobbyCode;
		this.relatedToGroup = relatedToGroup;
	}

	/** full constructor */
	public StPortalLobbyMaster(String lobbyName, String lobbyCode,
			String relatedToGroup) {
		this.lobbyName = lobbyName;
		this.lobbyCode = lobbyCode;
		this.relatedToGroup = relatedToGroup;
	}

	// Property accessors

	public Integer getLobbyId() {
		return this.lobbyId;
	}

	public void setLobbyId(Integer lobbyId) {
		this.lobbyId = lobbyId;
	}

	public String getLobbyName() {
		return this.lobbyName;
	}

	public void setLobbyName(String lobbyName) {
		this.lobbyName = lobbyName;
	}

	public String getLobbyCode() {
		return this.lobbyCode;
	}

	public void setLobbyCode(String lobbyCode) {
		this.lobbyCode = lobbyCode;
	}

	public String getRelatedToGroup() {
		return this.relatedToGroup;
	}

	public void setRelatedToGroup(String relatedToGroup) {
		this.relatedToGroup = relatedToGroup;
	}

}