package com.stpl.pms.hibernate.mapping;

@SuppressWarnings("serial")
public class StRiskDuplicateActionNotification implements java.io.Serializable {

	private Integer id;
	private String name;
	private String type;

	/** default constructor */
	public StRiskDuplicateActionNotification() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}