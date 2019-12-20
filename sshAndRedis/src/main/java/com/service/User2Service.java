package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.User2Dao;
import com.dao.UserDao;
import com.entity.User2;

@Service
public class User2Service {
	@Autowired
	private User2Dao user2Dao;
	
	

	/**
	 * @return the user2Dao
	 */
	public User2Dao getUser2Dao() {
		return user2Dao;
	}

	/**
	 * @param user2Dao the user2Dao to set
	 */
	public void setUser2Dao(User2Dao user2Dao) {
		this.user2Dao = user2Dao;
	}
	
	public User2 getUser2(int id){
		return user2Dao.getUser2(id);
	}
	
	public List<User2> loadUsers(){
		return user2Dao.loadUsers();
	}
	
}
