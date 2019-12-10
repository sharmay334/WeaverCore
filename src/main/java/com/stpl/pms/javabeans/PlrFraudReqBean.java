package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import com.stpl.pms.commonJavabeans.PlayerBonusDetails;

public class PlrFraudReqBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long playerId;
	private String userName;
	private Timestamp registrationDate;
	private double totalDeposit;
	private double totalWithdrawal;
	private String addressVerified;
	private String ageVerified;
	private Timestamp lastPayOutOn;
	private double depstFrmLstPayOut;
	private double wagerFrmLstPayOut;
	private double winningFrmLstPayOut;
	private double bonusRedeemFrmLstPayOut;
	private double cashBal;
	private int payOutsInMnth;
	private int payoutRejectedBo;
	private int payoutRejectedPlr;
	private int pendingReqFrmLstPayOut;
	private double withdrawalAmt;
	private String withdrawalMode;
	private HashMap<String, List<List<String>>> playerGameMap;
	private HashMap<String, Integer> ipGameMap;
	private HashMap<String, List<List<String>>> refPlrGameMap;
	private Timestamp lastProccReqTime;
	private Timestamp currentReqTime;
	private Timestamp lastPayoutRequestOn;
	private List<PlayerBonusDetails> bonusDetails;
	private List<WithdrawalTxnBean> reasonDetail;
	
	public double getWithdrawalAmt() {
		return withdrawalAmt;
	}

	public void setWithdrawalAmt(double withdrawalAmt) {
		this.withdrawalAmt = withdrawalAmt;
	}

	public String getWithdrawalMode() {
		return withdrawalMode;
	}

	public void setWithdrawalMode(String withdrawalMode) {
		this.withdrawalMode = withdrawalMode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Timestamp getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	public double getTotalDeposit() {
		return totalDeposit;
	}

	public void setTotalDeposit(double totalDeposit) {
		this.totalDeposit = totalDeposit;
	}

	public double getTotalWithdrawal() {
		return totalWithdrawal;
	}

	public void setTotalWithdrawal(double totalWithdrawal) {
		this.totalWithdrawal = totalWithdrawal;
	}

	public String getAddressVerified() {
		return addressVerified;
	}

	public void setAddressVerified(String addressVerified) {
		this.addressVerified = addressVerified;
	}

	public String getAgeVerified() {
		return ageVerified;
	}

	public void setAgeVerified(String ageVerified) {
		this.ageVerified = ageVerified;
	}

	public Timestamp getLastPayOutOn() {
		return lastPayOutOn;
	}

	public void setLastPayOutOn(Timestamp lastPayOutOn) {
		this.lastPayOutOn = lastPayOutOn;
	}

	public double getDepstFrmLstPayOut() {
		return depstFrmLstPayOut;
	}

	public void setDepstFrmLstPayOut(double depstFrmLstPayOut) {
		this.depstFrmLstPayOut = depstFrmLstPayOut;
	}

	public double getWagerFrmLstPayOut() {
		return wagerFrmLstPayOut;
	}

	public void setWagerFrmLstPayOut(double wagerFrmLstPayOut) {
		this.wagerFrmLstPayOut = wagerFrmLstPayOut;
	}

	public double getWinningFrmLstPayOut() {
		return winningFrmLstPayOut;
	}

	public void setWinningFrmLstPayOut(double winningFrmLstPayOut) {
		this.winningFrmLstPayOut = winningFrmLstPayOut;
	}

	public double getBonusRedeemFrmLstPayOut() {
		return bonusRedeemFrmLstPayOut;
	}

	public void setBonusRedeemFrmLstPayOut(double bonusRedeemFrmLstPayOut) {
		this.bonusRedeemFrmLstPayOut = bonusRedeemFrmLstPayOut;
	}

	public double getCashBal() {
		return cashBal;
	}

	public void setCashBal(double cashBal) {
		this.cashBal = cashBal;
	}

	public int getPayOutsInMnth() {
		return payOutsInMnth;
	}

	public void setPayOutsInMnth(int payOutsInMnth) {
		this.payOutsInMnth = payOutsInMnth;
	}

	public int getPendingReqFrmLstPayOut() {
		return pendingReqFrmLstPayOut;
	}

	public void setPendingReqFrmLstPayOut(int pendingReqFrmLstPayOut) {
		this.pendingReqFrmLstPayOut = pendingReqFrmLstPayOut;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPayoutRejectedBo(int payoutRejectedBo) {
		this.payoutRejectedBo = payoutRejectedBo;
	}

	public int getPayoutRejectedBo() {
		return payoutRejectedBo;
	}

	public void setPayoutRejectedPlr(int payoutRejectedPlr) {
		this.payoutRejectedPlr = payoutRejectedPlr;
	}

	public int getPayoutRejectedPlr() {
		return payoutRejectedPlr;
	}


	public void setPlayerGameMap(HashMap<String, List<List<String>>> playerGameMap) {
		this.playerGameMap = playerGameMap;
	}

	public HashMap<String, List<List<String>>> getPlayerGameMap() {
		return playerGameMap;
	}

	public void setIpGameMap(HashMap<String, Integer> ipGameMap) {
		this.ipGameMap = ipGameMap;
	}

	public HashMap<String, Integer> getIpGameMap() {
		return ipGameMap;
	}

	public void setRefPlrGameMap(HashMap<String, List<List<String>>> refPlrGameMap) {
		this.refPlrGameMap = refPlrGameMap;
	}

	public HashMap<String, List<List<String>>> getRefPlrGameMap() {
		return refPlrGameMap;
	}

	public void setLastProccReqTime(Timestamp lastProccReqTime) {
		this.lastProccReqTime = lastProccReqTime;
	}

	public Timestamp getLastProccReqTime() {
		return lastProccReqTime;
	}

	public void setCurrentReqTime(Timestamp currentReqTime) {
		this.currentReqTime = currentReqTime;
	}

	public Timestamp getCurrentReqTime() {
		return currentReqTime;
	}

	public Timestamp getLastPayoutRequestOn() {
		return lastPayoutRequestOn;
	}

	public void setLastPayoutRequestOn(Timestamp lastPayoutRequestOn) {
		this.lastPayoutRequestOn = lastPayoutRequestOn;
	}

	public List<PlayerBonusDetails> getBonusDetails() {
		return bonusDetails;
	}

	public void setBonusDetails(List<PlayerBonusDetails> bonusDetails) {
		this.bonusDetails = bonusDetails;
	}

	public List<WithdrawalTxnBean> getReasonDetail() {
		return reasonDetail;
	}

	public void setReasonDetail(List<WithdrawalTxnBean> reasonDetail) {
		this.reasonDetail = reasonDetail;
	}

	



}
