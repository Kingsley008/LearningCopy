package com.netease.spring.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//定义aspect 日志功能
@Aspect
public class LoggingAspect {
//定义advice，在函数调用之前每次打一行日志和pointcut被横切的函数类型
	@Before("execution(* com.netease.spring.aop.Caculator.*(..))&& args(a,..)")
	private void arithmeticDoLog(JoinPoint jp, int a){
	 System.out.println(a+":"+jp.toString());	
	}
}
