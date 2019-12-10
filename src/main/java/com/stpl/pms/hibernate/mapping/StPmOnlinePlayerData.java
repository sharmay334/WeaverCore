package com.stpl.pms.hibernate.mapping;

import java.sql.Timestamp;

public class StPmOnlinePlayerData implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private short aliasId;
	private Integer globalTotalPlayers;
	private Integer globalFilledSeats;
	private Integer globalRealTable;
	private Integer globalFreeTable;
	private Integer globalOnlinePlayer;
	private Integer globalOnlineRealTotal;
	private Integer globalOnlineFreeTotal;
	private Integer globalFilledRealSeatTable;
	private Integer globalFilledFreeSeatTable;
	private Integer opOnlineReal;
	private Integer opOnlineFree;
	private Integer opFilledRealSeat;
	private Integer opFilledFreeSeat;
	private Timestamp updationTime;
	
	public StPmOnlinePlayerData(){
		
	}
	
	public StPmOnlinePlayerData(short aliasId, Integer globalTotalPlayers,
			Integer globalFilledSeats, Integer globalRealTable,
			Integer globalFreeTable, Integer globalOnlinePlayer,
			Integer globalOnlineRealTotal, Integer globalOnlineFreeTotal,
			Integer globalFilledRealSeatTable,
			Integer globalFilledFreeSeatTable, Integer opOnlineReal,
			Integer opOnlineFree, Integer opFilledRealSeat,
			Integer opFilledFreeSeat ,Timestamp updationTime) {
		
			this.aliasId = aliasId;
			this.globalTotalPlayers = globalTotalPlayers;
			this.globalFilledSeats = globalFilledSeats;
			this.globalRealTable = globalRealTable;
			this.globalFreeTable = globalFreeTable;
			this.globalOnlinePlayer = globalOnlinePlayer;
			this.globalOnlineRealTotal = globalOnlineRealTotal;
			this.globalOnlineFreeTotal = globalOnlineFreeTotal;
			this.globalFilledRealSeatTable = globalFilledRealSeatTable;
			this.globalFilledFreeSeatTable = globalFilledFreeSeatTable;
			this.opOnlineReal = opOnlineReal;
			this.opOnlineFree = opOnlineFree;
			this.opFilledFreeSeat = opFilledFreeSeat;
			this.opFilledRealSeat = opFilledRealSeat;
			this.updationTime = updationTime;
			
		
		// TODO Auto-generated constructor stub
	}
	public short getAliasId() {
		return aliasId;
	}
	public void setAliasId(short aliasId) {
		this.aliasId = aliasId;
	}
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
	public Integer getOpOnlineReal() {
		return opOnlineReal;
	}
	public void setOpOnlineReal(Integer opOnlineReal) {
		this.opOnlineReal = opOnlineReal;
	}
	public Integer getOpOnlineFree() {
		return opOnlineFree;
	}
	public void setOpOnlineFree(Integer opOnlineFree) {
		this.opOnlineFree = opOnlineFree;
	}
	public Integer getOpFilledRealSeat() {
		return opFilledRealSeat;
	}
	public void setOpFilledRealSeat(Integer opFilledRealSeat) {
		this.opFilledRealSeat = opFilledRealSeat;
	}
	public Integer getOpFilledFreeSeat() {
		return opFilledFreeSeat;
	}
	public void setOpFilledFreeSeat(Integer opFilledFreeSeat) {
		this.opFilledFreeSeat = opFilledFreeSeat;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Timestamp getUpdationTime() {
		return updationTime;
	}
	public void setUpdationTime(Timestamp updationTime) {
		this.updationTime = updationTime;
	}
	

}
