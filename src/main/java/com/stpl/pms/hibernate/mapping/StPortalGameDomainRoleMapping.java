package com.stpl.pms.hibernate.mapping;

import com.stpl.pms.javabeans.BoVendorGameBean;

/**
 * StPortalGameDomainRoleMapping entity. @author MyEclipse Persistence Tools
 */

public class StPortalGameDomainRoleMapping implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Short domainId;
	private Integer roleId;
	private String status;
	private String gameGroupType;
    private StPortalGamesMaster stPortalGamesMaster;

	// Constructors

	/** default constructor */
	public StPortalGameDomainRoleMapping() {
	}

	public StPortalGameDomainRoleMapping(Integer id, Short domainId,
			Integer roleId, String status) {
		super();
		this.id = id;
		this.domainId = domainId;
		this.roleId = roleId;
		this.status = status;
	}
	public StPortalGameDomainRoleMapping( Short domainId,
			Integer roleId, String status
			) {
		super();
		this.domainId = domainId;
		this.roleId = roleId;
		this.status = status;
	}
	
	public StPortalGameDomainRoleMapping( Short domainId,
			Integer roleId, String status,String gameGroupType,
			StPortalGamesMaster stPortalGamesMaster) {
		super();
		this.domainId = domainId;
		this.roleId = roleId;
		this.status = status;
		this.gameGroupType = gameGroupType;
		this.stPortalGamesMaster = stPortalGamesMaster;
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

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public StPortalGamesMaster getStPortalGamesMaster() {
		return stPortalGamesMaster;
	}

	public void setStPortalGamesMaster(StPortalGamesMaster stPortalGamesMaster) {
		this.stPortalGamesMaster = stPortalGamesMaster;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((stPortalGamesMaster.getGameId() == null) ? 0 : stPortalGamesMaster.getGameId()
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		BoVendorGameBean other = (BoVendorGameBean) obj;
		if (this.stPortalGamesMaster.getGameId() == null) {
			if (other.getGameId() != null)
				return false;
		} else if (!this.stPortalGamesMaster.getGameId().equals(other.getGameId()))
			return false;
		return true;
	}

	public void setGameGroupType(String gameGroupType) {
		this.gameGroupType = gameGroupType;
	}

	public String getGameGroupType() {
		return gameGroupType;
	}

}