package com.ioc.DI.annotation.JSR250;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	/**
	 * 注解默认情况下不打开,需要在xml中配置<context:annotation-config/>
	 * @PostConstruct 相当于在xml中配置 init-method  
	 * @PreDestroy 相当于在xml中配置 destroy-method 
	 * @Resource 相当于@Autowired 不过只能用于属性和set方法,不能用于构造函数,且是按by-name方式自动连接
	 */
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"DIannotationBeans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
		obj.getSpellChecker().checkSpelling();
		context.registerShutdownHook();
	}

}
