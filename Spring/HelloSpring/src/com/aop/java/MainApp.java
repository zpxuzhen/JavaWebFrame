package com.aop.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	/**
	 * AOP编程的java注解方式
	 * 需要在xml中加入<aop:aspectj-autoproxy />
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
	 * AOP编程需要第三方库  aspectj.jar 中的lib中所有jar
	 */
	
}
