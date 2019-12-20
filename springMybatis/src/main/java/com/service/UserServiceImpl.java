package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entity.User;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserDao userDao;

	@Override
	public User getUserById(int userId) {
		try {
			 
			User user=userDao.findUserById(userId);
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
