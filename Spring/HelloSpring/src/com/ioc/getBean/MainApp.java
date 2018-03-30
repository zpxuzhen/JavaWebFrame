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
	 * ApplicationContext ���� BeanFactory ���еĹ��ܣ�
	 * һ������£������ BeanFactory��ApplicationContext �ᱻ�Ƽ�ʹ�á�
	 * BeanFactory ��Ȼ������������Ӧ����ʹ�ã������ƶ��豸���߻��� applet ��Ӧ�ó���
	 */
	//ͨ��BeanFactory��ȡ
	private static void getBean1() {
		BeanFactory factory=new DefaultListableBeanFactory();    
		new XmlBeanDefinitionReader((BeanDefinitionRegistry) factory)
			.loadBeanDefinitions(new ClassPathResource("Beans.xml"));   
		HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
		obj.getMessage();
	}
	//ͨ��ApplicationContext��ȡ
	private static void getBean2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
	}
	//��Ҫ�ṩXML�ļ�������·��
	private static void getBean3() {
	      ApplicationContext context = new FileSystemXmlApplicationContext
	              ("D:/Software/Workspaces/JavaWeb/HelloSpring/src/Beans.xml");
	        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
	        obj.getMessage();
	}
	//ʹ��XmlWebApplicationContext��webӦ�ó���ķ�Χ�ڼ���XML�ļ�
	private static void getBean4() {
		//�ȵ�springmvcʱ��
	}
	
	/**
	 * �����ļ���bean������������,ͨ��scope����ָ��
		������			����
		singleton		�������� bean �Ķ����������ÿһ�� Spring IoC �����е�һ����һʵ��(Ĭ��)��
		prototype		�������򽫵�һ bean �Ķ������������������Ķ���ʵ����
		request			�������� bean �Ķ�������Ϊ HTTP ����ֻ�� web����������Ч��
		session			�������� bean �Ķ�������Ϊ HTTP �Ự�� ֻ�� web����������Ч��
		global-session	�������� bean �Ķ�������Ϊȫ�� HTTP �Ự��ֻ�� web����������Ч��
	 */
	
	/**
	 * Spring Bean ��������
	 * (1)������context����factory��Ҫ�ó�������÷���.
	 * (2)��AbstractApplicationContext��registerShutdownHook()����
	 * ����  AbstractBeanFactory��destroyBean(String arg0, Object arg1)����
	 * (3) ��Ҫ��Beans.xml����init-method (��ʼ��)�� destroy-method (����) ע��.
	 */
	private static void getBean5() {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
		/*����һ*/
		context.registerShutdownHook();
		
		/*������
		AbstractBeanFactory factory=(AbstractBeanFactory) context.getBeanFactory();
		factory.destroyBean("helloWorld", obj);
		*/
	}
}
