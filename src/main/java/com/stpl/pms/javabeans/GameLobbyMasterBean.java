package com.stpl.pms.javabeans;

import java.util.ArrayList;
import java.util.List;

import com.stpl.pms.javabeans.GameLobbyResponseBean;

public class GameLobbyMasterBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	List<GameLobbyResponseBean> gameLobbyResponseBean;

	 public GameLobbyMasterBean()
	 {
		 gameLobbyResponseBean=new ArrayList<GameLobbyResponseBean>();
	 }
	public List<GameLobbyResponseBean> getGameLobbyResponseBean() {
		return gameLobbyResponseBean;
	}

	public void setGameLobbyResponseBean(
			List<GameLobbyResponseBean> gameLobbyResponseBean) {
		this.gameLobbyResponseBean = gameLobbyResponseBean;
	}

	   public void setGameMaster(GameLobbyResponseBean gameMaster){
		   gameLobbyResponseBean.add(gameMaster);
	    }
}
