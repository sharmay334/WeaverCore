package com.stpl.pms.hibernate.mapping;

/**
 * StRmPlrRoleMaster entity. @author MyEclipse Persistence Tools
 */

public class StRmPlrRoleMaster implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer roleId;
	private String roleName;
	private String roleDescription;
	private Short domainId;
	private String status;

	// Constructors

	/** default constructor */
	public StRmPlrRoleMaster() {
	}

	/** minimal constructor */
	public StRmPlrRoleMaster(String roleName) {
		this.roleName = roleName;
	}

	/** full constructor */
	public StRmPlrRoleMaster(String roleName, String roleDescription,
			Short domainId, String status) {
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.domainId = domainId;
		this.status = status;
	}

	// Property accessors

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

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}