package com.ioc.DI.annotation.JSR250;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	/**
	 * ע��Ĭ������²���,��Ҫ��xml������<context:annotation-config/>
	 * @PostConstruct �൱����xml������ init-method  
	 * @PreDestroy �൱����xml������ destroy-method 
	 * @Resource �൱��@Autowired ����ֻ���������Ժ�set����,�������ڹ��캯��,���ǰ�by-name��ʽ�Զ�����
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
