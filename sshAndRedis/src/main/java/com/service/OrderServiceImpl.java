package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OrderDao;
import com.entity.Order;
import com.requestParas.RequestOrder;

@Service
public class OrderServiceImpl implements IOrderService{
	@Autowired
	private OrderDao orderDao;

	/**
	 * @return the orderDao
	 */
	public OrderDao getOrderDao() {
		return orderDao;
	}


	/**
	 * @param orderDao the orderDao to set
	 */
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}


	@Override
	public List<Order> getOrders() {
		return orderDao.getOrders();
	}

	
	@Override
	public void addUserAndOrder(RequestOrder requestOrder) {
		 orderDao.addUserAndOrder(requestOrder);
	}


	@Override
	public void addOrder(Order order) {
		orderDao.addOrder(order);
		
	}
}
