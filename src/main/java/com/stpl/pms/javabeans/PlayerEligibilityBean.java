package com.stpl.pms.javabeans;

import java.io.Serializable;

public class PlayerEligibilityBean extends PlayerEligibilityCriteriaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String domainName;
	private Long playerId;
	private String sessionId;
//	private PlayerEligibilityCriteriaBean eligibilityCriteria;

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

//	public PlayerEligibilityCriteriaBean getEligibilityCriteria() {
//		return eligibilityCriteria;
//	}

//	public void setEligibilityCriteria(
//			PlayerEligibilityCriteriaBean eligibilityCriteria) {
//		this.eligibilityCriteria = eligibilityCriteria;
//	}

}
