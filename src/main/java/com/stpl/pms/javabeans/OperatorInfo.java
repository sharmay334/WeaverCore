package com.stpl.pms.javabeans;

import java.io.Serializable;

public class OperatorInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer opOnlineReal;
	private Integer opOnlineFree;
	private Integer opFilledRealSeat;
	private Integer opFilledFreeSeat;
	
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
	
}
