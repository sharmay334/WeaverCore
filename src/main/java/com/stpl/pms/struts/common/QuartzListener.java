package com.stpl.pms.struts.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzListener implements ServletContextListener {
	public void contextDestroyed(ServletContextEvent arg0) {
		//
	}

	public void contextInitialized(ServletContextEvent arg0) {

		JobDetail job = JobBuilder.newJob(QuartzScheduling.class).withIdentity("anyJobName", "group1").build();
		
		JobDetail job1 = JobBuilder.newJob(QuartzSchedulingOverDueBill.class).withIdentity("anyJobName1", "group1")
				.build();
		JobDetail job2 = JobBuilder.newJob(QuartzSchedulingItemExpiry.class).withIdentity("anyJobName2", "group1")
				.build();
		JobDetail job3 = JobBuilder.newJob(QuartzSchedulingVisitRem.class).withIdentity("anyJobName3", "group1")
				.build();
		
		JobDetail job4 = JobBuilder.newJob(QuartzSchedulingSuperCashPartyBlock.class).withIdentity("anyJobName4", "group1")
				.build();
		
		JobDetail job5 = JobBuilder.newJob(ClosingBalanceSchedule.class).withIdentity("anyJobName5", "group1")
				.build();
		
		
		try {

			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("anyTriggerName", "group1")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 0 22 1/1 * ? *")).build(); //

			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);

			Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("anyTriggerName1", "group1")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 30 10 1/1 * ? *")) // 
					.build();

			Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
			scheduler1.start();
			scheduler1.scheduleJob(job1, trigger1);

			Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("anyTriggerName2", "group1")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 0 10 1/1 * ? *")) //
					.build();

			Scheduler scheduler2 = new StdSchedulerFactory().getScheduler();
			scheduler2.start();
			scheduler2.scheduleJob(job2, trigger2);

			Trigger trigger3 = TriggerBuilder.newTrigger().withIdentity("anyTriggerName3", "group1")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 0 19 1/1 * ? *")) //
					.build();

			Scheduler scheduler3 = new StdSchedulerFactory().getScheduler();
			scheduler3.start();
			scheduler3.scheduleJob(job3, trigger3);
			
			Trigger trigger4 = TriggerBuilder.newTrigger().withIdentity("anyTriggerName4", "group1")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 0 1 1/1 * ? *")) //
					.build();

			Scheduler scheduler4 = new StdSchedulerFactory().getScheduler();
			scheduler4.start();
			scheduler4.scheduleJob(job4, trigger4);

			
			Trigger trigger5 = TriggerBuilder.newTrigger().withIdentity("anyTriggerName5", "group1")
					.withSchedule(CronScheduleBuilder.cronSchedule("0 0 1 1/1 * ? *")) //
					.build();

			Scheduler scheduler5 = new StdSchedulerFactory().getScheduler();
			scheduler5.start();
			scheduler5.scheduleJob(job5, trigger5);

			
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}
}
