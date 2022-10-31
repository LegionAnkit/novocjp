package com.training.certification;

public class RacerThread  extends Thread{
	
	public void run() {
		
		
		for(int i=0;i<10;i++) {
			
			try {
				
				Thread.currentThread().setName("Main");
				System.out.println(Thread.currentThread().getName()+ i);
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	

}
