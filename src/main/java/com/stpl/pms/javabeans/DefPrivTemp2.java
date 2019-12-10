package com.stpl.pms.javabeans;

import java.io.Serializable;
import java.util.ArrayList;

public class DefPrivTemp2 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<PriviledgeBean> actionSeR;
	
	public DefPrivTemp2() {
		
	}

	public ArrayList<PriviledgeBean> getActionSeR() {
		return actionSeR;
	}

	public void setActionSeR(ArrayList<PriviledgeBean> actionSeR) {
		this.actionSeR = actionSeR;
	}
}
