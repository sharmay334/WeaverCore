package com.stpl.pms.javabeans;

import java.io.Serializable;

public class PlayerSubWalletBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private long playerId;
	private short domainId;
	private String gameGroup;
	private short vendorId;
	private String subwalletRefNo;
	private int currencyId;
	private double amount;
	private String status;

	public PlayerSubWalletBean() {
	}

	public PlayerSubWalletBean(long playerId, short domainId, String gameGroup,
			short vendorId, String subwalletRefNo, int currencyId,
			double amount, String status) {
		this.playerId = playerId;
		this.domainId = domainId;
		this.gameGroup = gameGroup;
		this.vendorId = vendorId;
		this.subwalletRefNo = subwalletRefNo;
		this.currencyId = currencyId;
		this.amount = amount;
		this.status = status;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public short getDomainId() {
		return domainId;
	}

	public void setDomainId(short domainId) {
		this.domainId = domainId;
	}

	public String getGameGroup() {
		return gameGroup;
	}

	public void setGameGroup(String gameGroup) {
		this.gameGroup = gameGroup;
	}

	public short getVendorId() {
		return vendorId;
	}

	public void setVendorId(short vendorId) {
		this.vendorId = vendorId;
	}

	public String getSubwalletRefNo() {
		return subwalletRefNo;
	}

	public void setSubwalletRefNo(String subwalletRefNo) {
		this.subwalletRefNo = subwalletRefNo;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
