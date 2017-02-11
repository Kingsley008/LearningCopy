package com.netease;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Testlistener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener, HttpSessionActivationListener, HttpSessionBindingListener, ServletContextAttributeListener {
    private ServletContext application =null;
  
    public Testlistener() {
       
    }
    //应用上下文初始时会回调的方法 
    public void contextInitialized(ServletContextEvent e)  { 
        //初始化一个application对象
    	application = e.getServletContext(); 
    	//放入一个容器来保存用户信息
    	this.application.setAttribute("userlist", new ArrayList <String>());
    }
    //当session加入属性的时候回调的方法
    public void attributeAdded(HttpSessionBindingEvent e)  { 
    	//取得用户名列表 
    	ArrayList <String> userlist = (ArrayList)this.application.getAttribute("userlist");
    	//如果那个添加session的key为user 那么把他的value，也就是用户的名字加到容器里
    	if("user".equals(e.getName())){
    		userlist.add((String)e.getValue());
    	}
        //将添加后的容器重新放到application中
    	this.application.setAttribute("userlist", userlist);
    }
    //session 销毁时回调的方法
   public void sessionDestroyed(HttpSessionEvent e)  { 
	 //取得用户名列表
	 ArrayList<String> userlist =(ArrayList<String>) this.application.getAttribute("userlist");
	 //从session中取得当前用户名
        String user =  (String)e.getSession().getAttribute("user");
        //从列表中删除这个用户
        userlist.remove(user);
        //重新添加到application 
        this.application.setAttribute("userlist", userlist);
    }

    
 
 
 
 
    public void sessionCreated(HttpSessionEvent arg0)  { 
  
    }


    public void attributeRemoved(ServletContextAttributeEvent arg0)  { 
        
    }


    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
    	
    }

    public void sessionWillPassivate(HttpSessionEvent arg0)  { 
       
    }

    public void attributeAdded(ServletContextAttributeEvent arg0)  { 
        
    }

    public void valueBound(HttpSessionBindingEvent arg0)  { 
        
    }
	
    public void sessionDidActivate(HttpSessionEvent arg0)  { 
         
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
         
    }

	

	
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         
    }

	
    public void attributeReplaced(ServletContextAttributeEvent arg0)  { 
         
    }

	
    public void valueUnbound(HttpSessionBindingEvent arg0)  { 
        
    }
	
}
