package com.service;

import java.util.List;

import com.entity.Order;
import com.requestParas.RequestOrder;

public interface IOrderService {
	List<Order> getOrders();
	void addUserAndOrder(RequestOrder requestOrder);
	void addOrder(Order order);
}
