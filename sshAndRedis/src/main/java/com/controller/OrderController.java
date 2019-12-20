package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Order;
import com.entity.User;
import com.requestParas.RequestOrder;
import com.service.IOrderService;

@RestController
public class OrderController {
	@Autowired
	private IOrderService orderService;

	/**
	 * @return the orderService
	 */
	public IOrderService getOrderService() {
		return orderService;
	}

	/**
	 * @param orderService the orderService to set
	 */
	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	
	@RequestMapping(value = "/addUserAndOrder")
	public void addUserAndOrder(){
		Order order = new Order(100,"连衣裙");
		User user = new User("张三风", "22", "男", "15612345678", "重庆万州");
		RequestOrder requestOrder = new RequestOrder();
		requestOrder.setOrder(order);
		requestOrder.setUser(user);
		orderService.addUserAndOrder(requestOrder);
	}
	@RequestMapping(value = "/addOrder",produces = "text/html;charset=utf-8")
	public String addOrder(){
		Order order = new Order(100,"连衣裙",8);
		orderService.addOrder(order);
		return "增加订单成功";
	}
	
	@RequestMapping(value = "/loadOrders")
	public  List<Order> loadOrders(){
		IOrderService IOrderService = orderService;
	    List<Order> list = orderService.getOrders();
	    return list;
	     }
	
}
