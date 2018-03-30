package com.ioc.getBean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.helloworld.HelloWorld;

public class MainApp {

	public static void main(String[] args) {
//		getBean1();
//		getBean2();
//		getBean3();
//		getBean4();
		getBean5();
	}

	/**
	 * ApplicationContext 包含 BeanFactory 所有的功能，
	 * 一般情况下，相对于 BeanFactory，ApplicationContext 会被推荐使用。
	 * BeanFactory 仍然可以在轻量级应用中使用，比如移动设备或者基于 applet 的应用程序。
	 */
	//通过BeanFactory获取
	private static void getBean1() {
		BeanFactory factory=new DefaultListableBeanFactory();    
		new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory)
			.loadBeanDefinitions(new ClassPathResource("Beans.xml"));   
		HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
		obj.getMessage();
	}
	//通过ApplicationContext获取
	private static void getBean2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
	}
	//需要提供XML文件的完整路径
	private static void getBean3() {
	      ApplicationContext context = new FileSystemXmlApplicationContext
	              ("D:/Software/Workspaces/JavaWeb/HelloSpring/src/Beans.xml");
	        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
	        obj.getMessage();
	}
	//使用XmlWebApplicationContext在web应用程序的范围内加载XML文件
	private static void getBean4() {
		//等到springmvc时讲
	}
	
	/**
	 * 配置文件中bean的作用域属性,通过scope属性指定
		作用域			描述
		singleton		该作用域将 bean 的定义的限制在每一个 Spring IoC 容器中的一个单一实例(默认)。
		prototype		该作用域将单一 bean 的定义限制在任意数量的对象实例。
		request			该作用域将 bean 的定义限制为 HTTP 请求。只在 web上下文中有效。
		session			该作用域将 bean 的定义限制为 HTTP 会话。 只在 web上下文中有效。
		global-session	该作用域将 bean 的定义限制为全局 HTTP 会话。只在 web上下文中有效。
	 */
	
	/**
	 * Spring Bean 生命周期
	 * (1)不管是context还是factory都要用抽象类调用方法.
	 * (2)如AbstractApplicationContext的registerShutdownHook()方法
	 * 或者  AbstractBeanFactory的destroyBean(String arg0, Object arg1)方法
	 * (3) 需要在Beans.xml中用init-method (初始化)和 destroy-method (销毁) 注册.
	 */
	private static void getBean5() {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
		/*方法一*/
		context.registerShutdownHook();
		
		/*方法二
		AbstractBeanFactory factory=(AbstractBeanFactory) context.getBeanFactory();
		factory.destroyBean("helloWorld", obj);
		*/
	}
}
