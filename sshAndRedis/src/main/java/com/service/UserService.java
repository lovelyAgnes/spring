package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.entity.Order;
import com.entity.User;
import com.requestParas.RequestOrder;
//
@Service
@Transactional
//@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class UserService {
	
//	@Autowired
//	private CacheUtil cacheUtil;
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * @return the cacheUtil
	 */
//	public CacheUtil getCacheUtil() {
//		return cacheUtil;
//	}
//
//	/**
//	 * @param cacheUtil the cacheUtil to set
//	 */
//	public void setCacheUtil(CacheUtil cacheUtil) {
//		this.cacheUtil = cacheUtil;
//	}

	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	public List loadUsers(){
		return userDao.loadUsers();
	}
	
//	public User getUser(Integer id){
//		return (User) cacheUtil.getUserMap().get(id);
//	}
	

	public void addUser(User user){
		userDao.addUser(user);
	}
	
	public User getUser(int id){
		return userDao.getUser(id);
	}
	
	public void delUser(int id){
		userDao.delUser(id);
	}
	public void updateUser(User user){
		userDao.updateUser(user);;
	}
	
}
