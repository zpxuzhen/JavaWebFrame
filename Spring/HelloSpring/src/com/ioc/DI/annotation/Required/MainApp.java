package com.ioc.DI.annotation.Required;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {
	
	/**
	 * 注解默认情况下不打开,需要在xml中配置<context:annotation-config/>
	 * @Required 用在bean属性的set方法,强制此属性必须在xml中配置
	 * 
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("DIannotationBeans.xml");
	    Student requiredStudent = (Student) context.getBean("requiredStudent");
	    System.out.println("Name : " + requiredStudent.getName() );
	    System.out.println("Age : " + requiredStudent.getAge() );

	}

}
