package com.stpl.pms.javabeans;

import java.util.ArrayList;
import java.util.List;

public class ReferralPlayerData implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private List<GamePlayedWithPlayer> gamePlayedWithPlayer;

	public List<GamePlayedWithPlayer> getGamePlayedWithPlayer() {
		return gamePlayedWithPlayer;
	}

	public void setGamePlayedWithPlayer(List<GamePlayedWithPlayer> gamePlayedWithPlayer) {
		this.gamePlayedWithPlayer = gamePlayedWithPlayer;
	}
	
	public void setGamePlayedWithPlayer(GamePlayedWithPlayer bean) {
		if(this.gamePlayedWithPlayer == null){
			this.gamePlayedWithPlayer = new ArrayList<GamePlayedWithPlayer>();
		}
		this.gamePlayedWithPlayer.add(bean);
	}

	@Override
	public String toString() {
		return "ReferralPlayerData [gamePlayedWithPlayer="
				+ gamePlayedWithPlayer + "]";
	}

	
}
