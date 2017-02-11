package com.netease.spring.bean;

public class Userbean {
private String Username;
private int Age;
private String Gender;
public void init(){
	System.out.println("开始设置输出用户信息");
}
public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
}
public int getAge() {
	return Age;
}
public void setAge(int age) {
	Age = age;
}
public String getGender() {
	return Gender;
}
public void setGender(String gender) {
	Gender = gender;
}
public void cleanup(){
	System.out.println("用户信息设置输出完毕");
}

}
