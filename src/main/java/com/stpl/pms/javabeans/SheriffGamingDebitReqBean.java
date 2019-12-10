package com.stpl.pms.javabeans;

import java.util.Map;

public class SheriffGamingDebitReqBean implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "SheriffGamingDebitReqBean [currency=" + currency + ", custom="
				+ custom + ", end_gamerun=" + end_gamerun + ", feature="
				+ feature + ", game_id=" + game_id + ", gamehash_id="
				+ gamehash_id + ", gamerun_id=" + gamerun_id
				+ ", player_reference=" + player_reference + ", resend="
				+ resend + ", session_id=" + session_id + ", signature="
				+ signature + ", step=" + step + ", transaction=" + transaction
				+ ", transaction_id=" + transaction_id + "]";
	}
	private Integer transaction_id;
	private Integer player_reference;
	private Integer game_id;
	private String session_id;
	private Integer gamehash_id;
	private Integer gamerun_id;
	private String currency;
	private Map<String,Integer> transaction;
	private Integer step;
	private boolean end_gamerun; 
	private boolean resend;
	private String custom;
	public boolean isEnd_gamerun() {
		return end_gamerun;
	}
	public void setEnd_gamerun(boolean endGamerun) {
		end_gamerun = endGamerun;
	}
	public boolean isResend() {
		return resend;
	}
	public void setResend(boolean resend) {
		this.resend = resend;
	}
	public String getCustom() {
		return custom;
	}
	public void setCustom(String custom) {
		this.custom = custom;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	private String feature;
	private String signature;
	public Integer getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(Integer transactionId) {
		transaction_id = transactionId;
	}
	public Integer getPlayer_reference() {
		return player_reference;
	}
	public void setPlayer_reference(Integer playerReference) {
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
	public Integer getGamehash_id() {
		return gamehash_id;
	}
	public void setGamehash_id(Integer gamehashId) {
		gamehash_id = gamehashId;
	}
	public Integer getGamerun_id() {
		return gamerun_id;
	}
	public void setGamerun_id(Integer gamerunId) {
		gamerun_id = gamerunId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Map<String, Integer> getTransaction() {
		return transaction;
	}
	public void setTransaction(Map<String, Integer> transaction) {
		this.transaction = transaction;
	}
	public Integer getStep() {
		return step;
	}
	public void setStep(Integer step) {
		this.step = step;
	}
}
