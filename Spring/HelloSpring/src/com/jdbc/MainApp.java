package com.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	/**
	 * 在使用普通的 JDBC 数据库时,就会很麻烦的写不必要的代码来处理异常,
	 * 打开和关闭数据库连接等。但 Spring JDBC 框架负责所有的低层细节,
	 * 从开始打开连接,准备和执行 SQL 语句,处理异常,处理事务,到最后关闭连接。
	 * 
	 */
	/**
	 * Oracle建表
		CREATE TABLE Student(
		ID   NUMBER(11) PRIMARY KEY,
		NAME VARCHAR2(20) NOT NULL,
		AGE  NUMBER(11) NOT NULL
		);
	 */
	/**
	 * Oracle建存储过程
	 * 
	  create or replace procedure getRecord (in_id IN NUMBER, out_name OUT VARCHAR2, out_age OUT NUMBER)
	  as
	  begin 
	    SELECT name, age
	    INTO out_name, out_age
	    FROM Student where id = in_id;
	  end;
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("JdbcBeans.xml");
		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
		
		System.out.println("------Records Creation--------");
		studentJDBCTemplate.create(1,"Zara", 11);
		studentJDBCTemplate.create(2,"Nuha", 2);
		studentJDBCTemplate.create(3,"Ayan", 15);
		System.out.println("------Listing Multiple Records--------");
		List<Student> students = studentJDBCTemplate.listStudents();
		for (Student record : students) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.println(", Age : " + record.getAge());
		}
		System.out.println("----Updating Record with ID = 2 -----");
		studentJDBCTemplate.update(2, 20);
		System.out.println("----Listing Record with ID = 2 -----");
		Student student = studentJDBCTemplate.getStudent(2);
		System.out.print("ID : " + student.getId());
		System.out.print(", Name : " + student.getName());
		System.out.println(", Age : " + student.getAge());
		
		System.out.println("---- procedure getRecord -----");
		Student student2 = studentJDBCTemplate.getStudent2(2);
		System.out.print("ID : " + student2.getId());
		System.out.print(", Name : " + student2.getName());
		System.out.println(", Age : " + student2.getAge());
	}

}
