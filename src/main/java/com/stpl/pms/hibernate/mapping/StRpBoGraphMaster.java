package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

/**
 * StRpBoGraphMaster entity. @author MyEclipse Persistence Tools
 */

public class StRpBoGraphMaster implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private short id;
	private short domainId;
	private String graphReportName;
	private String graphProcedureName;
	private String status;
	private long updateInterval;
	private Timestamp lastUpdateTime;
	private String vendorCode;

	// Constructors

	/** default constructor */
	public StRpBoGraphMaster() {
	}

	/** full constructor */
	public StRpBoGraphMaster(short domainId, String graphReportName,
			String graphProcedureName, String status, long updateInterval,
			Timestamp lastUpdateTime) {
		this.domainId = domainId;
		this.graphReportName = graphReportName;
		this.graphProcedureName = graphProcedureName;
		this.status = status;
		this.updateInterval = updateInterval;
		this.lastUpdateTime = lastUpdateTime;
	}

	// Property accessors

	public short getId() {
		return this.id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public short getDomainId() {
		return this.domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public String getGraphReportName() {
		return this.graphReportName;
	}

	public void setGraphReportName(String graphReportName) {
		this.graphReportName = graphReportName;
	}

	public String getGraphProcedureName() {
		return this.graphProcedureName;
	}

	public void setGraphProcedureName(String graphProcedureName) {
		this.graphProcedureName = graphProcedureName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getUpdateInterval() {
		return this.updateInterval;
	}

	public void setUpdateInterval(long updateInterval) {
		this.updateInterval = updateInterval;
	}

	public Timestamp getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}
}