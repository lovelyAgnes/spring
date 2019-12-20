package com.requestParas;

import java.io.Serializable;

import com.entity.Order;
import com.entity.User;

public class RequestOrder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5493679006791837669L;
	private User user;
	private Order order;
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
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
