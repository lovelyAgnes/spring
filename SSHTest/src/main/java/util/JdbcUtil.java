package util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.ProductDao;

public class JdbcUtil {

	public static void main(String[] args) throws ConfigurationException {
		
		//propertyConfig();
		connection();
	}
	
	public static void connection(){
		//Configuration  conf = new Configuration().configure();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductDao productDao=(ProductDao) ctx.getBean("productDao");
		System.out.println(productDao);
	}
	public static void propertyConfig() throws ConfigurationException{

	    PropertiesConfiguration config = new PropertiesConfiguration("/jdbc.properties");  
	    String userName = config.getString("jdbc.username"); 
	    String driverClass = config.getString("jdbc.driverClass");
	    String url = config.getString("jdbc.url");
	    String password = config.getString("jdbc.password");
	    System.out.println(driverClass+" "+url+" "+userName+" "+password);

	}

}
