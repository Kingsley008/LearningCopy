package com.netease.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("JdbcTransactionDao")
public class JdbcTransactionDao {
       private JdbcTemplate jdbcTemplate;
       
       @Autowired
       public void setDataSource (DataSource datasource){
    	   this.jdbcTemplate  = new JdbcTemplate(datasource); 
       }
       public void resetMoney(){
    	   jdbcTemplate.update("update account set balance=1000");
       }
       public List<Accountbean> accountList(){
    	   return this.jdbcTemplate.query("select * from account", new RowMapper<Accountbean>(){
    		public Accountbean mapRow(ResultSet rs, int rowNum) throws SQLException{
    			Accountbean ab = new Accountbean();
    			ab.setName(rs.getString("name"));
    			ab.setBalance(rs.getString("balance"));
    			return ab;
    		}
    	   });
       }
     //source转出的用户名  target 转入的用户名  count 金额
@Transactional(propagation= Propagation.REQUIRED)   
     public void transferMoney(String source, String target,int count){
    	 //转出
    	 this.jdbcTemplate.update("update account set balance=balance-? where name=? ",count,source);
    	 throwException();
    	 this.jdbcTemplate.update("update account set balance=balance+? where name=? ",count,target);
     }
     //异常
     private void throwException(){
    	 throw new RuntimeException("Error");
     }
     
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Transaction.xml");
		
		JdbcTransactionDao dao = context.getBean("JdbcTransactionDao",JdbcTransactionDao.class);
		dao.resetMoney();
		List <Accountbean>ls =dao.accountList();
		for(Accountbean ab : ls){
			System.out.println(ab.getName()+" "+ab.getBalance());
		}
		
		try {
			dao.transferMoney("Kingsley", "Tom", 200);
			
		} catch (Exception e) {
		   e.printStackTrace();
		}
		
		
		List <Accountbean>ls2 =dao.accountList();
		for(Accountbean ab : ls2){
			System.out.println(ab.getName()+" "+ab.getBalance());
		}
		
		
			}
	
	  

}
