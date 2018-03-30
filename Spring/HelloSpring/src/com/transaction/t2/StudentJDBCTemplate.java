package com.transaction.t2;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.transaction.*;

public class StudentJDBCTemplate implements StudentDAO {
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(Integer id, String name, Integer age, Integer marks, Integer year) {
		try {
			 String SQL1 = "insert into Student values (?, ?, ?)";
	         jdbcTemplateObject.update( SQL1, id, name, age);
	         String SQL2 = "insert into Marks values (?, ?, ?)";
	         jdbcTemplateObject.update( SQL2, id, marks, year);
	         System.out.println("Created Name = " + name + ", Age = " + age);
			// to simulate the exception.
			throw new RuntimeException("simulate Error condition");
		} catch (DataAccessException e) {
			System.out.println("Error in creating record, rolling back");
			throw e;
		}
	}

	public List<StudentMarks> listStudents() {
		String SQL = "select * from Student, Marks where Student.id=Marks.sid";
		List<StudentMarks> studentMarks = jdbcTemplateObject.query(SQL,
				new StudentMarksMapper());
		return studentMarks;
	}
}
