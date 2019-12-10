package com.stpl.pms.javabeans;

import java.io.Serializable;

public class PlayerNickNameBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long playerId;
	private String pokerNickName;
	private String rummyNickName;
	private String casinoNickName;
	
	public PlayerNickNameBean(){
		
	}
	
	public PlayerNickNameBean(Long playerId, String pokerNickName,
			String rummyNickName, String casinoNickName) {
		super();
		this.playerId = playerId;
		this.pokerNickName = pokerNickName;
		this.rummyNickName = rummyNickName;
		this.casinoNickName = casinoNickName;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getPokerNickName() {
		return pokerNickName;
	}

	public void setPokerNickName(String pokerNickName) {
		this.pokerNickName = pokerNickName;
	}

	public String getRummyNickName() {
		return rummyNickName;
	}

	public void setRummyNickName(String rummyNickName) {
		this.rummyNickName = rummyNickName;
	}

	public String getCasinoNickName() {
		return casinoNickName;
	}

	public void setCasinoNickName(String casinoNickName) {
		this.casinoNickName = casinoNickName;
	}
	
	
	
	
}
