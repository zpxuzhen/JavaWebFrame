package com.ioc.DI.annotation.Required;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {
	
	/**
	 * ע��Ĭ������²���,��Ҫ��xml������<context:annotation-config/>
	 * @Required ����bean���Ե�set����,ǿ�ƴ����Ա�����xml������
	 * 
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("DIannotationBeans.xml");
	    Student requiredStudent = (Student) context.getBean("requiredStudent");
	    System.out.println("Name : " + requiredStudent.getName() );
	    System.out.println("Age : " + requiredStudent.getAge() );

	}

}
