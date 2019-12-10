package com.stpl.pms.hibernate.mapping;

/**
 * StTxnPokerGameActionHandMapping entity. @author MyEclipse Persistence Tools
 */

public class StTxnPokerGameActionHandMapping implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long gameActionId;
	private StTxnPokerJeevesHandMaster handMaster;
	private String gameActionDesc;

	// Constructors

	/** default constructor */
	public StTxnPokerGameActionHandMapping() {
	}

	/** full constructor */
	public StTxnPokerGameActionHandMapping(StTxnPokerJeevesHandMaster handId, String gameActionDesc) {
		this.handMaster = handId;
		this.gameActionDesc = gameActionDesc;
	}

	// Property accessors

	public Long getGameActionId() {
		return this.gameActionId;
	}

	public void setGameActionId(Long gameActionId) {
		this.gameActionId = gameActionId;
	}


	public String getGameActionDesc() {
		return this.gameActionDesc;
	}

	public void setGameActionDesc(String gameActionDesc) {
		this.gameActionDesc = gameActionDesc;
	}

	public StTxnPokerJeevesHandMaster getHandMaster() {
		return handMaster;
	}

	public void setHandMaster(StTxnPokerJeevesHandMaster handMaster) {
		this.handMaster = handMaster;
	}

}