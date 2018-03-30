package com.ioc.inheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helloworld.HelloIndia;

public class MainApp {

	/**
	 * Spring Bean 定义的继承与 Java 类的继承无关，但是继承的概念是一样的。
	 * 你可以定义一个父 bean 的定义作为模板和其他子 bean 就可以从父 bean 中继承所需的配置。
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloIndia obj = (HelloIndia) context.getBean("helloIndia");
		obj.getMessage1();
		obj.getMessage2();
		obj.getMessage3();
	}

}
