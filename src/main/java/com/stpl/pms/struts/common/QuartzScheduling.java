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
		
	}
	
	private boolean calculateTax() {
		try {
			GameLobbyController controller = new GameLobbyController();
			controller.calculateTaxOnDebitBalanceOnly();
			controller.calculateTaxOnCreditBalanceOnly();
			controller.calculateTaxOnAdvanceBalanceOnly();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
		
	}

}
