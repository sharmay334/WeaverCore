package com.stpl.pms.javabeans;


public class SheriffGamingTransactionBean implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer transaction_id;
	private Long player_reference;
	private Integer game_id;
	private String session_id;
	private Integer gamehash_id;
	private Integer gamerun_id;
	private String currency;
	private SheriffGamingRealBonusBean transaction;
	private Integer step;
	private boolean end_gamerun; 
	private boolean resend;
	private String custom;
	private String feature;
	private String signature;
	
	public boolean getEnd_gamerun() {
		return end_gamerun;
	}
	public void setEnd_gamerun(boolean endGamerun) {
		end_gamerun = endGamerun;
	}
	public boolean getResend() {
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
	
	public Integer getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(Integer transactionId) {
		transaction_id = transactionId;
	}
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
	public SheriffGamingRealBonusBean getTransaction() {
		return transaction;
	}
	public void setTransaction(SheriffGamingRealBonusBean transaction) {
		this.transaction = transaction;
	}
	public Integer getStep() {
		return step;
	}
	public void setStep(Integer step) {
		this.step = step;
	}
	@Override
	public String toString() {
		return "SheriffGamingTransactionBean [currency=" + currency
				+ ", custom=" + custom + ", end_gamerun=" + end_gamerun
				+ ", feature=" + feature + ", game_id=" + game_id
				+ ", gamehash_id=" + gamehash_id + ", gamerun_id=" + gamerun_id
				+ ", player_reference=" + player_reference + ", resend="
				+ resend + ", session_id=" + session_id + ", signature="
				+ signature + ", step=" + step + ", transaction=" + transaction
				+ ", transaction_id=" + transaction_id + "]";
	}
	
	
}
