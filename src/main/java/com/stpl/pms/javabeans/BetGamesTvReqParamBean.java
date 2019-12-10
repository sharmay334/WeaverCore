package com.stpl.pms.javabeans;

import java.sql.Timestamp;


public class BetGamesTvReqParamBean implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private Double amount;
	private String currency;
	private String bet_id;
	private String transaction_id;
	private Integer retrying;
	private String bet;
	private String odd;
	private Timestamp bet_time;
	private String game;
	private String draw_code;
	private Timestamp draw_time;
	private String lottery_barcode;
	private Integer cancelled;
	
	private Long player_id;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getBet_id() {
		return bet_id;
	}

	public void setBet_id(String betId) {
		bet_id = betId;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transactionId) {
		transaction_id = transactionId;
	}

	public Integer getRetrying() {
		return retrying;
	}

	public void setRetrying(Integer retrying) {
		this.retrying = retrying;
	}

	public String getBet() {
		return bet;
	}

	public void setBet(String bet) {
		this.bet = bet;
	}

	public String getOdd() {
		return odd;
	}

	public void setOdd(String odd) {
		this.odd = odd;
	}

	public Timestamp getBet_time() {
		return bet_time;
	}

	public void setBet_time(Timestamp betTime) {
		bet_time =  betTime;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getDraw_code() {
		return draw_code;
	}

	public void setDraw_code(String drawCode) {
		draw_code = drawCode;
	}

	public Timestamp getDraw_time() {
		return draw_time;
	}

	public void setDraw_time(Timestamp drawTime) {
		draw_time = drawTime;
	}

	public void setLottery_barcode(String lottery_barcode) {
		this.lottery_barcode = lottery_barcode;
	}

	public String getLottery_barcode() {
		return lottery_barcode;
	}

	public void setCancelled(Integer cancelled) {
		this.cancelled = cancelled;
	}

	public Integer getCancelled() {
		return cancelled;
	}

	public void setPlayer_id(Long player_id) {
		this.player_id = player_id;
	}

	public Long getPlayer_id() {
		return player_id;
	}

}
