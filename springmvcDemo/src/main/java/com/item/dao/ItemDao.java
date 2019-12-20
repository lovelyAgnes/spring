package com.item.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.item.pojo.Items;

@Repository
public class ItemDao {
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	 
	  /**
	   * spring提供的类
	   * 
	   * @param jdbcTemplate
	   *      返回值类型： void
	   * @author janinus
	   */
	  /*public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	  this.jdbcTemplate = jdbcTemplate;
	  }*/
	public void setDataSource(DataSource dataSource){
        //相当于this.getJdbcTemplate()
		jdbcTemplate = new JdbcTemplate(dataSource);
        
    }
	 
	  /**
	   * 查询所有項目
	   * 
	   * @return 返回值类型： List<Student>
	   * @author janinus
	   */
	@Transactional
	  public List<Items> queryAll() {
	  String sql = "select id,name,price,createtime,detail from table_item";
	  //将查询结果映射到Items类中，添加到list中，并返回
	  return jdbcTemplate.query(sql,new ItemsMapper());
	  }
	 
	  /**
	   * 通过查询
	   * 
	   * @param name
	   * @return 返回值类型： List<Student>
	   * @author janinus
	   */
	@Transactional
	  public List<Items> queryByName(String name) {
	  String sql = "select id,name,price,createtime,detail from table_item where name like '%" + name + "%'";
	  return jdbcTemplate.query(sql, new ItemsMapper());
	  }
	 
	  /**
	   * 添加项目
	   * 
	   * @param student
	   * @return 返回值类型： boolean
	   */
	@Transactional
	  public boolean addItems(Items items) {
	  String sql = "insert into table_item(id,name,price,createtime,detail) values(?,?,?,?,?)";
	  return jdbcTemplate.update(sql,
	    new Object[] {items.getId(),items.getName(),items.getPrice(),items.getCreatetime(),items.getDetail()},
	    new int[] { Types.INTEGER,Types.VARCHAR, Types.FLOAT, Types.DATE, Types.VARCHAR }) == 1;
	  }
	 
	  /**
	   * 删除
	   * 
	   * @param id
	   * @return 返回值类型： boolean
	   */
	  public boolean deleteStu(Integer id) {
	  String sql = "delete from table_item where id = ?";
	  return jdbcTemplate.update(sql, id) == 1;
	  }
	 
	  /**
	   * 更新
	   * 
	   * @return 返回值类型： boolean
	   */
	  public boolean updateItems(Items items) {
	  String sql = "update table_item set id=? ,name=?,price = ? ,createTime = ? where id = ?";
	  Object stuObj[] = new Object[] {items.getId(),items.getName(),items.getPrice(),items.getCreatetime(),items.getDetail()};
	  return jdbcTemplate.update(sql, stuObj) == 1;
	  }
	 
	  /**
	   * 返回总成绩前n名学生
	   * 
	   * @param num
	   * @return 返回值类型： List<Student>
	   * @author janinus
	   */
	 /* public List<Student> topNum(int num) {
	  String sql = "select id,name,javaScore+htmlScore+cssScore from student order by javaScore+htmlScore+cssScore desc ,name asc limit ?";
	  return jdbcTemplate.query(sql, new RowMapper<Student>() {
	 
	    @Override
	    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
	    // TODO Auto-generated method stub
	    Student student = new Student();
	    student.setId(rs.getInt(1));
	    student.setName(rs.getString(2));
	    student.setTotalScore(rs.getDouble(3));
	    return student;
	    }
	  }, num);
	  }
	 */
	  /**
	   * 
	   * StudentMapper数据库映射
	   * 
	   * @ClassName StudentMapper
	   * @author janinus
	   * @date 2017年6月27日
	   * @Version V1.0
	   */
	 
	  class ItemsMapper implements RowMapper<Items> {
		  @Transactional
	  public Items mapRow(ResultSet rs, int rowNum) throws SQLException {
		  Items items=new Items(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getDate(4), rs.getString(5));		  
	      return items;
	  }
	 
	  }
}
