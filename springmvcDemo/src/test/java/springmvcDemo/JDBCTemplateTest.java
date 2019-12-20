package springmvcDemo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JDBCTemplateTest {
	 //@Test
	public static void demo(){
		 DriverManagerDataSource dataSource=new DriverManagerDataSource();
		 dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		 dataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8");
		 dataSource.setUsername("root");
		 dataSource.setPassword("123456");         
		 JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		 jdbcTemplate.execute("create table temp(id int primary key,name varchar(32))");	
		 System.out.println("create successful");
	}
	public static void main(String[] args) {
		demo();

	}

}
