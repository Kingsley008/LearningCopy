package com.netease.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class School {
	@Autowired
 private Student stu;
// public School(Student stu){
//	 this.stu =stu;
// }


public Student getStu() {
	return stu;
}

public void setStu(Student stu) {
	this.stu = stu;
}
public void introduct(){
	 System.out.println("school has a student :"+stu.getInfo());
}


}
