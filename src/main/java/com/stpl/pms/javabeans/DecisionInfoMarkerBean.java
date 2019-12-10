package com.stpl.pms.javabeans;

import java.sql.Timestamp;

import com.stpl.pms.hibernate.mapping.StRiskDecisionDoerMaster;

public interface DecisionInfoMarkerBean {

	public Integer getId();
	public void setId(Integer id);
	public Short getDomainId();
	public void setDomainId(Short domainId);
	public Long getPlayerId();
	public void setPlayerId(Long playerId);
	public String getValue();
	public void setValue(String value);
	public String getUserId();
	public void setUserId(String userId);
	public Timestamp getUpdDatetime();
	public void setUpdDatetime(Timestamp updDatetime);
	public void setDoerMaster(StRiskDecisionDoerMaster doerMaster);
	public StRiskDecisionDoerMaster getDoerMaster();

}
