package com.entity;

import java.io.Serializable;

public class Order implements Serializable{
	public Order(){}
	public Order(Integer price,String productname){
		this.price = price;
		this.productname = productname;
	}
	public Order(Integer price,String productname,Integer userid){
		this.price = price;
		this.productname = productname;
		this.userid = userid;
	}
	private Integer orderid;
	private Integer price;
	private String productname;
	private Integer userid;	
	private User user;
	
	/**
	 * @return the orderid
	 */
	public Integer getOrderid() {
		return orderid;
	}
	/**
	 * @param orderid the orderid to set
	 */
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}
	/**
	 * @return the productname
	 */
	public String getProductname() {
		return productname;
	}
	/**
	 * @param productname the productname to set
	 */
	public void setProductname(String productname) {
		this.productname = productname;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the userid
	 */
	public Integer getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	
	
	
}
