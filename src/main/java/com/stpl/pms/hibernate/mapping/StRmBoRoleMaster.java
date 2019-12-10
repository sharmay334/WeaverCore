package com.stpl.pms.hibernate.mapping;

public class StRmBoRoleMaster implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer roleId;
	private String roleName;
	private String roleDescription;
	private Integer creatorUserId;
	private String tier;
	private String isMaster;
	private String status;

	// Constructors

	/** default constructor */
	public StRmBoRoleMaster() {
	}

	
	public StRmBoRoleMaster(Integer roleId) {
		super();
		this.roleId = roleId;
	}


	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public Integer getCreatorUserId() {
		return this.creatorUserId;
	}

	public void setCreatorUserId(Integer creatorUserId) {
		this.creatorUserId = creatorUserId;
	}

	public String getTier() {
		return this.tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getIsMaster() {
		return this.isMaster;
	}

	public void setIsMaster(String isMaster) {
		this.isMaster = isMaster;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}