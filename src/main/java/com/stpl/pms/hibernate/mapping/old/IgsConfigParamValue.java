package com.stpl.pms.hibernate.mapping.old;

/**
 * IgsConfigParamValue entity. @author MyEclipse Persistence Tools
 */

public class IgsConfigParamValue implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Short configParamValueId;
	private String paramName;
	private String paramValue;
	private String status;
	private String desc;

	// Constructors

	/** default constructor */
	public IgsConfigParamValue() {
	}

	/** minimal constructor */
	public IgsConfigParamValue(Short configParamValueId, String paramName,
			String paramValue, String status) {
		this.configParamValueId = configParamValueId;
		this.paramName = paramName;
		this.paramValue = paramValue;
		this.status = status;
	}

	/** full constructor */
	public IgsConfigParamValue(Short configParamValueId, String paramName,
			String paramValue, String status, String desc) {
		this.configParamValueId = configParamValueId;
		this.paramName = paramName;
		this.paramValue = paramValue;
		this.status = status;
		this.desc = desc;
	}

	// Property accessors

	public Short getConfigParamValueId() {
		return this.configParamValueId;
	}

	public void setConfigParamValueId(Short configParamValueId) {
		this.configParamValueId = configParamValueId;
	}

	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamValue() {
		return this.paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}