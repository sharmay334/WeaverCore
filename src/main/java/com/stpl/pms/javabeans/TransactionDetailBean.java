package com.stpl.pms.javabeans;

import java.sql.Timestamp;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
@JsonSerialize(include = Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown= true)
public class TransactionDetailBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Double amount;
	private String walletType;
	private String balanceType;
	private String refTxnNo;
	private String currencyCode;
	private Long txnId;
	private Long refWagerTxnId;
	private Timestamp expiredDate;
	private Timestamp refUsageDate;
	private String particular;
	private Double wrContriAmount;
	private String gameType;
	private String gameName;
	private Long gameId;
	
	//for GoldenRace
	private Long unitId;
	private Long staffId;
	private String tmpId;
	private Double jackpot;
	private Double megaJackpot;
	private Long ext_id;
	private Double taxes;
	
/*	@JsonIgnore
	public BulkTxnStatusBean fetchBulkTxnStatusBean(){
		BulkTxnStatusBean bean=new BulkTxnStatusBean();
//		bean.setAmount(amount);
//		bean.setWalletType(walletType);
//		bean.setBalanceType(balanceType);
		bean.setRefTxnNo(refTxnNo);
		bean.setTxnId(txnId);
//		bean.setTxnType("WAGER");
//		bean.setParticular(particular);
//		bean.setWrContriAmount(wrContriAmount);
//		bean.setGameId(gameId);
//		bean.setGameName(gameName);
		return bean;
	}*/
	
	public String getSubWallCreation() {
		return subWallCreation;
	}

	public void setSubWallCreation(String subWallCreation) {
		this.subWallCreation = subWallCreation;
	}

	private String subWallCreation;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getWalletType() {
		return walletType;
	}

	public void setWalletType(String walletType) {
		this.walletType = walletType;
	}

	public String getBalanceType() {
		return balanceType;
	}

	public void setBalanceType(String balanceType) {
		this.balanceType = balanceType;
	}

	public String getRefTxnNo() {
		return refTxnNo;
	}

	public void setRefTxnNo(String refTxnNo) {
		this.refTxnNo = refTxnNo;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public void setTxnId(Long txnId) {
		this.txnId = txnId;
	}

	public Long getTxnId() {
		return txnId;
	}

	public void setRefWagerTxnId(Long refWagerTxnId) {
		this.refWagerTxnId = refWagerTxnId;
	}

	public Long getRefWagerTxnId() {
		return refWagerTxnId;
	}

	public void setExpiredDate(Timestamp expiredDate) {
		this.expiredDate = expiredDate;
	}

	public Timestamp getExpiredDate() {
		return expiredDate;
	}

	public void setRefUsageDate(Timestamp refUsageDate) {
		this.refUsageDate = refUsageDate;
	}

	public Timestamp getRefUsageDate() {
		return refUsageDate;
	}

	public String getParticular() {
		return particular;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}

	public Double getWrContriAmount() {
		return wrContriAmount;
	}

	public void setWrContriAmount(Double wrContriAmount) {
		this.wrContriAmount = wrContriAmount;
	}

	public String getGameType() {
		return gameType;
	}

	public String getGameName() {
		return gameName;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public String getTmpId() {
		return tmpId;
	}

	public void setTmpId(String tmpId) {
		this.tmpId = tmpId;
	}

	public Double getJackpot() {
		return jackpot;
	}

	public void setJackpot(Double jackpot) {
		this.jackpot = jackpot;
	}

	public Double getMegaJackpot() {
		return megaJackpot;
	}

	public void setMegaJackpot(Double megaJackpot) {
		this.megaJackpot = megaJackpot;
	}

	public Long getExt_id() {
		return ext_id;
	}

	public void setExt_id(Long ext_id) {
		this.ext_id = ext_id;
	}

	public Double getTaxes() {
		return taxes;
	}

	public void setTaxes(Double taxes) {
		this.taxes = taxes;
	}

}
