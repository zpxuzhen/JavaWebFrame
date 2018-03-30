package com.ioc.DI.annotation.Qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	/**
	 * ע��Ĭ������²���,��Ҫ��xml������<context:annotation-config/>
	 * @Qualifier �൱byName,�ֶ�ָ��ʹ����һ������,���ж����ͬ���͵�����ʱ.
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
