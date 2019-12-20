package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.entity.User2;
import com.util.SpringContextHolder;

@Repository
public class User2Dao extends HibernateDaoSupport{
	@Resource
	  public void setSessionFactory0(SessionFactory sessionFactory){  
	      super.setSessionFactory(sessionFactory);  
	   }
	public User2 getUser2(int id){
		//ApplicationContext ctx = SpringContextHolder.getContext(); 
		//通过切面获取bean
		//SpringContextHolder.getContext().getBean("sessionFactory", SessionFactory.class);
		//SessionFactory sessionFactory = (SessionFactory) SpringContextHolder.getContext().getBean("sessionFactory");
		Session  session = this.getHibernateTemplate().getSessionFactory().openSession();
		//session.beginTransaction();
		System.out.println(session.getFlushMode());
		User2 user2 = (User2) session.get(User2.class, id);
		return user2;
	}
	public List<User2> loadUsers(){
		
		return this.getHibernateTemplate().loadAll(User2.class);
		
	}
}
