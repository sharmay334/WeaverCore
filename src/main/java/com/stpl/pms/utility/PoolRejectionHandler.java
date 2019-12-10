package com.stpl.pms.utility;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class PoolRejectionHandler implements RejectedExecutionHandler{
	
	 public void rejectedExecution(Runnable thread,ThreadPoolExecutor executor) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.execute(thread);
    }
}