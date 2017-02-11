package com.netease.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
@Aspect
public class SecurityHandler {
	@AfterReturning(returning="rvt",pointcut="execution(* com.netease.spring.aop.UserManagerImp.*(..))")
	private void checkSecurity(JoinPoint jp,boolean rvt){
	 
	 for(int i=0;i< jp.getArgs().length;i++){
		 System.out.println(jp.getArgs()[i]);
	 }
	 System.out.println(jp.getSignature().getName());
	if(rvt=true){ 
	 System.out.println("======正常返回====");
	}
  }
	@AfterThrowing(
		throwing="ex",	
		pointcut="execution(* com.netease.spring.aop.UserManagerImp.*(..))")
	private void doException (IllegalArgumentException ex,JoinPoint jp){
		
		for(int i=0;i< jp.getArgs().length;i++){
			 System.out.println(jp.getArgs()[i]);
		 }
		 System.out.println(jp.getSignature().getName());
		System.out.println("======出现异常====");
		ex.printStackTrace();
	}
}
