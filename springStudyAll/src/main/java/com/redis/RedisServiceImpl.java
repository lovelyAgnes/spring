//package com.redis;
//
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import javax.annotation.Resource;
//
//import org.springframework.data.redis.core.ListOperations;
//import org.springframework.data.redis.core.RedisOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Service;
//
////@Service
//public class RedisServiceImpl implements RedisService {
//	//@Resource
//    private RedisTemplate<String,Object> redisTemplate;
//	/**
//     * ��ȡ�����ַ�����ValueOperations
//     */
//    public  ValueOperations<String,Object> getValueOperations(){
//        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
//        return vo;
//    }
//    
//	@Override
//	public void set(String key, Object value) {
//        getValueOperations().set(key, value);
//		
//	}
//
//	@Override
//	public void set(String key, Object value, Long expire) {
//		redisTemplate.opsForValue().set(key,value);
//		//���ù���ʱ��
//		redisTemplate.expire(key,expire,TimeUnit.SECONDS);
//		
//	}
//
//	@Override
//	public Object get(String key) {
//        return getValueOperations().get(key);
//	}
//
//	@Override
//	public void delete(String key) {
//        RedisOperations<String, Object> operations = getValueOperations().getOperations();
//        operations.delete(key);
//	}
//
//	@Override
//	public Long lpush(String key, String value) {
//		//��ȡ����list�Ķ���
//    	ListOperations<String, Object> opsForList = redisTemplate.opsForList();
//    	Long length = opsForList.leftPush(key,value);
//        return length;
//
//	}
//
//	@Override
//	public List<Object> range(String key) {
//		//��ȡ����list�Ķ���
//    	ListOperations<String, Object> opsForList = redisTemplate.opsForList();
//		return opsForList.range(key,0,-1);
//	}
//
//	@Override
//	public Long lPushAll(String key, List<Object> list) {
//		//��ȡ����list�Ķ���
//    	ListOperations<String, Object> opsForList = redisTemplate.opsForList();
//		return opsForList.leftPushAll(key,list);
//	}
//
//	@Override
//	public Long remove(String key, long count, Object value) {
//		//��ȡ����list�Ķ���
//    	ListOperations<String, Object> opsForList = redisTemplate.opsForList();
//		return opsForList.remove(key,count,value);
//	}
//
//}
