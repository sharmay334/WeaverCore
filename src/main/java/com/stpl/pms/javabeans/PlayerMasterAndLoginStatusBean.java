package com.stpl.pms.javabeans;

import com.stpl.pms.hibernate.mapping.StPmPlayerMaster;
import com.stpl.pms.hibernate.mapping.StPmPlrLoginStatus;

public class PlayerMasterAndLoginStatusBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private StPmPlayerMaster playerMaster;
	private StPmPlrLoginStatus playerLoginStatus;
	
	public StPmPlayerMaster getPlayerMaster() {
		return playerMaster;
	}
	public void setPlayerMaster(StPmPlayerMaster playerMaster) {
		this.playerMaster = playerMaster;
	}
	public StPmPlrLoginStatus getPlayerLoginStatus() {
		return playerLoginStatus;
	}
	public void setPlayerLoginStatus(StPmPlrLoginStatus playerLoginStatus) {
		this.playerLoginStatus = playerLoginStatus;
	}
	
}
