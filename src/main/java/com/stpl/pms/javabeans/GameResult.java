package com.stpl.pms.javabeans;

public class GameResult implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private int won;
	private int lost;
	
	public int getLost() {
		return lost;
	}
	public void setLost(int lost) {
		this.lost = lost;
	}
	public int getWon() {
		return won;
	}
	public void setWon(int won) {
		this.won = won;
	}
	
	@Override
	public String toString() {
		return "GameResult [won=" + won + ", lost=" + lost + "]";
	}
}
