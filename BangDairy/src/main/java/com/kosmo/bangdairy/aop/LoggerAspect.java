package com.kosmo.bangdairy.aop;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class LoggerAspect {
	
	public static Logger logger = LogManager.getLogger("Aop");
	
	@Around("execution(* com.kosmo.bangdairy.controller.*Controller.*(..))")
	public Object controllerAspect(ProceedingJoinPoint jp) throws Throwable{
		String type = jp.getSignature().getDeclaringTypeName(); // 해당 메소드의 클래스이름 반환
		String name = "Controller \t";
		logger.info(name+type+"."+jp.getSignature().getName()+" , Param : "+Arrays.toString(jp.getArgs())); //jp.getSignature().getName()메소드 이름
		return jp.proceed();
	}
	@Around("execution(* com.kosmo.bangdairy.service.*ServiceImpl.*(..))")
	public Object serviceAspect(ProceedingJoinPoint jp) throws Throwable{
		String type = jp.getSignature().getDeclaringTypeName(); // 해당 메소드의 클래스이름 반환
		String name = "Service \t";
		logger.info(name+type+"."+jp.getSignature().getName()+" , Param : "+Arrays.toString(jp.getArgs())); //jp.getSignature().getName()메소드 이름
		return jp.proceed();
	}
	@Around("execution(* com.kosmo.bangdairy.dao.*DAOImpl.*(..))")
	public Object daoAspect(ProceedingJoinPoint jp) throws Throwable{
		String type = jp.getSignature().getDeclaringTypeName(); // 해당 메소드의 클래스이름 반환
		String name = "DAO \t";
		logger.info(name+type+"."+jp.getSignature().getName()+" , Param : "+Arrays.toString(jp.getArgs())); //jp.getSignature().getName()메소드 이름
		return jp.proceed();
	}
}
