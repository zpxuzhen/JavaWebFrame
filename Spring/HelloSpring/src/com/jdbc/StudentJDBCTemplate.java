package com.jdbc;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
public class StudentJDBCTemplate implements StudentDAO {
   private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject; 
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }
   public void create(String name, Integer age) {
      //先查数据库返回一个序列生成的id,再去调用create(int id, String name, Integer age)
	  //或者直接用序列插入一个值,再去查询当前序列
      return;
   }
   public void create(Integer id, String name, Integer age) {
	   String SQL = "insert into Student values (?, ?, ?)";     
	   jdbcTemplateObject.update( SQL, id, name, age);
	   System.out.println("Created Record Id = "+ id +" Name = " + name + " Age = " + age);
	   return;
   }
   public Student getStudent(Integer id) {
      String SQL = "select * from Student where id = ?";
      Student student = jdbcTemplateObject.queryForObject(SQL, 
                        new Object[]{id}, new StudentMapper());
      return student;
   }
   //通过getRecord存储过程查询
   public Student getStudent2(Integer id) {
	    SimpleJdbcCall jdbcCall =  new SimpleJdbcCall(dataSource).withProcedureName("getRecord")
	    		.declareParameters(
	    				new SqlParameter("in_id", Types.INTEGER),
	    				new SqlOutParameter("out_name", Types.VARCHAR),
	    				new SqlOutParameter("out_age", Types.INTEGER)
	    				);

		SqlParameterSource in = new MapSqlParameterSource().addValue("in_id",id);
	    Map<String, Object> out = jdbcCall.execute(in);
	    
		Student student = new Student();
		student.setId(id);
		student.setName((String) out.get("out_name"));
		student.setAge((Integer) out.get("out_age"));
		return student;
   }
   public List<Student> listStudents() {
      String SQL = "select * from Student";
      List <Student> students = jdbcTemplateObject.query(SQL, 
                                new StudentMapper());
      return students;
   }
   public void delete(Integer id){
      String SQL = "delete from Student where id = ?";
      jdbcTemplateObject.update(SQL, id);
      System.out.println("Deleted Record with ID = " + id );
      return;
   }
   public void update(Integer id, Integer age){
      String SQL = "update Student set age = ? where id = ?";
      jdbcTemplateObject.update(SQL, age, id);
      System.out.println("Updated Record with ID = " + id );
      return;
   }
}
