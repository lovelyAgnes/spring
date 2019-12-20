package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Order;
import com.entity.User;
import com.requestParas.RequestOrder;
import com.service.IOrderService;
import com.service.UserService;



@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Resource(name="orderServiceImpl") 
	private IOrderService orderService;
	

	@RequestMapping(value = "/loadUsers")
	public  List<User> loadUsers(){
	    List<User> list = userService.loadUsers();
	    return list;
	     }
	@RequestMapping(value = "/loadOrders2")
	public  List<Order> loadOrders(){
		IOrderService IOrderService = orderService;
	    List<Order> list = orderService.getOrders();
	    return list;
	     }
	
	
	@RequestMapping(value = "/addUser")
	public List<User> addUser(){
		User user = new User("张四风", "23", "男", "12311111111", "北京");
		userService.addUser(user);
		List<User> loadUsers = userService.loadUsers();
		return loadUsers;
	}
	@RequestMapping(value = "/getUser")
	public User getUser(@RequestParam(value="id") int id){
		
		return userService.getUser(id);
	}
	@RequestMapping(value = "/delUser")
	public void delUser(@RequestParam(value="id") int id){
		
		userService.delUser(id);
	}
	@RequestMapping(value = "/updateUser")
	public void updateUser(@RequestParam(value="id") int id){
		User user = new User("王舞", "25", "女", "13454231296", "陕西西安");
		user.setId(id);
		userService.updateUser(user);
	}
	
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
	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}
	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
//	@RequestMapping(value = "/show")
//	public List<User> showUsers(){
//	    List<User> list = userService.getUsers();
//	    return list;
//	     ModelAndView mav = new ModelAndView();
//
//	     mav.addObject("userList", list);
//
//	     mav.setViewName("userList.jsp");	      
//	     return mav;
//	     }

}
