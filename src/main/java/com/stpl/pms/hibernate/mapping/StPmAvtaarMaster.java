package com.stpl.pms.hibernate.mapping;

/**
 * StPmAvtaarMaster entity. @author MyEclipse Persistence Tools
 */

public class StPmAvtaarMaster implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer avtaarId;
	private String avtaarName;
	private String avtaarPath;
	private String status;

	// Constructors

	/** default constructor */
	public StPmAvtaarMaster() {
	}

	/** full constructor */
	public StPmAvtaarMaster(String avtaarName, String avtaarPath, String status) {
		this.avtaarName = avtaarName;
		this.avtaarPath = avtaarPath;
		this.status = status;
	}

	// Property accessors

	public Integer getAvtaarId() {
		return this.avtaarId;
	}

	public void setAvtaarId(Integer avtaarId) {
		this.avtaarId = avtaarId;
	}

	public String getAvtaarName() {
		return this.avtaarName;
	}

	public void setAvtaarName(String avtaarName) {
		this.avtaarName = avtaarName;
	}

	public String getAvtaarPath() {
		return this.avtaarPath;
	}

	public void setAvtaarPath(String avtaarPath) {
		this.avtaarPath = avtaarPath;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}