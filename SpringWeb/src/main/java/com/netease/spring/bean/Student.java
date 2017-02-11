package com.netease.spring.bean;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Student")
public class Student implements User {
    private int age;
    private String gender;
    @Value("${grade}")
    private String grade;
    @Value("${classNumber}")
    private String classNumber;
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}

	@Override
	public void introduction() {
		System.out.println("a student");
		
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return "Age:"+age+"Gender:"+gender+"ClassNumber:"+classNumber;
	}

	public Student(Map<String,String>paras) {
		super();
		this.age = Integer.valueOf(paras.get("age"));
		this.gender = paras.get("gender");
	}
	@PostConstruct
	public void init(){
		System.out.println("init student method");
	}
	@PreDestroy
	public void destory(){
		System.out.println("destory student mthod");
	}

}
