package com.bean;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.entity.User;

public class TestSpringBean {

	public static void main(String[] args) {
		//XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("spring-mvc.xml"));
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring-mvc.xml");
		User obj = (User) factory.getBean("user");
		System.out.println(obj.getId());
	}

}
