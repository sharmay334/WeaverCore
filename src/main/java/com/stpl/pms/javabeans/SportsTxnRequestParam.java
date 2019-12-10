package com.stpl.pms.javabeans;

public class SportsTxnRequestParam implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String token;
	private String refTxnNo;
	private String betRefNo;
	private String winRefNo;
	private Double amount;
	private String gameRef;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRefTxnNo() {
		return refTxnNo;
	}
	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}
	public String getBetRefNo() {
		return betRefNo;
	}
	public void setBetRefNo(String betRefNo) {
		this.betRefNo = betRefNo;
	}
	public String getWinRefNo() {
		return winRefNo;
	}
	public void setWinRefNo(String winRefNo) {
		this.winRefNo = winRefNo;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getGameRef() {
		return gameRef;
	}
	public void setGameRef(String gameRef) {
		this.gameRef = gameRef;
	}
	@Override
	public String toString() {
		return "RequestParam [amount=" + amount + ", betRefNo=" + betRefNo
				+ ", gameRef=" + gameRef + ", refTxnNo=" + refTxnNo
				+ ", token=" + token + ", winRefNo=" + winRefNo + "]";
	}
	
	
}
