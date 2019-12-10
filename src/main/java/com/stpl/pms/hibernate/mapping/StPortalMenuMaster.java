package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * StPortalMenuMaster entity. @author MyEclipse Persistence Tools
 */

public class StPortalMenuMaster implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer menuId;
	private Short domainId;
	private Short aliasId;
	private StPortalContentMaster stPortalContentMaster;
	private Integer displayCode;
	private Integer order;
	private Short level;
	private String device;
	private String contentType;
	private Integer parentId;
	private String status;
	private Long createdBy;
	private Timestamp creationTime;
	private Long lastUpdatedBy;
	private Timestamp lastUpdationTime;
	private Set<StPortalMenuMaster> subMenuMasterSet = new HashSet<StPortalMenuMaster>(0);
	private String highLightOpt;
	// Constructors

	/** default constructor */
	public StPortalMenuMaster() {
	}

	/** Minimal constructor */
	public StPortalMenuMaster(Short domainId, StPortalContentMaster stPortalContentMaster,
			Integer displayCode, Integer order, Short level,String device,
			String contentType, Integer parentId, String status) {
		this.domainId = domainId;
		this.stPortalContentMaster = stPortalContentMaster;
		this.displayCode = displayCode;
		this.order = order;
		this.level = level;
		this.device = device;
		this.contentType = contentType;
		this.parentId = parentId;
		this.status = status;
	}
	
	/** full constructor */
	public StPortalMenuMaster(Short domainId, Short aliasId, StPortalContentMaster stPortalContentMaster,
			Integer displayCode, Integer order, Short level,String device,
			String contentType, Integer parentId, String status) {
		this.domainId = domainId;
		this.aliasId = aliasId;
		this.stPortalContentMaster = stPortalContentMaster;
		this.displayCode = displayCode;
		this.order = order;
		this.level = level;
		this.device = device;
		this.contentType = contentType;
		this.parentId = parentId;
		this.status = status;
	}
	
//	public StPortalMenuMaster(PortalMenuBean menuDataBean,Short domainId,String device, Short level,Integer order,Integer parentId){
//		this.domainId = domainId;
//		stPortalContentMaster = new StPortalContentMaster();
//		this.stPortalContentMaster.setContentId(menuDataBean.getContentId());
//		this.displayCode = menuDataBean.getMenuDisplayCode();
//		this.isPreLogin =  menuDataBean.getIsPreLogin();
//		this.level = level;
//		this.order = order;
//		this.device =  device;
//		this.contentType =  menuDataBean.getContentType();
//		this.parentId = parentId;
//		this.status = "ACTIVE";
//	}
/*	public StPortalMenuMaster(MenuDataBean menuDataBean,Short domainId,String device,Short level,Integer order, Integer parentId){
		
		this.domainId = domainId;
		stPortalContentMaster = new StPortalContentMaster();
		this.stPortalContentMaster.setContentId(menuDataBean.getContentName());
		this.displayCode = menuDataBean.getDisplayCode();
		this.isPreLogin =  menuDataBean.getShowBeforeLogin();
		this.level = level;
		this.order = order;
		this.device =  device;
		this.contentType =  menuDataBean.getContentType();
		this.parentId = parentId;
		this.status = menuDataBean.getStatus();
	}*/

	// Property accessors

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Integer getDisplayCode() {
		return this.displayCode;
	}

	public void setDisplayCode(Integer displayCode) {
		this.displayCode = displayCode;
	}

	public Integer getOrder() {
		return this.order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Short getLevel() {
		return this.level;
	}

	public void setLevel(Short level) {
		this.level = level;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setSubMenuMasterSet(Set<StPortalMenuMaster> subMenuMasterSet) {
		this.subMenuMasterSet = subMenuMasterSet;
	}

	public Set<StPortalMenuMaster> getSubMenuMasterSet() {
		return subMenuMasterSet;
	}

	public void setStPortalContentMaster(StPortalContentMaster stPortalContentMaster) {
		this.stPortalContentMaster = stPortalContentMaster;
	}

	public StPortalContentMaster getStPortalContentMaster() {
		return stPortalContentMaster;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getDevice() {
		return device;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getLastUpdationTime() {
		return lastUpdationTime;
	}

	public void setLastUpdationTime(Timestamp lastUpdationTime) {
		this.lastUpdationTime = lastUpdationTime;
	}

	public Short getAliasId() {
		return aliasId;
	}

	public void setAliasId(Short aliasId) {
		this.aliasId = aliasId;
	}

	public String getHighLightOpt() {
		return highLightOpt;
	}

	public void setHighLightOpt(String highLightOpt) {
		this.highLightOpt = highLightOpt;
	}
	
	

}