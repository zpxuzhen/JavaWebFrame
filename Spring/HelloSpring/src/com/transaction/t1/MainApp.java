package com.transaction.t1;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.transaction.*;

public class MainApp {

	/**
	 * Spring 事务管理
	 * 编程式 vs. 声明式
		Spring 支持两种类型的事务管理:
		编程式事务管理 :这意味着你在编程的帮助下有管理事务。这给了你极大的灵活性,但却很难维护。
		声明式事务管理 :这意味着你从业务代码中分离事务管理。你仅仅使用注释或 XML 配置来管理事务。
		声明式事务管理比编程式事务管理更可取,尽管它不如编程式事务管理灵活,但它允许你通过代码控制事务。
		但作为一种横切关注点,声明式事务管理可以使用 AOP 方法进行模块化。
		Spring 支持使用 Spring AOP 框架的声明式事务管理。
	 */
	/**
	 * Oracle建表
		CREATE TABLE Student(
		ID   NUMBER(11) PRIMARY KEY,
		NAME VARCHAR2(20) NOT NULL,
		AGE  NUMBER(11) NOT NULL
		);
		CREATE TABLE Marks(
		SID   NUMBER(11) PRIMARY KEY References Student(id),
		MARKS NUMBER(11) NOT NULL,
		YEAR  NUMBER(11) NOT NULL
		);
	 */
	public static void main(String[] args) {
		/*编程式*/
		ApplicationContext context = new ClassPathXmlApplicationContext("TransactionBeans1.xml");

		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context
				.getBean("studentJDBCTemplate");
		System.out.println("------Records creation--------");
		studentJDBCTemplate.create(1, "Zara", 11, 99, 2010);
		studentJDBCTemplate.create(2, "Nuha", 20, 97, 2010);
		studentJDBCTemplate.create(3, "Ayan", 25, 100, 2011);
		System.out.println("------Listing all the records--------");
		List<StudentMarks> studentMarks = studentJDBCTemplate.listStudents();
		for (StudentMarks record : studentMarks) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.print(", Marks : " + record.getMarks());
			System.out.print(", Year : " + record.getYear());
			System.out.println(", Age : " + record.getAge());
		}
	}
}
