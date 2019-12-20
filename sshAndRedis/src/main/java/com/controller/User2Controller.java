package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User2;
import com.service.User2Service;

@RestController
public class User2Controller {
	@Autowired
	private User2Service user2Service;
	
	
	@RequestMapping("/getUser2")
	public User2 getUser2(@RequestParam(value="id") int id){
		return user2Service.getUser2(id);
	}
	@RequestMapping("/loadUser2s")
	public List<User2> loadUser2s(){
		return user2Service.loadUsers();
	}
	
	/**
	 * @return the user2Service
	 */
	public User2Service getUser2Service() {
		return user2Service;
	}

	/**
	 * @param user2Service the user2Service to set
	 */
	public void setUser2Service(User2Service user2Service) {
		this.user2Service = user2Service;
	}
}
