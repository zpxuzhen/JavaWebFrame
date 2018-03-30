package com.aop.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	/**
	 * AOP��̵�javaע�ⷽʽ
	 * ��Ҫ��xml�м���<aop:aspectj-autoproxy />
	 * 
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("AopJavaBeans.xml");
		Student student = (Student) context.getBean("student");
		student.getName();
		student.getAge();
		student.printThrowException();	
	}
	/**
	 * AOP�����Ҫ��������  aspectj.jar �е�lib������jar
	 */
	
}
