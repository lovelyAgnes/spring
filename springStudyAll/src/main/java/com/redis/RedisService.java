package com.redis;

import java.util.List;

public interface RedisService {
	/**
	 * ��Redis�д���ַ���
	 *
	 * @param key
	 * @param value
	 */
	void set(String key, Object value);
	
	/**
	 * ��Redis�д���ַ���[�����ù���ʱ��]
	 *
	 * @param key
	 * @param value
	 * @param expire ��λs
	 */
	void set(String key, Object value, Long expire);
 
	/**
	 * ����keyֵ��ȡ���ݡ������ַ�����
	 *
	 * @param key
	 * @return
	 */
	Object get(String key);
 
	/**
	 * ɾ��ָ���ļ�ֵ�������ַ�����
	 * 
	 * @param key
	 * @return
	 */
	void delete(String key);
 
	/**
	 * ������ݵ�list�Ķ���������List��
	 * 
	 * @param key List����
	 * @param value ��ŵ���ֵ
	 * @return ������֮�󣬵�ǰList�ĳ���
	 */
	Long lpush(String key, String value);
	
	/**
	 * ��ȡList�����е����ݡ�����List��
	 * 
	 * @param key List����
	 * @return list�д�ŵ�����
	 */
	List<Object> range(String key);
	
	/**
	 * ��List�����д�ż���
	 * 
	 * @param key ��������List
	 * @param list ��Ҫ��ӵ�List
	 * @return ������֮�󣬵�ǰList�ĳ���
	 */
	 Long lPushAll(String key, List<Object> list);
	 
	 /**
	 * �Ƴ�List�е�Ԫ��
	 * 
	 * @param key ��������List
	 * @param count Ҫɾ����Ԫ�ظ�����Ϊ������ʾ��β������ͷ��ɾ��;�������෴��
	 * @param value Ҫɾ����Ԫ��ֵ
	 * @return �Ƴ����֮�󣬵�ǰList�ĳ���
	 */
	 Long remove(String key, long count, Object value);
}
