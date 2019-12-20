package com.entity;

import java.util.Set;

import org.hibernate.annotations.Entity;

//@Entity
public class User implements java.io.Serializable{
	public User(){
		
	}
	public User(String name,String age,String sex,String tel,String addr){
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.tel = tel;
		this.addr = addr;
	}
	private Integer id;
	private String name;
	private String age;
	private String sex;
	private String tel;
	private String addr;
	private Set<Order> orders;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	/**
	 * @return the orders
	 */
	public Set<Order> getOrders() {
		return orders;
	}
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}
