package com.stpl.pms.struts.common;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.stpl.pms.controller.gl.GameLobbyController;

// this class blocks party if they don't pay bills under 7 days
public class QuartzSchedulingSuperCashPartyBlock implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		GameLobbyController controller = new GameLobbyController();
		controller.blockSuperCashParty();
	}

}
