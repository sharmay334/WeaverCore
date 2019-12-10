package com.stpl.pms.javabeans;

import java.io.Serializable;

public class RummyPlaceHolderBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private PlaceHolderClientListBean lobbyHeader;
	private PlaceHolderClientListBean lobbyLoad;
	private PlaceHolderClientListBean gamePlay;
	
	public PlaceHolderClientListBean getLobbyHeader() {
		return lobbyHeader;
	}

	public void setLobbyHeader(PlaceHolderClientListBean lobbyHeader) {
		this.lobbyHeader = lobbyHeader;
	}

	public PlaceHolderClientListBean getLobbyLoad() {
		return lobbyLoad;
	}

	public void setLobbyLoad(PlaceHolderClientListBean lobbyLoad) {
		this.lobbyLoad = lobbyLoad;
	}

	public PlaceHolderClientListBean getGamePlay() {
		return gamePlay;
	}

	public void setGamePlay(PlaceHolderClientListBean gamePlay) {
		this.gamePlay = gamePlay;
	}

}
