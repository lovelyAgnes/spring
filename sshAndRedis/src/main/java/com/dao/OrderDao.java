package com.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Order;
import com.entity.User;
import com.requestParas.RequestOrder;

@Repository
public class OrderDao extends HibernateDaoSupport{
	@Resource
	public void setSessionFactory0(SessionFactory sessionFactory){  
	    super.setSessionFactory(sessionFactory);  
	}
	
	public void addUserAndOrder(RequestOrder requestOrder){
		Order order = requestOrder.getOrder();
		order.setUser(requestOrder.getUser());
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		session.save(order);
		//session.merge(user);
		
		//session.update(user);
		tr.commit();
		//this.getHibernateTemplate().setCheckWriteOperations(false);
		//this.getHibernateTemplate().saveOrUpdate(user);

	}
	
	public void addOrder(Order order){
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		session.save(order);
		tr.commit();
	}
	public List<Order> getOrders(){
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("from Order");
		return query.list();
		//return this.getHibernateTemplate().loadAll(Order.class);
	}
}
