package com.ssm.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssm.model.User;

public interface UserDao {
	public User queryById(int id);
	public List<User> queryAll();
}
