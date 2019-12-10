package com.stpl.pms.hibernate.mapping;

public class StRmActionFunctionMappingMgmt implements java.io.Serializable,ActionFunctionMappingInterface {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer fnId;
	private Integer actionId;
	private String actionName;
	private String actionDesc;
	private String actionUrl;
	private String status;
	private StRmMenuMasterMgmt stRmMenuMasterMgmt;
	
	/** default constructor */
	public StRmActionFunctionMappingMgmt() {
	}

	public Integer getFnId() {
		return this.fnId;
	}

	public void setFnId(Integer fnId) {
		this.fnId = fnId;
	}

	public Integer getActionId() {
		return this.actionId;
	}

	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}

	public String getActionName() {
		return this.actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getActionDesc() {
		return this.actionDesc;
	}

	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
	}

	public String getActionUrl() {
		return this.actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStRmMenuMasterMgmt(StRmMenuMasterMgmt stRmMenuMasterMgmt) {
		this.stRmMenuMasterMgmt = stRmMenuMasterMgmt;
	}

	public StRmMenuMasterMgmt getStRmMenuMasterMgmt() {
		return stRmMenuMasterMgmt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

}