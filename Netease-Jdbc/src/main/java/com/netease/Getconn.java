package com.netease;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.dbcp2.BasicDataSource;



public class Getconn {
	 static  final String Drivername ="com.mysql.jdbc.Driver";
	 static  final String url="jdbc:mysql://127.0.0.1:3306/dbtest?characterEncoding=utf8";
	 static  final String user ="root";
	 static  final String passwd ="wbd_12345";
	  
	
	 Connection conn=null;
	 Statement state=null;
	 PreparedStatement ps =null;
	 ResultSet re =null;
	 BasicDataSource ds =null;
	  public Connection getconn (){
		 
			try {
				Class.forName(Drivername);
				 conn = DriverManager.getConnection(url, user, passwd);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  return conn;
	  }
	  
	  
	public Connection getconnbyDBCP(){
		//通过dbcp连接池连接mysql
		ds = new BasicDataSource();
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(passwd);
		ds.setDriverClassName(Drivername);
		//设置初始化的连接数（根据业务量）
	    ds.setInitialSize(25);
		//设置最大连接数
	    ds.setMaxTotal(50);
	    //设置最长等待时间 2min
	    ds.setMaxWaitMillis(1000*60*2);
	    //设置最多的连接数量(为了避免反复创建，设置maxtotal相同)
	    ds.setMaxIdle(50);
	    //设置最少的连接数量
	    ds.setMinIdle(25);
	    //开启无效连接检查功能
	    ds.setTestWhileIdle(true);
	    //设置连接最小的失效时间 5h
	    ds.setMinEvictableIdleTimeMillis(1000*60*60*5);
	    //运行检查时间的间隔3h
	    ds.setTimeBetweenEvictionRunsMillis(1000*60*60*3);
		
		
		try {
			
			 conn =ds.getConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

	  public void close(){
			try {
				if(re!=null){
					re.close();

				}
				if(state!=null){
	         state.close();
				}
				if(ps!=null){
					ps.close();
				}
				if(conn!=null){
				conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}


}
