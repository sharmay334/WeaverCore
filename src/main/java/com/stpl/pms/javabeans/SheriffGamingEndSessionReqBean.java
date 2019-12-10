package com.stpl.pms.javabeans;

import java.util.Arrays;

public class SheriffGamingEndSessionReqBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long player_reference;
	private Integer game_id;
	private String session_id;
	private String[] custom;
	private String signature;
	public Long getPlayer_reference() {
		return player_reference;
	}
	public void setPlayer_reference(Long playerReference) {
		player_reference = playerReference;
	}
	public Integer getGame_id() {
		return game_id;
	}
	public void setGame_id(Integer gameId) {
		game_id = gameId;
	}
	public String getSession_id() {
		return session_id;
	}
	public void setSession_id(String sessionId) {
		session_id = sessionId;
	}
	public String[] getCustom() {
		return custom;
	}
	public void setCustom(String[] custom) {
		this.custom = custom;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	@Override
	public String toString() {
		return "SheriffGamingEndSessionReqBean [custom="
				+ Arrays.toString(custom) + ", game_id=" + game_id
				+ ", player_reference=" + player_reference + ", session_id="
				+ session_id + ", signature=" + signature + "]";
	}
	
}
