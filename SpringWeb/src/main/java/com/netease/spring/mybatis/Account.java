package com.netease.spring.mybatis;

public class Account {
	private long Id;
	private double balance;
	public Account(){
		
	}
	
	public Account(long id, double balance) {
		super();
		Id = id;
		this.balance = balance;
	}

	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	

}
