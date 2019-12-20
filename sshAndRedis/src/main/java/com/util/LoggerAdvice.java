package com.util;

import java.lang.reflect.Method;

import org.jboss.logging.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class LoggerAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method mathod, Object[] arg2, Object target) throws Throwable {
		Logger logger = Logger.getLogger(target.getClass());
		if(returnValue != null){
            logger.debug("+-------Return : " + returnValue.toString());
        }
		System.out.println(returnValue.toString());
		
	}

}
