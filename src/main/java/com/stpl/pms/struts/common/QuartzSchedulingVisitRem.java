package com.stpl.pms.struts.common;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.stpl.pms.controller.gl.GameLobbyController;

public class QuartzSchedulingVisitRem  implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println(":::::::::::::::::SCHEDULING OF VISIT REMINDER :::::");
		callSchedling();
	}

	private void callSchedling() {
		// TODO Auto-generated method stub
		GameLobbyController controller = new GameLobbyController();
		controller.scheduleEmployeeVisit();
	}

}
