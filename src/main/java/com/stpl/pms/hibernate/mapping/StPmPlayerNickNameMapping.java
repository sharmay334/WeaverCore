package com.stpl.pms.hibernate.mapping;

public class StPmPlayerNickNameMapping implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private Short domainId;
	private Long playerId;
	private String userName;
	private String pokerNickName;
	private String rummyNickName;
	private String casinoNickName;
	
	public StPmPlayerNickNameMapping(){
		
	}
	
	public StPmPlayerNickNameMapping(Short domainId,Long playerId, String userName,
			String pokerNickName, String rummyNickName, String casinoNickName) {
		super();
		this.domainId=domainId;
		this.playerId = playerId;
		this.userName = userName;
		this.pokerNickName = pokerNickName;
		this.rummyNickName = rummyNickName;
		this.casinoNickName = casinoNickName;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Short getDomainId() {
		return domainId;
	}

	public void setDomainId(Short domainId) {
		this.domainId = domainId;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
