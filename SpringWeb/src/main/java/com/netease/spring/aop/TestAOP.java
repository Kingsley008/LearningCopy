package com.netease.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext ("Aop.xml");
//		Caculator caculator =  context.getBean("caculator",Caculator.class);
//		System.out.println(caculator.add(1, 1));
//		System.out.println(caculator.sub(5, 2));
//		((ConfigurableApplicationContext)context).close();
		UserManagerImp user  = context.getBean("usermanagerimp",UserManagerImp.class);
		boolean b1 =user.addUser("XiaoMing", "12345");
		System.out.println("----------------");
		boolean b2 =user.delUser(1);
		((ConfigurableApplicationContext)context).close();
	}

}
