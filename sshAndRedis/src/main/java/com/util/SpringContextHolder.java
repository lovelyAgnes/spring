package com.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringContextHolder implements ApplicationContextAware{
	private static ApplicationContext ctx = null;
	 public SpringContextHolder() {
	        super();
	    }
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		SpringContextHolder.ctx = ctx;
		
	}
	
	

    public static void setCtx(ApplicationContext ctx) {
    	SpringContextHolder.ctx = ctx;
    }
   

    public static ApplicationContext getContext() {
        return ctx;
    }

}
