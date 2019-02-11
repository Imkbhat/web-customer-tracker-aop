package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	//set up logger
	private Logger myLogger = 
			Logger.getLogger(CRMLoggingAspect.class.getName());
	
	//point cut
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	public void forControllerPackage() {}
	
	//Service and DAO
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	public void forServicePackage() {}

	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	//all
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void forAppFlow() {
		
	}
	
	//@before
	@Before("forAppFlow()") 
	public void before(JoinPoint joinPoint) {

		//display method
		String method = joinPoint.getSignature().toShortString();
		
		myLogger.info("Method Name=========>>>>>>>>" +method);
		
		//display args
		Object args[] = joinPoint.getArgs();
		for (Object argus : args) {
			myLogger.info(argus);
		}
	}

	//@afterReturn
	
	@AfterReturning(
			pointcut="execution()",
			returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
	
		//display method
		String method = joinPoint.getSignature().toShortString();
		myLogger.info("Method afterReturning Name=========>>>>>>>>" +method);
		myLogger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+result);
	}
}
