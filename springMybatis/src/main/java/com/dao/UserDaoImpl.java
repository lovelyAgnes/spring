package com.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.User;

//@Repository
//extends SqlSessionDaoSupport
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	
	//@Autowired
	//private SqlSessionFactoryBean sqlSessionFactory;
	
	
	//private SqlSession sqlSession;
	//sqlSession=sqlSessionFactory.openSession();
	/*@Autowired
	public UserDaoImpl(SqlSessionFactoryBean sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}*/
	@Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }
	/**
	 * 获取Object对象
	 * @param statement
	 * @return
	 */
	public Object selectOne(String statement,Object parameter) {
		return getSqlSession().selectOne(statement, parameter);
	}

    public User queryById(int id) throws Exception{    	    	
    	//SqlSessionFactory sessionFactory = sqlSessionFactory.getObject();
    	//SqlSession sqlSession = sessionFactory.openSession();
    	//UserDao userDao=sqlSession.getMapper(UserDao.class);
    	//User user=userDao.findUserById(id);
    	Object object= this.selectOne("com.dao.UserDao.findUserById",id);
    	User user = (User) object;
		return user;
    }

	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = this.getSqlSession();
		User user = sqlSession.selectOne("com.dao.UserDao.findUserById",id);
		return user;
	}


	/*@Override
	public User findUserById(int id) throws Exception {
		SqlSessionFactory sessionFactory = sqlSessionFactory.getObject();
    	SqlSession sqlSession = sessionFactory.openSession();
    	UserDao userDao=sqlSession.getMapper(UserDao.class);
    	User user=userDao.findUserById(id);
		return user;
	}*/
    
}
