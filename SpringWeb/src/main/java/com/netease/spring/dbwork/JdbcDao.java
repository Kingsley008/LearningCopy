package com.netease.spring.dbwork;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class JdbcDao implements Dao {
	 private JdbcTemplate jdbcTemplate;
     
     @Autowired
     public void setDataSource (DataSource datasource){
  	   this.jdbcTemplate  = new JdbcTemplate(datasource); 
     }
     
@Transactional(propagation= Propagation.REQUIRED) 
	public void transferMoney(Long srcUserId, Long targetUserId, double count) {
		this.jdbcTemplate.update("update account2 set balance = balance -? where userId=? ",count,srcUserId);
       // throwException();
		this.jdbcTemplate.update("update account2 set balance = balance +? where userId=? ",count,targetUserId);
		
	}
	
	  //异常
  private void throwException(){
 	 throw new RuntimeException("Error");
  }

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Transaction.xml");
		Dao dao = (Dao)context.getBean("jdbcDao");
		try {
			long a =1;
			long b =2;
			dao.transferMoney(a, b, 100.0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		((ConfigurableApplicationContext)context).close();
		

	}



}
