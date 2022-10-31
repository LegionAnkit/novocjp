package com.training.certification;

import com.training.certification.exceptions.LessFundsException;

public class Account {
	
	private long id;
	private double balance;
	
	
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

	
	public synchronized double transfer(Account a, double amt) throws LessFundsException{
		 this.withdrawl(amt);
		 a.deposit(amt);
		 
		 return this.balance;
	}
}
