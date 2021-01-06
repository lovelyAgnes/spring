package dao;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.Product;

public class ProductDao extends HibernateDaoSupport{
	//DAO中的保存商品的方法
	public void save(Product product){
	//调用sessionFactory中的getHibernateTemplate的方法.
	this.getHibernateTemplate().save(product);
	System.out.println("DAO中的save方法执行了...");
	}
}
