package com.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.UserDao;
import com.ssm.model.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	public User queryById(int id){
		User user = userDao.queryById(id);
		return user;
	}
	public List<User> queryAll(){
		return userDao.queryAll();
	}
	
}
