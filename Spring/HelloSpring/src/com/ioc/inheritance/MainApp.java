package com.ioc.inheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helloworld.HelloIndia;

public class MainApp {

	/**
	 * Spring Bean ����ļ̳��� Java ��ļ̳��޹أ����Ǽ̳еĸ�����һ���ġ�
	 * ����Զ���һ���� bean �Ķ�����Ϊģ��������� bean �Ϳ��ԴӸ� bean �м̳���������á�
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloIndia obj = (HelloIndia) context.getBean("helloIndia");
		obj.getMessage1();
		obj.getMessage2();
		obj.getMessage3();
	}

}
