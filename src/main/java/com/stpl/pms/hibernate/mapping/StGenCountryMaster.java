package com.stpl.pms.hibernate.mapping;

import java.util.List;

/**
 * StGenCountryMaster entity. @author MyEclipse Persistence Tools
 */

public class StGenCountryMaster implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String countryCode;
	private String name;
	private String status;
	private List<StGenStateMaster> stateList;

	// Constructors

	/** default constructor */
	public StGenCountryMaster() {
	}

	/** full constructor */
	public StGenCountryMaster(String countryCode, String name, String status) {
		this.countryCode = countryCode;
		this.name = name;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStateList(List<StGenStateMaster> stateList) {
		this.stateList = stateList;
	}

	public List<StGenStateMaster> getStateList() {
		return stateList;
	}

}