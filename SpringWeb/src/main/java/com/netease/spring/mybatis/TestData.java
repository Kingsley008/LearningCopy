package com.netease.spring.mybatis;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestData {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("mybatis-context.xml");	
		MybatisUserdao dao = context.getBean("mybatisUserdao",MybatisUserdao.class);
		List <Userbean> userList =dao.getUserList();
		for(Userbean user:userList){
			System.out.println(user.getFirst_name()+" "+user.getLast_name());
		}
		Userbean user =(Userbean) dao.getUser("john");
		System.out.println(user.getLast_name());
		
	   ((ConfigurableApplicationContext)context).close();


	}

}
