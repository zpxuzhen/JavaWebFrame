package com.ioc.DI.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {
	
	/**
	 * 注解默认情况下不打开,需要在xml中配置<context:annotation-config/>
	 * @Autowired  可以在set方法,属性,构造函数 .
	 * 不管哪种方式 都会自动去xml中按byType找bean,如果有多个,则会按byName找,如果再找不到就报错
	 * 默认情况下@Autowired 的依赖是必须的,可以使用@Autowired(required=false)选项关闭默认行为
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("DIannotationBeans.xml");
	    TextEditor te = (TextEditor) context.getBean("textEditor");
	    te.spellCheck();
	}

}
