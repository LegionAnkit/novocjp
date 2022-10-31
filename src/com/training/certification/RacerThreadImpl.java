package com.training.certification;

public class RacerThreadImpl implements Runnable {
	
	public void run() {
		
		

		for(int i=0;i<10;i++) {
			
			try {
				Thread.sleep(1000);
				
				
				System.out.println(Thread.currentThread().getName()+ i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("oops !! interrupted ");
			}
			
		}
		
	
	}

}
