package com.test;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Log4J 主要由 Loggers (日志记录器)、Appenders（输出端）和 Layout（日志格式化器）组成。
 * 其中 Loggers 控制日志的输出级别与日志是否输出；
 * Appenders 指定日志的输出方式（输出到控制台、文件等）；
 * Layout 控制日志信息的输出格式。
 * 
 */
public class Log4jTest {

	public static void main(String[] args) {
		test3();


	}
	
	public static void test1(){
		//获取Logger对象的实例         
        Logger logger = Logger.getLogger(Log4jTest.class);
        //使用默认的配置信息，不需要写log4j.properties
        BasicConfigurator.configure();
        //设置日志输出级别为WARN，这将覆盖配置文件中设置的级别，只有日志级别高于WARN的日志才输出
        logger.setLevel(Level.WARN);
        logger.debug("这是debug");
        logger.info("这是info");
        logger.warn("这是warn");
        logger.error("这是error");
        logger.fatal("这是fatal");
	}
	
	public static void test2(){
		Logger logger = Logger.getLogger(Log4jTest.class);
        BasicConfigurator.configure();
        HTMLLayout layout = new HTMLLayout();
        // SimpleLayout layout = new SimpleLayout();
        try {
            FileAppender appender = new FileAppender(layout, "E:\\out.html", false);
            logger.addAppender(appender);
            //设置日志输出级别为info，这将覆盖配置文件中设置的级别，只有日志级别高于WARN的日志才输出
            logger.setLevel(Level.WARN);
            logger.debug("这是debug");
            logger.info("这是info");
            logger.warn("这是warn");
            logger.error("这是error");
            logger.fatal("这是fatal");
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	public static void test3(){
		//获取Logger对象的实例         
        Logger logger = Logger.getLogger(Log4jTest.class);
        //使用log4j.properties配置文件
        //设置日志输出级别为WARN，这将覆盖配置文件中设置的级别，只有日志级别高于WARN的日志才输出
        logger.setLevel(Level.WARN);
        logger.debug("这是debug");
        logger.info("这是info");
        logger.warn("这是warn");
        logger.error("这是error");
        logger.fatal("这是fatal");
	}

}
