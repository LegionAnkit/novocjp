package com.training.certification.apps;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.training.certification.Account;

public class TestAccount {
	
	
   public static void main(String[] args) {
	/*   Account amit = new Account(12121,56000);
		Account sumit = new Account(33434,4000);
		
		AccountThread t1=  new AccountThread(amit);
		
		t1.start();
		
		Runnable r1 = ()->{
			try {
				amit.withdrawl(10000);
			} catch (LessFundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	
		Runnable r2 = ()->{
			try {
				
				amit.transfer(sumit, 20000);
			} catch (LessFundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		new Thread(r1).start();
		
		new Thread(r2).start();
		
		System.out.println(amit.getBalance());
		System.out.println(sumit.getBalance());
		
		
}*/
   
	   try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   Account amit = new Account(12121,50000);
   
   //this thread pool of 3
   
   ExecutorService service =  Executors.newSingleThreadExecutor();
   
   for (int i=0;i<3;i++) {
	   
	 
	   service.submit(()->amit.withdrawl(10000));
	   

   }
   service.execute(()->{System.out.println("hello");});
   System.out.println(amit.toString());
   
   
   
    try {
	   
	   Callable <Integer> c1 = ()-> 2+2;
	   Future <?> futureObject =  service.submit(c1);
	   System.out.println("task done" +futureObject.isDone());
	   System.out.println("task cancelled"+futureObject.isCancelled());
	   
	   Callable <Integer> c3 = ()-> 2+20;
	   
	   Callable <Integer> c4 = ()-> 2+200;
	   
	   
	   Callable <String> c2 = ()-> "hello there";
	  
	System.out.println(futureObject.get(1, TimeUnit.SECONDS));
	System.out.println("task done" +futureObject.isDone());
	   System.out.println("task cancelled"+futureObject.isCancelled());
	  
	List <Future<Integer>> results = service.invokeAll(List.of(c1,c3,c4),2,TimeUnit.SECONDS);   
	
       for(Future<Integer> res :results) {
    	   System.out.println(res.get(1, TimeUnit.SECONDS));
       }

       service.submit(c2);
       
       
       service.shutdown();
       System.out.println("termination status" +service.isTerminated());
       System.out.println("shutdown status"+service.isShutdown());
       
       
	
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
