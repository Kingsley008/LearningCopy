package com.netease.spring.mybatis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("TransferMoneyByjdbc")
public class TransferMoneyByjdbc{
	private JdbcTemplate jdbctemplate;
	@Autowired
	public void setdataSource (DataSource datasource){
		this.jdbctemplate = new JdbcTemplate(datasource);
	}
	public void resetMoney(){
		this.jdbctemplate.update("update account2 set balance=1000");
	}
	public List<Account> accountList(){
		return this.jdbctemplate.query("select * from account2", new RowMapper<Account>(){
			public Account mapRow(ResultSet rs, int rowNum)throws SQLException{
				Account account = new Account();
				account.setId(rs.getLong("userId"));
				account.setBalance(rs.getDouble("balance"));
				return account;
			}
		});
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void transferMoney(Long srcUserId, Long targetUserId, double count) {
		this.jdbctemplate.update("update account2 set balance = balance -? where userId=? ",count,srcUserId);
//		//throwException();
		this.jdbctemplate.update("update account2 set balance = balance +? where userId=? ",count,targetUserId);
		
	}

	
//	public void transferMoney(int i, int j, double count) {
//		this.jdbctemplate.update("update account2 set balance = balance -? where userId=? ",count,i);
//		//throwException();
//		this.jdbctemplate.update("update account2 set balance = balance +? where userId=? ",count,j);
//		
//	}
	
	  //异常
//    private void throwException(){
//   	 throw new RuntimeException("Error");
//    }
    
	

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("mybatis-context.xml");
		TransferMoneyByjdbc transfer = context.getBean("TransferMoneyByjdbc",TransferMoneyByjdbc.class);
	    transfer.resetMoney();
	    List<Account> list =transfer.accountList();
		for(Account ac: list){
			System.out.println(ac.getId()+":"+ac.getBalance());
		}
		long a = 1;
		long b = 2;
		try {
		transfer.transferMoney(a, b, 100.0);
		} catch (Exception e) {
		  e.printStackTrace();
		}
		
		List<Account> list2 =transfer.accountList();
		for(Account ac: list2){
			System.out.println(ac.getId()+":"+ac.getBalance());
		
		 ((ConfigurableApplicationContext)context).close();
		

	}
	

	}
}
