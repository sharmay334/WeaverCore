package com.stpl.pms.utility;

public enum TxnTypeForLedger {
	PLR_BONUS_TRANSFER,        
	PLR_DEPOSIT,  
	PLR_WAGER,       
	PLR_WAGER_REFUND,      
	PLR_WINNING,      
//	BO_CORRECTION,       ---- 
	PLR_WITHDRAWAL,    
	PLR_DEPOSIT_AGAINST_CANCEL, 
	PLR_TRANSFER_TO_SUBWALLET,
	PLR_TRANSFER_FROM_SUBWALLET;
//	LOYALTYCASH

	public static String[] names() {
		TxnTypeForLedger[] txnTypes = values();
	    String[] txnTypeVal = new String[txnTypes.length];

	    for (int i = 0; i < txnTypes.length; i++) {
	    	txnTypeVal[i] = txnTypes[i].name();
	    }

	    return txnTypeVal;
	}
	
	
}
