package com.stpl.pms.hibernate.mapping;

public class StRmBoRolePrivMapping implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer roleId;
	private Integer privId;
	private Short sdmId;
	private String status;

	// Constructors

	/** default constructor */
	public StRmBoRolePrivMapping() {
	}

	
	public StRmBoRolePrivMapping(Integer roleId, Integer privId, Short sdmId,
			String status) {
		super();
		this.roleId = roleId;
		this.privId = privId;
		this.sdmId = sdmId;
		this.status = status;
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPrivId() {
		return this.privId;
	}

	public void setPrivId(Integer privId) {
		this.privId = privId;
	}

	public Short getSdmId() {
		return this.sdmId;
	}

	public void setSdmId(Short sdmId) {
		this.sdmId = sdmId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}