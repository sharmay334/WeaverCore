package com.stpl.pms.utility;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolService {
	
	static BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<Runnable>();
	private static ThreadPoolExecutor executor = null;
	
//	private ExecutorService executor ;
//	private static ThreadPoolService threadpool;
	
//	private ThreadPoolService(){
//		executor=Executors.newFixedThreadPool(10);
//
//	}
	
	public static ThreadPoolExecutor getInstance(){
		 if(executor == null){
		        synchronized (ThreadPoolService.class) {
		            if(executor == null){
		            	executor = new ThreadPoolExecutor(10, 20, 5, TimeUnit.SECONDS, blockingQueue);
		            	executor.setRejectedExecutionHandler(new PoolRejectionHandler());
		            }
		        }
		    }
		    return executor;
	}
	
//	public  void execute(Runnable r){
//		executor.execute(r);
//	}
//
//	public ExecutorService getExecutor() {
//		return executor;
//	}


}
