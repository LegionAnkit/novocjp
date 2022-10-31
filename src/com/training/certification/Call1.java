package com.training.certification;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Call1  implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return -1;
	}

	public static void main(String[] args) {
		var es= Executors.newSingleThreadExecutor();
		var callable =  new Call1();
		try {
			System.out.println(es.submit(callable).get());
			es.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
