package com.netease.spring.mybatis;

public class Account {
private long id ;
private double balance;

public Account(){
	
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


public Account(long id, double balance) {
	super();
	this.id = id;
	this.balance = balance;
}

@Override
public String toString() {
	return "Account [id=" + id + ", balance=" + balance + "]";
}


}
