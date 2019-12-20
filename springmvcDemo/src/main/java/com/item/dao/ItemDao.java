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
	   * spring�ṩ����
	   * 
	   * @param jdbcTemplate
	   *      ����ֵ���ͣ� void
	   * @author janinus
	   */
	  /*public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	  this.jdbcTemplate = jdbcTemplate;
	  }*/
	public void setDataSource(DataSource dataSource){
        //�൱��this.getJdbcTemplate()
		jdbcTemplate = new JdbcTemplate(dataSource);
        
    }
	 
	  /**
	   * ��ѯ�����Ŀ
	   * 
	   * @return ����ֵ���ͣ� List<Student>
	   * @author janinus
	   */
	@Transactional
	  public List<Items> queryAll() {
	  String sql = "select id,name,price,createtime,detail from table_item";
	  //����ѯ���ӳ�䵽Items���У���ӵ�list�У�������
	  return jdbcTemplate.query(sql,new ItemsMapper());
	  }
	 
	  /**
	   * ͨ����ѯ
	   * 
	   * @param name
	   * @return ����ֵ���ͣ� List<Student>
	   * @author janinus
	   */
	@Transactional
	  public List<Items> queryByName(String name) {
	  String sql = "select id,name,price,createtime,detail from table_item where name like '%" + name + "%'";
	  return jdbcTemplate.query(sql, new ItemsMapper());
	  }
	 
	  /**
	   * �����Ŀ
	   * 
	   * @param student
	   * @return ����ֵ���ͣ� boolean
	   */
	@Transactional
	  public boolean addItems(Items items) {
	  String sql = "insert into table_item(id,name,price,createtime,detail) values(?,?,?,?,?)";
	  return jdbcTemplate.update(sql,
	    new Object[] {items.getId(),items.getName(),items.getPrice(),items.getCreatetime(),items.getDetail()},
	    new int[] { Types.INTEGER,Types.VARCHAR, Types.FLOAT, Types.DATE, Types.VARCHAR }) == 1;
	  }
	 
	  /**
	   * ɾ��
	   * 
	   * @param id
	   * @return ����ֵ���ͣ� boolean
	   */
	  public boolean deleteStu(Integer id) {
	  String sql = "delete from table_item where id = ?";
	  return jdbcTemplate.update(sql, id) == 1;
	  }
	 
	  /**
	   * ����
	   * 
	   * @return ����ֵ���ͣ� boolean
	   */
	  public boolean updateItems(Items items) {
	  String sql = "update table_item set id=? ,name=?,price = ? ,createTime = ? where id = ?";
	  Object stuObj[] = new Object[] {items.getId(),items.getName(),items.getPrice(),items.getCreatetime(),items.getDetail()};
	  return jdbcTemplate.update(sql, stuObj) == 1;
	  }
	 
	  /**
	   * �����ܳɼ�ǰn��ѧ��
	   * 
	   * @param num
	   * @return ����ֵ���ͣ� List<Student>
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
	   * StudentMapper���ݿ�ӳ��
	   * 
	   * @ClassName StudentMapper
	   * @author janinus
	   * @date 2017��6��27��
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
