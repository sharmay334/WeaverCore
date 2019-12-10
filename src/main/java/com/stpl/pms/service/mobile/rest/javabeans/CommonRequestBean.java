package com.stpl.pms.service.mobile.rest.javabeans;

import java.io.Serializable;

public class CommonRequestBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long playerId;
	private String playerToken;
	private String domainName;

	public CommonRequestBean() {
	}

	public CommonRequestBean(Long playerId, String playerToken,
			String domainName) {
		this.playerId = playerId;
		this.playerToken = playerToken;
		this.domainName = domainName;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerToken() {
		return playerToken;
	}

	public void setPlayerToken(String playerToken) {
		this.playerToken = playerToken;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

}
