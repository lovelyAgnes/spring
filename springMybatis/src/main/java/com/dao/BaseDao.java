//package com.dao;
//
//import javax.annotation.Resource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.support.SqlSessionDaoSupport;
//
//public class BaseDao extends SqlSessionDaoSupport{
//	
//	@Resource
//    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
//        super.setSqlSessionFactory(sqlSessionFactory);
//    }
//	/**
//	 * 获取Object对象
//	 * @param statement
//	 * @return
//	 */
//	public Object selectOne(String statement,Object parameter) {
//		return getSqlSession().selectOne(statement, parameter);
//	}
//
//}
