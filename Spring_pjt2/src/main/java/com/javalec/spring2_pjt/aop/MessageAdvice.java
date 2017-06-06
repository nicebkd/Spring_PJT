package com.javalec.spring2_pjt.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//Advice : 공통 업무를 지원하는 클래스

@Component //기타 bean
@Aspect //AOP bean
public class MessageAdvice {
	private static final Logger logger
				=LoggerFactory.getLogger(MessageAdvice.class);
	
	@Before("execution(* com.javalec.spring2_pjt.service.message.MessageService*.*(..))")
	public void startLog(JoinPoint jp){
		//signature 클래스 getname 메소드
		logger.info("클래스 :" + jp.getSignature());
		logger.info("메서드 :" + jp.getSignature().getName());
		logger.info("매개 변수 :" +Arrays.toString(jp.getArgs()));
	}
}
