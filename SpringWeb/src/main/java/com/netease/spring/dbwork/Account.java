package com.netease.spring.dbwork;

public class Account {
private long id;
private double balance;

public Account(){
	
}

public Account(long id, double balance ) {
	super();
	this.id = id;
	this.balance = balance;
}

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

}
