package com.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Order;
import com.entity.User;
import com.entity.User2;
import com.requestParas.RequestOrder;
//import com.util.DBUtil;
import com.util.SpringContextHolder;

@Repository
//extends BaseDao
public class UserDao extends HibernateDaoSupport{
//	@Resource(name="hibernateTemplate")
//	private HibernateTemplate hibernateTemplate;
//	@Autowired
//	private HibernateTemplate hibernateTemplate;
//	@Autowired
//	private DBUtil dbUtil;
//	@Resource
//	private DataSource dataSource;
	
	 @Resource
	  public void setSessionFactory0(SessionFactory sessionFactory){  
	      super.setSessionFactory(sessionFactory);  
	   }
	
	
	public List loadUsers(){
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery("from User");
		return query.list();
		//return this.getHibernateTemplate().loadAll(User.class);
	}
//	public List<User> getUsers(){
//		Session session = null;
//		List<User> list = null;
//		session = dbUtil.getSession();
//		String hql = "from t_user";
//		Query query = session.createQuery(hql);
//		list= (List<User>) query.list();		
//		return list;

//	}
	
	
	public void addUser(User user){
//		this.getHibernateTemplate().setCheckWriteOperations(true);
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		session.save(user);
		tr.commit();
		//this.getHibernateTemplate().save(user);
	}
	
	public User getUser(int id){
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		return (User) session.get(User.class, id);
	}
	
	public void delUser(int id){
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		Object user = session.get(User.class, id);
		session.delete(user);
		tr.commit();
		
	}
	
	public void updateUser(User user){
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		session.merge(user);
		//session.update(user);
		tr.commit();
		
	}
	
	
	
	
}
