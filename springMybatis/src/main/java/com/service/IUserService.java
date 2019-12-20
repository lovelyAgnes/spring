package com.service;

import org.springframework.stereotype.Service;

import com.entity.User;

@Service
public interface IUserService {
	 public User getUserById(int userId);  
}
