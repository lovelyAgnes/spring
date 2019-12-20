package com.test;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Log4J ��Ҫ�� Loggers (��־��¼��)��Appenders������ˣ��� Layout����־��ʽ��������ɡ�
 * ���� Loggers ������־�������������־�Ƿ������
 * Appenders ָ����־�������ʽ�����������̨���ļ��ȣ���
 * Layout ������־��Ϣ�������ʽ��
 * 
 */
public class Log4jTest {

	public static void main(String[] args) {
		test3();


	}
	
	public static void test1(){
		//��ȡLogger�����ʵ��         
        Logger logger = Logger.getLogger(Log4jTest.class);
        //ʹ��Ĭ�ϵ�������Ϣ������Ҫдlog4j.properties
        BasicConfigurator.configure();
        //������־�������ΪWARN���⽫���������ļ������õļ���ֻ����־�������WARN����־�����
        logger.setLevel(Level.WARN);
        logger.debug("����debug");
        logger.info("����info");
        logger.warn("����warn");
        logger.error("����error");
        logger.fatal("����fatal");
	}
	
	public static void test2(){
		Logger logger = Logger.getLogger(Log4jTest.class);
        BasicConfigurator.configure();
        HTMLLayout layout = new HTMLLayout();
        // SimpleLayout layout = new SimpleLayout();
        try {
            FileAppender appender = new FileAppender(layout, "E:\\out.html", false);
            logger.addAppender(appender);
            //������־�������Ϊinfo���⽫���������ļ������õļ���ֻ����־�������WARN����־�����
            logger.setLevel(Level.WARN);
            logger.debug("����debug");
            logger.info("����info");
            logger.warn("����warn");
            logger.error("����error");
            logger.fatal("����fatal");
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	public static void test3(){
		//��ȡLogger�����ʵ��         
        Logger logger = Logger.getLogger(Log4jTest.class);
        //ʹ��log4j.properties�����ļ�
        //������־�������ΪWARN���⽫���������ļ������õļ���ֻ����־�������WARN����־�����
        logger.setLevel(Level.WARN);
        logger.debug("����debug");
        logger.info("����info");
        logger.warn("����warn");
        logger.error("����error");
        logger.fatal("����fatal");
	}

}
