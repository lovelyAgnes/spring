//package com.util;
//
//import org.hibernate.Session;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.springframework.stereotype.Repository;
//
//
//@Repository
//public class DBUtil {
//	private static SessionFactory businessFactory;
//
//
//	static {
//		try {
//
//			Configuration configuration = new Configuration().configure();
////			Configuration configuration2 = new Configuration().configure("/hibernate.cfg2.xml");
//
//			businessFactory = configuration.buildSessionFactory();
//			
////			businessFactory2 = configuration2.buildSessionFactory();
//
//			
////			logFactory = new Configuration().configure(
////					"loghibernate.cfg.xml").buildSessionFactory();
//			 
//			
//		} catch (Throwable ex) {
//			throw new ExceptionInInitializerError(ex);
//		}
//	}
//	
//
//	public static Session getSession2() {
//		return null;
////		return businessFactory2.openSession();
//	}
//
//
//	public Session getSession() {
//		return businessFactory.openSession();
//	}
//
//}
