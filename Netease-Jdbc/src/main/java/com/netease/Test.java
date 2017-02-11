package com.netease;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void init() throws ServletException {
		ServletConfig config = this.getServletConfig();
		//通过config对象得到当前servlet配置的参数
		String v1 = config.getInitParameter("data1");
		String v2 = config.getInitParameter("data2");
		//通过ServeletContext对象得到当前整个web应用配置的参数
		String globalv1 = this.getServletContext().getInitParameter("globalData1");
		String globalv2 = this.getServletContext().getInitParameter("globalData2");
		System.out.println(v1+globalv1);
		System.out.print(v2+globalv2);
		// 使用ServeletContext.getResource方法 对象得到log4j文件配置信息
		 try {
			URL url = this.getServletContext().getResource("/WEB-INF/classes/log4j.properties");
			InputStream in = url.openStream();
			String propertyValue = GeneralUtil.getProperty("log4j.rootLogger", in);
			System.out.println("p1 value:" +propertyValue);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//使用ServeletContext.getResourceAsStream 方法
		 InputStream in2 = this.getServletContext().getResourceAsStream("/WEB-INF/classes/log4j.properties");
		 String p2 = GeneralUtil.getProperty("log4j.rootLogger", in2);
		 System.out.println("p2:"+p2);
		 System.out.println("=================================");
		 //getServletContext().getRealPath()输入相对路径得到绝对路径
   		 String path = this.getServletContext().getRealPath("/WEB-INF/classes/log4j.properties");
   		 System.out.println("real path " +path);
   		 System.out.println("=================================");
   		 //用绝对路径得到这个file 对象,再读出里面的内容
   		 File f = new File(path);
   		 try {
			InputStream in3 = new FileInputStream(f);
			String p3 = GeneralUtil.getProperty("log4j.rootLogger", in3);
			 System.out.println(p3);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		       PrintWriter out = response.getWriter();
		       String user = request.getParameter("user");
		       String passwd = request.getParameter("password");
		       Cookie username = new Cookie("username",user);
		       response.addCookie(username);
		       request.getSession().setAttribute("passwd",passwd);
		       request.getSession().setAttribute("user",user);
		       if(request.getSession().getAttribute("passwd")!=null){
		         request.getSession().invalidate();;
		       }
		       Cookie[] ck = request.getCookies();
		       if(ck!=null){
		       for( Cookie CK: ck ){
		       if (CK.getName().equals("username")){
		    	
		        }else{
		        out.print(user);
		      }
		   }
		   }
		       
		}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
