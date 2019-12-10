package com.stpl.pms.javabeans;

import java.io.Serializable;

public class PokerTournamentFeedMasterBean implements Serializable {

	private static final long serialVersionUID = 7672383704908926059L;
	private Integer feeAmount;
	private String tournamentName;
	private String startTime;
	private Integer prizePool;
	private Integer buyInType;
	private Integer tournamentId;
	
	
	 public PokerTournamentFeedMasterBean() {
	
	}
	public PokerTournamentFeedMasterBean(Integer feeAmount,
			String tournamentName, String startTime,
			Integer prizePool, Integer buyInType,Integer tournamentId) {
		super();
		this.feeAmount = feeAmount;
		this.tournamentName = tournamentName;
		this.startTime = startTime;
		this.prizePool = prizePool;
		this.buyInType = buyInType;
	    this.tournamentId = tournamentId;
	}

	/**
	 * @return the feeAmount
	 */
	public Integer getFeeAmount() {
		return feeAmount;
	}
	/**
	 * @param feeAmount the feeAmount to set
	 */
	public void setFeeAmount(Integer feeAmount) {
		this.feeAmount = feeAmount;
	}
	/**
	 * @return the tournamentName
	 */
	public String getTournamentName() {
		return tournamentName;
	}
	/**
	 * @param tournamentName the tournamentName to set
	 */
	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}
	/**
	 * @return the startDateTimeIso
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startDateTimeIso the startDateTimeIso to set
	 */
	public void setStartDateTimelocal(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the prizePool
	 */
	public Integer getPrizePool() {
		return prizePool;
	}
	/**
	 * @param prizePool the prizePool to set
	 */
	public void setPrizePool(Integer prizePool) {
		this.prizePool = prizePool;
	}
	
	/**
	 * @return the buyInType
	 */
	public Integer getBuyInType() {
		return buyInType;
	}
	/**
	 * @param buyInType the buyInType to set
	 */
	public void setBuyInType(Integer buyInType) {
		this.buyInType = buyInType;
	}
	public Integer getTournamentId() {
		return tournamentId;
	}
	public void setTournamentId(Integer tournamentId) {
		this.tournamentId = tournamentId;
	}
}
