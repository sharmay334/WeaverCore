package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BonusGameEligibilityBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<String> gameType;
	
	public List<String> getGameType() {
		return gameType;
	}
	public void setGameType(List<String> gameType) {
		this.gameType = gameType;
	}
	
	public void setGameType(String gameType) {
		if(this.gameType ==null)
			this.gameType = new ArrayList<String>();
		this.gameType.add(gameType);
	}
	
	@Override
	public String toString() {
		return "BonusGameEligibilityBean [gameType=" + gameType
				+ ", getGameType()=" + getGameType() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
