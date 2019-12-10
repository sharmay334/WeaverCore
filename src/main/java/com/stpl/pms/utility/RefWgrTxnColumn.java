package com.stpl.pms.utility;
public enum RefWgrTxnColumn {
	IGE("transactionId"),
	SGE("transactionId"),
	RUMMY("transactionId"),
	SGE_INT("refTxnNo"),
	BET_IN_ACTION("refTxnNo"),
	IGE_CASINO("refTxnNo"),
	BET_GAMES_TV("betId"),
	BET_SOFT_GAMES("refTxnNo"),
	SHERRIFF("refTxnNo"),
	BINGO("transactionId"),
	POKER("actionId"),
	INSTANT_DRAW("transactionId"),
	DGE("transactionId"),
	DRAW_GAMES("transactionId"),
	SLE("transactionId"),
	MRSLOTTY("transactionId"),
	GR("tmpId"),
	SBS("transactionId");
	private final String column;

	private RefWgrTxnColumn(String value) {
		this.column = value;
	}
	public String getValue() {
        return column;
    }
}
