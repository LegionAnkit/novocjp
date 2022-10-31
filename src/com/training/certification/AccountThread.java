package com.training.certification;

import com.training.certification.exceptions.LessFundsException;

public class AccountThread extends Thread {
	
	private Account account;
	

	public AccountThread(Account account) {
		super();
		this.account = account;
	}


	public void run() {
		
		for (int i=0;i<3;i++) {
			
			try {
				this.account.withdrawl(10000);
				
				Thread.sleep(1000);
			} catch (LessFundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
