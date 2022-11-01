package com.training.certification.apps;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

	 private static int counter = 0;
	 public static Lock lock= new ReentrantLock();
	 
	 //how to lock without a lock using synchronized( staticobj)   , synchronized(this) in case of non static method 
	 
	 
	 public  static void incrementCounter() {
		 
		 //all 3 statements will be run by 1 thread at a time
		 //when you create a block what happens only those block lines will be exclusively available for the monitor lock ,only 1 thread at a time
		
		 try {
			lock.tryLock(2,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
		 int curentval =  counter;
		 counter = curentval+1;
		 lock.lock();
		 System.out.println("after incrementing "+counter);
		}
		finally {
	     lock.unlock();
	     lock.unlock();}
		
	 
	 }
	
	 public static void main(String[] args) {
		
		 for(int i=0;i<5;i++) {
			 
			 Thread t1 =new Thread(()->incrementCounter());
			 t1.start();
		 }
		 
	}
	
}
