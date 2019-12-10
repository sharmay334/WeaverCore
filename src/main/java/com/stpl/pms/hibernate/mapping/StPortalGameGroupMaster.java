package com.stpl.pms.hibernate.mapping;

/**
 * StPortalGameGroupMaster entity. @author MyEclipse Persistence Tools
 */

public class StPortalGameGroupMaster implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer groupId;
	private String groupName;
	private String status;

	// Constructors

	/** default constructor */
	public StPortalGameGroupMaster() {
	}

	/** minimal constructor */
	public StPortalGameGroupMaster(String groupName) {
		this.groupName = groupName;
	}

	/** full constructor */
	public StPortalGameGroupMaster(String groupName, String status) {
		this.groupName = groupName;
		this.status = status;
	}

	// Property accessors

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}