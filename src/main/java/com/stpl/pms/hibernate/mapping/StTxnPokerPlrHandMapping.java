package com.stpl.pms.hibernate.mapping;



/**
 * StTxnPokerPlrHandMapping entity. @author MyEclipse Persistence Tools
 */

public class StTxnPokerPlrHandMapping implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Long playerHandId;
	private StTxnPokerJeevesHandMaster handMaster;
	private Long playerSeat;
	private String playerAlias;
	private String loginName;
	private Double openBalance;
	private Double closeBalance;
	private String loyaltyTierId;
	private Double rakeAmount;
	private Double betAmount;
	private Double wonAmount;
	private Long exchangeBatchId;
	private String casinoId;
	private String operatorId;
	private String holeCard;
	private String bestHand;
	private String includedLowWonAmount;
	private Long tournamentPosition;
	private String isWinner;

	// Constructors

	/** default constructor */
	public StTxnPokerPlrHandMapping() {
	}

	/** minimal constructor */
	public StTxnPokerPlrHandMapping(StTxnPokerJeevesHandMaster handId, Long playerSeat,
			String playerAlias, String loginName, Double openBalance,
			Double closeBalance, Double rakeAmount, Double betAmount) {
		this.setHandMaster(handId);
		this.playerSeat = playerSeat;
		this.playerAlias = playerAlias;
		this.loginName = loginName;
		this.openBalance = openBalance;
		this.closeBalance = closeBalance;
		this.rakeAmount = rakeAmount;
		this.betAmount = betAmount;
	}

	/** full constructor */
	public StTxnPokerPlrHandMapping(StTxnPokerJeevesHandMaster handId, String playerSeat,
			String playerAlias, String loginName, String openBalance,
			String closeBalance, String loyaltyTierId, String rakeAmount,
			String betAmount,String wonAmount, String exchangeBatchId, String casinoId,
			String operatorId, String holeCard, String bestHand,
			String includedLowWonAmount, String tournamentPosition,
			String isWinner) {
		this.handMaster = handId;
		this.playerSeat = Long.parseLong(playerSeat==null?"0":playerSeat);
		this.playerAlias = playerAlias;
		this.loginName = loginName;
		this.openBalance = Double.valueOf(openBalance==null?"0.0":openBalance)/100;
		this.closeBalance = Double.valueOf(closeBalance==null?"0.0":closeBalance)/100;
		this.loyaltyTierId = loyaltyTierId;
		this.rakeAmount = Double.valueOf(rakeAmount==null?"0.0":rakeAmount)/100;
		this.betAmount = Double.valueOf(betAmount==null?"0.0":betAmount)/100;
		this.wonAmount = Double.valueOf(wonAmount==null?"0.0":wonAmount)/100;
		this.exchangeBatchId = Long.valueOf(exchangeBatchId==null?"0":exchangeBatchId);
		this.casinoId = casinoId;
		this.operatorId = operatorId;
		this.holeCard = holeCard;
		this.bestHand = bestHand;
		this.includedLowWonAmount = includedLowWonAmount;
		this.tournamentPosition = Long.parseLong(tournamentPosition);
		this.isWinner = isWinner==null?"False":isWinner;
	}

	// Property accessors





	public Long getPlayerHandId() {
		return this.playerHandId;
	}

	public void setPlayerHandId(Long playerHandId) {
		this.playerHandId = playerHandId;
	}


	public Long getPlayerSeat() {
		return this.playerSeat;
	}

	public void setPlayerSeat(Long playerSeat) {
		this.playerSeat = playerSeat;
	}

	public String getPlayerAlias() {
		return this.playerAlias;
	}

	public void setPlayerAlias(String playerAlias) {
		this.playerAlias = playerAlias;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Double getOpenBalance() {
		return this.openBalance;
	}

	public void setOpenBalance(Double openBalance) {
		this.openBalance = openBalance;
	}

	public Double getCloseBalance() {
		return this.closeBalance;
	}

	public void setCloseBalance(Double closeBalance) {
		this.closeBalance = closeBalance;
	}

	public String getLoyaltyTierId() {
		return this.loyaltyTierId;
	}

	public void setLoyaltyTierId(String loyaltyTierId) {
		this.loyaltyTierId = loyaltyTierId;
	}

	public Double getRakeAmount() {
		return this.rakeAmount;
	}

	public void setRakeAmount(Double rakeAmount) {
		this.rakeAmount = rakeAmount;
	}

	public Double getBetAmount() {
		return this.betAmount;
	}

	public void setBetAmount(Double betAmount) {
		this.betAmount = betAmount;
	}

	public Long getExchangeBatchId() {
		return this.exchangeBatchId;
	}

	public void setExchangeBatchId(Long exchangeBatchId) {
		this.exchangeBatchId = exchangeBatchId;
	}

	public String getCasinoId() {
		return this.casinoId;
	}

	public void setCasinoId(String casinoId) {
		this.casinoId = casinoId;
	}

	public String getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getHoleCard() {
		return this.holeCard;
	}

	public void setHoleCard(String holeCard) {
		this.holeCard = holeCard;
	}

	public String getBestHand() {
		return this.bestHand;
	}

	public void setBestHand(String bestHand) {
		this.bestHand = bestHand;
	}

	public String getIncludedLowWonAmount() {
		return this.includedLowWonAmount;
	}

	public void setIncludedLowWonAmount(String includedLowWonAmount) {
		this.includedLowWonAmount = includedLowWonAmount;
	}

	public Long getTournamentPosition() {
		return this.tournamentPosition;
	}

	public void setTournamentPosition(Long tournamentPosition) {
		this.tournamentPosition = tournamentPosition;
	}

	public String getIsWinner() {
		return this.isWinner;
	}

	public void setIsWinner(String isWinner) {
		this.isWinner = isWinner;
	}


	public StTxnPokerJeevesHandMaster getHandMaster() {
		return handMaster;
	}

	public void setHandMaster(StTxnPokerJeevesHandMaster handMaster) {
		this.handMaster = handMaster;
	}

	public Double getWonAmount() {
		return wonAmount;
	}

	public void setWonAmount(Double wonAmount) {
		this.wonAmount = wonAmount;
	}

}