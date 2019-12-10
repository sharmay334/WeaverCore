package com.stpl.pms.hibernate.mapping;

/**
 * StRpBoMisAccountReportMaster entity. @author MyEclipse Persistence Tools
 */

public class StRpBoMisAccountReportMaster implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Short id;
	private String ReportName;
	private String ReportProcedureName;
	private String status;
	private Short domainId;
	private short aliasId;
	private String reportType;

	// Constructors

	/** default constructor */
	public StRpBoMisAccountReportMaster() {
	}

	/** minimal constructor */
	public StRpBoMisAccountReportMaster(String ReportName,
										String ReportProcedureName) {
		this.ReportName = ReportName;
		this.ReportProcedureName = ReportProcedureName;
	}

	/** full constructor */
	public StRpBoMisAccountReportMaster(String ReportName,
										String ReportProcedureName, String status,String reportType) {
		this.ReportName = ReportName;
		this.ReportProcedureName = ReportProcedureName;
		this.status = status;
		this.reportType = reportType;
	}

	// Property accessors

	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getReportName() {
		return ReportName;
	}

	public void setReportName(String reportName) {
		ReportName = reportName;
	}

	public String getReportProcedureName() {
		return ReportProcedureName;
	}

	public void setReportProcedureName(String reportProcedureName) {
		ReportProcedureName = reportProcedureName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Short getDomainId() {
		return domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public short getAliasId() {
		return aliasId;
	}

	public void setAliasId(short aliasId) {
		this.aliasId = aliasId;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
}