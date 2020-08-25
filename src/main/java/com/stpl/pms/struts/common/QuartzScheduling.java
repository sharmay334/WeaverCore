package com.stpl.pms.struts.common;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.stpl.pms.controller.gl.GameLobbyController;

public class QuartzScheduling implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("Struts 2.3.4 + Quartz 2.1.5 Tax Calculation");
		
		calculateTax();
		scheduleEmployeeAttendance();
		
	}
	
	private boolean calculateTax() {
		try {
			GameLobbyController controller = new GameLobbyController();
			controller.calculateTaxOnDebitBalanceOnly();
			controller.calculateTaxOnCreditBalanceOnly();
			//controller.calculateTaxOnAdvanceBalanceOnly();
			controller.calculateOverDueAmountInterest();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
	private boolean scheduleEmployeeAttendance() {
		try {
			GameLobbyController controller = new GameLobbyController();
				controller.scheduleEmployeeAttendance();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
		
	}

}
