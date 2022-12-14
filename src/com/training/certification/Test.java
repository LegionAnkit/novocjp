package com.training.certification;

public class Test {
	public static void main(String[] args) {
		
		/**
		 * 
		 * 
		 * In this programs I have got 1 main thread and 5 other threads
		 * tasks executed  --synchronously or asynchronously
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		//how to start a Thread ?
		//first stage is creating a new thread with a new keyword
		RacerThread t1 = new RacerThread();
		//2nd is making it runnable , to make thread runnable we call start method
		//why not run method directly ?
		
		  t1.start();
      //os does not think of this Racer thread in  adifferent mem , it will call the run mehtod in the mem of the main method
		
		//t1.run();
		
	
		//how to start a Runnable ?
		RacerThreadImpl rt1 = new  RacerThreadImpl();
		Thread t2 =  new Thread(rt1,"racer thread impl");

		t2.start();
		
		
		
		//Functional programming 
		
		Runnable r1 = ()->{System.out.println("hello"); };
		
		Thread t3=new Thread(r1);
		t3.start();
		
		//we are providing impl of the public void run in the form of lambda 
		//we are providing Runnable implementation 
		
		Runnable r2 = ()->{
							for (int i=0;i<100;i+=10)
				{
					Thread.currentThread().setName("r2");
					System.out.println(Thread.currentThread().getName()+" "+i);	
				}
							};
		
		Runnable r3 = ()->{ };
		
		
		
		(new Thread(r2)).start();
		
		(new Thread(r1)).start();
		
		
		
		System.out.println("End of main");
		
		
		
		
		
		
		
	 
	}

}
