package com.training.certification;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * FixedThreadPool  -- with n worker thread
 * 
 * cachedThreadPool - -long executions -no no
 * only for small codes you can go for cached Thread pool
 * 
 * doesnt create any blocking
 * 4 threads , 4 tasks are running
 * 5 task , it creates 5th thread
 * 1000 tasks  -- time consuming tasks --not advisable to use cachedThreadPool
 * 
 * reusability is possible
 * 
 * @author muska
 *
 */

public class SchedulerDemo {

	
	public static void main(String[] args) {
		
		
		ScheduledExecutorService service  = Executors.newSingleThreadScheduledExecutor();
		
		Runnable  t1 = ()->System.out.println("hi there");
		Runnable t2 = ()-> System.out.println(4*4);
		
		Callable <Integer> c1 = ()->6*7;
		Callable <String> c2 =  ()-> "callable tasks ";
	    ScheduledFuture<Integer> returnValue = service.schedule(c1, 4, TimeUnit.SECONDS);
      
	    
	    try {
			System.out.println("return value"+ returnValue.get(12, TimeUnit.SECONDS));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TimeoutException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ScheduledFuture<?> result = service.scheduleAtFixedRate(t1, 10, 5, TimeUnit.SECONDS);
		
		ScheduledFuture<?> res2 =  service.scheduleWithFixedDelay(t2, 3, 10, TimeUnit.SECONDS);
		try {
			System.out.println(result.get(1, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
