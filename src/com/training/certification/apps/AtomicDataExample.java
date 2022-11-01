package com.training.certification.apps;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDataExample {
	public static void main(String[] args) {
		

		 AtomicInteger a = new AtomicInteger(100);
		
		System.out.println(a.incrementAndGet());
	
		System.out.println(a.addAndGet(1000));
	
		System.out.println(a.decrementAndGet());
		
		AtomicBoolean val = new AtomicBoolean(false);
		
		if(val.get()) {
			System.out.println("can proceed");
			
		}
		else
			System.out.println("cannot proceed");
		    val.getAndSet(true);
		    System.out.println("now its true");
		
	}

}
