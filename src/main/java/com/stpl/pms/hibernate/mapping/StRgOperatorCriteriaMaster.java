package com.stpl.pms.hibernate.mapping;

/**
 * StRgOperatorCriteriaMaster entity. @author MyEclipse Persistence Tools
 */

public class StRgOperatorCriteriaMaster implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer criteriaId;
	private String criteria;
	private String criteriaAction;
	private String period;
	private String gameGroup;
	private String errorMessage;
	private String criteriaDesc;

	// Constructors

	/** default constructor */
	public StRgOperatorCriteriaMaster() {
	}

	/** full constructor */
	public StRgOperatorCriteriaMaster(String criteria, String criteriaAction,
			String period, String gameGroup, String errorMessage,
			String criteriaDesc) {
		this.criteria = criteria;
		this.criteriaAction = criteriaAction;
		this.period = period;
		this.gameGroup = gameGroup;
		this.errorMessage = errorMessage;
		this.criteriaDesc = criteriaDesc;
	}

	// Property accessors

	public Integer getCriteriaId() {
		return this.criteriaId;
	}

	public void setCriteriaId(Integer criteriaId) {
		this.criteriaId = criteriaId;
	}

	public String getCriteria() {
		return this.criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public String getCriteriaAction() {
		return this.criteriaAction;
	}

	public void setCriteriaAction(String criteriaAction) {
		this.criteriaAction = criteriaAction;
	}

	public String getPeriod() {
		return this.period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getGameGroup() {
		return this.gameGroup;
	}

	public void setGameGroup(String gameGroup) {
		this.gameGroup = gameGroup;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getCriteriaDesc() {
		return this.criteriaDesc;
	}

	public void setCriteriaDesc(String criteriaDesc) {
		this.criteriaDesc = criteriaDesc;
	}

}