package com.netease.trymybatis;

public class Product {
private int id;
private String productName;
private String catalog;

public Product(){
	
}
public Product(Integer id, String productName, String catalog) {
	super();
	this.id = id;
	this.productName = productName;
	this.catalog = catalog;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getCatalog() {
	return catalog;
}
public void setCatalog(String catalog) {
	this.catalog = catalog;
}

	
}
