package com.netease.spring.homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		 ApplicationContext context = new ClassPathXmlApplicationContext("Myapp.xml");	
		 FileWriterService fws = context.getBean("FileWriterService",FileWriterService.class);
		 fws.write("向文件写入信息的方法");
		 ((ConfigurableApplicationContext)context).close();

	}

}
