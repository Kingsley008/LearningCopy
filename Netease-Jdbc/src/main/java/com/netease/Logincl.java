package com.netease;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class Logincl
 */

public class Logincl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logincl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//防止名字乱码
		request.setCharacterEncoding("utf-8"); 
		//将变量放入同步代码块里，防止线程错乱
		synchronized (this) {
			//用request得到用户名和密码后
			String user = request.getParameter("user");
			String password = request.getParameter("password");
			//进行一个简单的验证，真正的验证要连接数据库
			Getconn con = new Getconn();
			try {
				//通过DBCP进行数据库连接
				Connection conn = con.getconnbyDBCP();
				PreparedStatement ps = null;
				
			//	Statement state =conn.createStatement();
				//用用户的用户名查他的密码
				String sql1="select password from user  where username='"+user+"';";
				//使用preparestatement的游标
				ps =conn.prepareStatement(sql1);
				//设置游标，每次读取一条记录，结束后读取下一条记录
				//防止JVM 内存溢出
				ps.setFetchSize(1);
				//得到结果
				ResultSet re = ps.executeQuery();
			    if(re.next()){
			    String upass = re.getString(1);
			 
					if(password.equals(upass)){
						 //把用户名加到session中让filter 进行判断，同时让listener判断
					    request.getSession().setAttribute("user", user);
					    //加入日志内容，把登入的用户名，记录下来
					    Logger log = Logger.getLogger(Logincl.class);
					    log.info("用户："+user+" 登入了");
					    //重定向
						response.sendRedirect("Wel.jsp");	
					}else{
						response.sendRedirect("index.jsp?err=2");
					}
			    }
			   } catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
			  con.close();
			}
			
//			if(user.equals("user1")||user.equals("user2")||user.equals("user3")){
//				if(password.equals("123")||password.equals("345")||password.equals("12345")){
//					
//				    //把用户名加到session中让filter 进行判断，同时让listener判断
//				    request.getSession().setAttribute("user", user);
//				    //加入日志内容，把登入的用户名，记录下来
//				    Logger log = Logger.getLogger(Logincl.class);
//				    log.info("用户："+user+" 登入了");
//				    //重定向
//					response.sendRedirect("Wel.jsp");
//				}
//			}else{
//	
//				response.sendRedirect("index.jsp?err=2");
//			}
//			
//		}
		
		
		
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
