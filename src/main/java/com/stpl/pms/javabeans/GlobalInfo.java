package com.stpl.pms.javabeans;

import java.io.Serializable;

public class GlobalInfo  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer globalTotalPlayers;
	private Integer globalFilledSeats;
	private Integer globalRealTable;
	private Integer globalFreeTable;
	private Integer globalOnlinePlayer;
	private Integer globalOnlineRealTotal;
	private Integer globalOnlineFreeTotal;
	private Integer globalFilledRealSeatTable;
	private Integer globalFilledFreeSeatTable;
	
	
	public Integer getGlobalTotalPlayers() {
		return globalTotalPlayers;
	}
	public void setGlobalTotalPlayers(Integer globalTotalPlayers) {
		this.globalTotalPlayers = globalTotalPlayers;
	}
	public Integer getGlobalFilledSeats() {
		return globalFilledSeats;
	}
	public void setGlobalFilledSeats(Integer globalFilledSeats) {
		this.globalFilledSeats = globalFilledSeats;
	}
	public Integer getGlobalRealTable() {
		return globalRealTable;
	}
	public void setGlobalRealTable(Integer globalRealTable) {
		this.globalRealTable = globalRealTable;
	}
	public Integer getGlobalFreeTable() {
		return globalFreeTable;
	}
	public void setGlobalFreeTable(Integer globalFreeTable) {
		this.globalFreeTable = globalFreeTable;
	}
	public Integer getGlobalOnlinePlayer() {
		return globalOnlinePlayer;
	}
	public void setGlobalOnlinePlayer(Integer globalOnlinePlayer) {
		this.globalOnlinePlayer = globalOnlinePlayer;
	}
	public Integer getGlobalOnlineRealTotal() {
		return globalOnlineRealTotal;
	}
	public void setGlobalOnlineRealTotal(Integer globalOnlineRealTotal) {
		this.globalOnlineRealTotal = globalOnlineRealTotal;
	}
	public Integer getGlobalOnlineFreeTotal() {
		return globalOnlineFreeTotal;
	}
	public void setGlobalOnlineFreeTotal(Integer globalOnlineFreeTotal) {
		this.globalOnlineFreeTotal = globalOnlineFreeTotal;
	}
	public Integer getGlobalFilledRealSeatTable() {
		return globalFilledRealSeatTable;
	}
	public void setGlobalFilledRealSeatTable(Integer globalFilledRealSeatTable) {
		this.globalFilledRealSeatTable = globalFilledRealSeatTable;
	}
	public Integer getGlobalFilledFreeSeatTable() {
		return globalFilledFreeSeatTable;
	}
	public void setGlobalFilledFreeSeatTable(Integer globalFilledFreeSeatTable) {
		this.globalFilledFreeSeatTable = globalFilledFreeSeatTable;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
