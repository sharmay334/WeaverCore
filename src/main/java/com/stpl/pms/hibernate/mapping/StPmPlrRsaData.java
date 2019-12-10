package com.stpl.pms.hibernate.mapping;

import java.io.Serializable;

public class StPmPlrRsaData implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long playerId;
	private Short domainId;
	private String rsaId;

	public StPmPlrRsaData() {
		// default constructor
	}
	
	public StPmPlrRsaData(Long id, Long playerId, Short domainId, String rsaId) {
		this.id = id;
		this.playerId = playerId;
		this.domainId = domainId;
		this.rsaId = rsaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Short getDomainId() {
		return domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public String getRsaId() {
		return rsaId;
	}

	public void setRsaId(String rsaId) {
		this.rsaId = rsaId;
	}
}
