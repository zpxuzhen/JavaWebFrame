package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	/**
	 * 在 OOP 中,关键单元模块度是类,而在 AOP 中单元模块度是方面。
	 * 依赖注入帮助你对应用程序对象相互解耦,
	 * AOP 可以帮助你从它们所影响的对象中对横切关注点解耦。
	 * 
	 * 跨一个应用程序的多个点的功能被称为横切关注点,
	 * 这些横切关注点在概念上独立于应用程序的业务逻辑。
	 * 有各种各样的常见的很好的方面的例子,
	 * 如日志记录、审计、声明式事务、安全性和缓存等。
	 * 
	 * Spring AOP 模块提供拦截器来拦截一个应用程序,
	 * 例如,当执行一个方法时,你可以在方法执行之前或之后添加额外的功能。
	 * 
	 * 通知的类型
		Spring 方面可以使用下面提到的五种通知工作:
		通知				描述
		前置通知			在一个方法执行之前,执行通知。
		后置通知			在一个方法执行之后,不考虑其结果,执行通知。
		返回后通知		在一个方法执行之后,只有在方法成功完成时,才能执行通知。
		抛出异常后通知	在一个方法执行之后,只有在方法退出抛出异常时,才能执行通知。
		环绕通知			在建议方法调用之前和之后,执行通知。
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("AopBeans.xml");
		Student student = (Student) context.getBean("student");
		student.getName();
		student.getAge();
		student.printThrowException();	
	}
	/**
	 * AOP编程需要第三方库  aspectj.jar 中的lib中所有jar
	 */
	
}
