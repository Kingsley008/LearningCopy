package com.netease.work.web.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netease.work.dao.Userdao;
import com.netease.work.meta.User;
import com.netease.work.servicei.mpl.BlogService;
import com.netease.work.servicei.mpl.CheckLogin;

@Controller
public class HelloController {

	@RequestMapping(value = "/users/check", produces="application/json")
	public String check(ModelMap map) throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context-dao.xml");	
		Userdao dao = context.getBean("userdao",Userdao.class);
	    List<User> userlist =dao.getUserList();
		map.addAttribute("userlist",userlist);
	    ((ConfigurableApplicationContext)context).close();
		  return "userlist";     
	}
	
	
	@RequestMapping(value = "/bolg/check")
	public void checkBlog(@RequestParam("title")String title,@RequestParam("content")String content,Writer writer,HttpServletResponse response) throws IOException{
	   
	   ApplicationContext context =new ClassPathXmlApplicationContext("application-context-service.xml");
	   BlogService service = context.getBean("blogService",BlogService.class);
	   boolean b= service.checkBlog(title, content);
	   if(b){
	   
	   boolean i=service.addBlog(title, content);
	   
	   if(i){
	   writer.write(title+content);
	   response.setStatus(200);

	   }
	   }else{
	    response.setStatus(400);	   
	   }
	   ((ConfigurableApplicationContext)context).close();
		
	}
	@RequestMapping(value = "/userlg/check")
	public void checklg(@RequestParam("username")String username,@RequestParam("password")String password,HttpServletResponse response,HttpSession session,HttpServletRequest request) throws IOException, ServletException{
		//调用用户验证方法
		ApplicationContext context =new ClassPathXmlApplicationContext("application-context-service.xml");
		CheckLogin service = context.getBean("checkLogin",CheckLogin.class);
		boolean b = service.checkuser(username, password);
		if(b){
			//如果用户合法，存入session中
			session.setAttribute("username", username);
			 
			response.sendRedirect("check/welcome");
		}else{
			//不合法用户，转发到登入页面并带上错误信息
			request.setAttribute("error", "1");
			request.getRequestDispatcher("/wbd/login").forward(request, response);
		}
		
		  ((ConfigurableApplicationContext)context).close();		
	}
	
	@RequestMapping(value = "/userlg/check/welcome")
	public String sendWelcome(ModelMap map,HttpSession session) throws IOException{
		//从session 中拿到用户名 
		String username = (String) session.getAttribute("username");
		map.addAttribute("username",username);
		
		return"welcome";
	}
	
	@RequestMapping(value = "/login")
	public String sendLoginPage(ModelMap map,HttpSession session,HttpServletRequest request) throws IOException{
		//从request对象中得到具体的错误信息 
	    String error = (String) request.getAttribute("error");
	    if(error!=null){
	    if(error.equals("1")){
	    	String error1 ="用户名密码不正确，请重新登入";
	    	map.addAttribute("error1",error1);
	    }else if(error.equals("2")){
	    	String error2 ="您还没登入，请先登入";
	    	map.addAttribute("error2",error2);
	    }		
	    }
		return"llogin";
	}
	
	
	
}			

