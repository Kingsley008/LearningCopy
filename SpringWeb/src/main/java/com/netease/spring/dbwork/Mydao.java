package com.netease.spring.dbwork;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Mydao implements Mdao {
	//rollbackForClassName={"RuntimeException"}
	
	@Transactional(propagation= Propagation.REQUIRED) 
  public void transferByMybatis(Long srcUserId, Long targetUserId, double count) {
		ApplicationContext context = new ClassPathXmlApplicationContext("mybatis-context.xml");	
		Mdao  md = context.getBean("mdao",Mdao.class);
	    Account ac1 = md.getId(srcUserId);
	    ac1.setBalance(ac1.getBalance()-count);
	    Account ac2 = md.getId(targetUserId);
	    ac2.setBalance(ac2.getBalance()+count);
	    try{
	    md.update(ac1);
	    throwException();
	    md.update(ac2);
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		((ConfigurableApplicationContext)context).close();
		}
  public void showMoney (){
	  ApplicationContext context = new ClassPathXmlApplicationContext("mybatis-context.xml");	
	    Mdao  md = context.getBean("mdao",Mdao.class);
	    List <Account>list = md.getAccount();
	    for(Account ac : list){
	    	System.out.println(ac.getId()+" :"+ac.getBalance());
	    }
	    ((ConfigurableApplicationContext)context).close();
  }
  
      private void throwException(){
	 	 throw new NullPointerException("Error");
	  }

  

	public static void main(String[] args) {
		long a =1 ;
		long b =2 ;
				
		Mydao md = new Mydao();
		md.showMoney();
	    try{
		md.transferByMybatis(a, b, 100);
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		md.showMoney();
		
  }
	@Override
	public List<Account> getAccount() {
		
		return null;
	}
	@Override
	public void update(Account ac) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Account getId(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
