package com.stpl.pms.utility;

public enum RefWinTxnColumn {
	IGE("refTxnNo"),
	RUMMY("transactionId"),
	SGE_INT("refTxnNo"),
	BET_IN_ACTION("refTxnNo"),
	IGE_CASINO("refTxnNo"),
	BET_GAMES_TV("betId"),
	BET_SOFT_GAMES("refTxnNo"),
	SHERRIFF("refTxnNo"),
	BINGO("transactionId"),
	POKER("transactionId"),
	DGE("transactionId");
	
	private final String column;

	private RefWinTxnColumn(String value) {
		this.column = value;
	}

	public String getValue() {
		return column;
	}
}