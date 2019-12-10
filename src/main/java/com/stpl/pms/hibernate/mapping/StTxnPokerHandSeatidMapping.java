package com.stpl.pms.hibernate.mapping;

/**
 * StTxnPokerHandSeatidMapping entity. @author MyEclipse Persistence Tools
 */

public class StTxnPokerHandSeatidMapping implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long showDownId;
	private StTxnPokerJeevesHandMaster handMaster;
	private Long seatId;
	private String cardCombination;

	// Constructors

	/** default constructor */
	public StTxnPokerHandSeatidMapping() {
	}

	/** full constructor */
	public StTxnPokerHandSeatidMapping(StTxnPokerJeevesHandMaster handId, Long seatId,
			String cardCombination) {
		this.setHandMaster(handId);
		this.seatId = seatId;
		this.cardCombination = cardCombination;
	}

	// Property accessors

	public Long getShowDownId() {
		return this.showDownId;
	}

	public void setShowDownId(Long showDownId) {
		this.showDownId = showDownId;
	}

	public Long getSeatId() {
		return this.seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public String getCardCombination() {
		return this.cardCombination;
	}

	public void setCardCombination(String cardCombination) {
		this.cardCombination = cardCombination;
	}

	public StTxnPokerJeevesHandMaster getHandMaster() {
		return handMaster;
	}

	public void setHandMaster(StTxnPokerJeevesHandMaster handMaster) {
		this.handMaster = handMaster;
	}

}