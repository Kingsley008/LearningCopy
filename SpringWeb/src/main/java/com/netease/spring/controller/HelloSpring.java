package com.netease.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netease.spring.bean.School;
import com.netease.spring.bean.Student;
import com.netease.spring.bean.Userbean;

@Controller
public class HelloSpring extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloSpring() {
        super();
    }

    @RequestMapping(value = "/spring")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
     String user=request.getParameter("user");
     String pw =request.getParameter("password");
     response.getWriter().write("hello spring!!!"+user+pw);
     //加载配置文件xml
     ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
     //从配置文件中得到需要的bean
     Userbean users = context.getBean("Userbean",Userbean.class);
 
     //设置bean的信息
     users.setUsername(user);
     users.setAge(20);
     users.setGender("male");
     //输出到网页
     response.getWriter().write("<br>");
     response.getWriter().write("name:"+users.getUsername()+";age:"+users.getAge()+";gender:"+users.getGender());
     //销毁
     ((ConfigurableApplicationContext)context).close();
     //依赖注入 测试
     ApplicationContext context2 = new ClassPathXmlApplicationContext("application-context.xml");
     //@compoent（内容） 要和 这里对应
     Student stu  = context2.getBean("Student",Student.class);
     stu.introduction();
     System.out.println(stu.getInfo());
	 //依赖类测设
     ApplicationContext context3 = new ClassPathXmlApplicationContext("application-context.xml");
     School school = context3.getBean("School",School.class);
     school.introduct();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
