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
		
		//when will c1 execute -- initial delay of 4 seconds
		//what is the return value of this schedule method ---  ScheduledFuture <T> 
		
		//schedule method takes callable and runnable
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
	    
	    //scheduleWithFixedDelay and scheduleAtFixedRate --- both takes only Runnable
	  //what is the return value of this scheduleWithFixedDelay  and scheduleAtFixedRate method ---  ScheduledFuture <T> 
		   
	    //when will t1 start -- initial delay  -- 10 seconds , every time it repeats 5 seconds gap
		ScheduledFuture<?> result = service.scheduleAtFixedRate(t1, 10, 5, TimeUnit.SECONDS);
		
		//what is the return value of this schedule method ---  ScheduledFuture <T> 
		   
		//when will t2 start --3 sec initial delay , how many seconds it will  delay after the completion of the task and then repeat execution 10- seconds 
		ScheduledFuture<?> res2 =  service.scheduleWithFixedDelay(t2, 3, 10, TimeUnit.SECONDS);
		try {
			System.out.println(result.get(20, TimeUnit.SECONDS));
			
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
