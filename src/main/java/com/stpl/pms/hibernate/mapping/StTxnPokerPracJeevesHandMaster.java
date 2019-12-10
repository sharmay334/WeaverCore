package com.stpl.pms.hibernate.mapping;

/**
 * StTxnPokerPracJeevesHandMaster entity. @author MyEclipse Persistence Tools
 */

public class StTxnPokerPracJeevesHandMaster implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long handId;
	private String handNumber;
	private String startDate;
	private String endDate;
	private String isRealMoney;
	private String gameType;
	private String playersReceivedCards;
	private String betLimit;
	private String boardCards;
	private String tableId;
	private String stakesLow;
	private String stakesHigh;
	private String blindsLow;
	private String blindsHigh;
	private String antes;
	private String isBlaze;
	private String isAnonymous;
	private String gameAction;
	private String handType;

	// Constructors

	/** default constructor */
	public StTxnPokerPracJeevesHandMaster() {
	}

	/** minimal constructor */
	public StTxnPokerPracJeevesHandMaster(String handNumber) {
		this.handNumber = handNumber;
	}
	
	public StTxnPokerPracJeevesHandMaster(String handNumber, String startDate,
			String endDate, String isRealMoney, String gameType,
			String playersReceivedCards, String betLimit, String boardCards) {
		this.handNumber = handNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isRealMoney = isRealMoney;
		this.gameType = gameType;
		this.playersReceivedCards = playersReceivedCards;
		this.betLimit = betLimit;
		this.boardCards = boardCards;
		
	}

	/** full constructor */
	public StTxnPokerPracJeevesHandMaster(String handNumber, String startDate,
			String endDate, String isRealMoney, String gameType,
			String playersReceivedCards, String betLimit, String boardCards,
			String tableId, String stakesLow, String stakesHigh,
			String blindsLow, String blindsHigh, String antes, Boolean isBlaze,
			Boolean isAnonymous, String gameAction,String handType) {
		this.handNumber = handNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isRealMoney = isRealMoney;
		this.gameType = gameType;
		this.playersReceivedCards = playersReceivedCards;
		this.betLimit = betLimit;
		this.boardCards = boardCards;
		this.tableId = tableId;
		this.stakesLow = stakesLow;
		this.stakesHigh = stakesHigh;
		this.blindsLow = blindsLow;
		this.blindsHigh = blindsHigh;
		this.antes = antes;
		this.isBlaze = String.valueOf(isBlaze);
		this.isAnonymous = String.valueOf(isAnonymous);
		this.gameAction = gameAction;
		this.handType = handType;
	}

	// Property accessors

			
			
			
		// TODO Auto-generated constructor stub

	public Long getHandId() {
		return this.handId;
	}

	public void setHandId(Long handId) {
		this.handId = handId;
	}

	public String getHandNumber() {
		return this.handNumber;
	}

	public void setHandNumber(String handNumber) {
		this.handNumber = handNumber;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getIsRealMoney() {
		return this.isRealMoney;
	}

	public void setIsRealMoney(String isRealMoney) {
		this.isRealMoney = isRealMoney;
	}

	public String getGameType() {
		return this.gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getPlayersReceivedCards() {
		return this.playersReceivedCards;
	}

	public void setPlayersReceivedCards(String playersReceivedCards) {
		this.playersReceivedCards = playersReceivedCards;
	}

	public String getBetLimit() {
		return this.betLimit;
	}

	public void setBetLimit(String betLimit) {
		this.betLimit = betLimit;
	}

	public String getBoardCards() {
		return this.boardCards;
	}

	public void setBoardCards(String boardCards) {
		this.boardCards = boardCards;
	}

	public String getTableId() {
		return this.tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getStakesLow() {
		return this.stakesLow;
	}

	public void setStakesLow(String stakesLow) {
		this.stakesLow = stakesLow;
	}

	public String getStakesHigh() {
		return this.stakesHigh;
	}

	public void setStakesHigh(String stakesHigh) {
		this.stakesHigh = stakesHigh;
	}

	public String getBlindsLow() {
		return this.blindsLow;
	}

	public void setBlindsLow(String blindsLow) {
		this.blindsLow = blindsLow;
	}

	public String getBlindsHigh() {
		return this.blindsHigh;
	}

	public void setBlindsHigh(String blindsHigh) {
		this.blindsHigh = blindsHigh;
	}

	public String getAntes() {
		return this.antes;
	}

	public void setAntes(String antes) {
		this.antes = antes;
	}

	public String getIsBlaze() {
		return this.isBlaze;
	}

	public void setIsBlaze(String isBlaze) {
		this.isBlaze = isBlaze;
	}

	public String getIsAnonymous() {
		return this.isAnonymous;
	}

	public void setIsAnonymous(String isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	public String getGameAction() {
		return this.gameAction;
	}

	public void setGameAction(String gameAction) {
		this.gameAction = gameAction;
	}

	public String getHandType() {
		return handType;
	}

	public void setHandType(String handType) {
		this.handType = handType;
	}

}