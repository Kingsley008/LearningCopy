package com.netease.spring.mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
public class Service implements TransferService {
    @Resource
	private AccountDao ac;

    @Transactional(propagation = Propagation.REQUIRED)
	public void transferByMybatis(Long srcUserId, Long targetUserId, double count) {
	     
	    Account ac1 = ac.getId(srcUserId);
	    ac1.setBalance(ac1.getBalance()-count);
	    Account ac2 = ac.getId(targetUserId);
	    ac2.setBalance(ac2.getBalance()+count);
	    
	    ac.update(ac1);
	 //   throwException();
	    ac.update(ac2);
	    
		}	
    private void throwException(){
	 	 throw new NullPointerException("Error");
	  }
    public void showMoney (){
  	    ApplicationContext context = new ClassPathXmlApplicationContext("mybatis-context.xml");	
    	AccountDao  dao = (AccountDao)context.getBean("accountImp");
  	    List <Account>list = dao.getAccount();
  	    for(Account ac : list){
  	    	System.out.println(ac.getId()+" :"+ac.getBalance());
  	    }
  	    ((ConfigurableApplicationContext)context).close();
    }
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("mybatis-context.xml");	
		TransferService  sdao = (TransferService)context.getBean("service");
        sdao.showMoney();
        long a =1;
        long b =2;
        try{
        sdao.transferByMybatis(a, b, 100);
        }catch(Exception e){
        	e.printStackTrace();
        }
        sdao.showMoney();
	
		
		((ConfigurableApplicationContext)context).close();
	}
		
}
