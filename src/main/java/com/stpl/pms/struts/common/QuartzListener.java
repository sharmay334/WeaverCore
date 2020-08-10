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

public class QuartzListener implements ServletContextListener{
	public void contextDestroyed(ServletContextEvent arg0) {
		//
	}

	public void contextInitialized(ServletContextEvent arg0) {

		JobDetail job = JobBuilder.newJob(QuartzScheduling.class)
			.withIdentity("anyJobName", "group1").build();

		try {

			Trigger trigger = TriggerBuilder
			  .newTrigger()
			  .withIdentity("anyTriggerName", "group1")
			  .withSchedule(
			     CronScheduleBuilder.cronSchedule("0 0 23 1/1 * ? *"))
			  .build();

			Scheduler scheduler = new StdSchedulerFactory().getScheduler();
			scheduler.start();
			scheduler.scheduleJob(job, trigger);

		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}
}
