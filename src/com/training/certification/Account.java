package com.training.certification;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.training.certification.exceptions.LessFundsException;

public class Account {
	
	private long id;
	private double balance;
	
	 Lock obj = new ReentrantLock();
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account(long id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + "]";
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public synchronized double withdrawl(double amt) throws LessFundsException{
		
		if(amt <balance)
		{
			this.balance-=amt;
			
		}
		else
			throw new LessFundsException("not enough funds");
			
		System.out.println("the balance is"+ this.balance);
	  return this.balance;
	}
	
	
	public  synchronized double deposit(double amt) {
		
		return this.balance+=amt;
	}

	
	public  double transfer(Account a, double amt) throws LessFundsException{
		synchronized (this) {
			
		
		this.withdrawl(amt);
		 a.deposit(amt);
		} 
		 return this.balance;
	}
	
	public static  int m1() {
		//assuming that there are 1000 loc
		
	//assuming there is more code 
		return 10;
	}
	
	public static synchronized  int m2() {
		
		
		return 10;
	}
	
}
