package com.ioc.DI.annotation.Qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	/**
	 * 注解默认情况下不打开,需要在xml中配置<context:annotation-config/>
	 * @Qualifier 相当byName,手动指定使用哪一个依赖,当有多个相同类型的依赖时.
	 * 
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"DIannotationBeans.xml");
		Profile profile = (Profile) context.getBean("profile");
		profile.printAge();
		profile.printName();
	}

}
