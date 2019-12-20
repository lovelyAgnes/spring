//package com.util;
//
//import java.util.List;
//import java.util.Map;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.springframework.context.annotation.Configuration;
//
//import com.entity.User;
//
//@Configuration
//public class CacheUtil {
//	
//	private DBUtil dbUtil;
//	private Map userMap;
//	/**
//	 * @return the userMap
//	 */
//	public Map getUserMap() {
//		return userMap;
//	}
//	/**
//	 * @param userMap the userMap to set
//	 */
//	public void setUserMap(Map userMap) {
//		this.userMap = userMap;
//	}
//	public Map getUsers() {
//		Session session = null;
//		List<User> list = null;
//		try {
//			session = dbUtil.getSession();
//			String hql = "from t_user";
//			Query query = session.createQuery(hql);
//			list= (List<User>) query.list();
//
//		} catch(Exception e){
//			e.printStackTrace();
//		}
//		finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		for(User user:list){
//			userMap.put(user.getId(), user);
//		}
//		return userMap;
//	}
//}
