package com.ioc.event;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	/**
	 * Spring �е��¼����� ���� Spring ���¼������ǵ��̵߳ģ��������һ���¼���������
	 * ֱ�����ҳ������еĽ����ߵõ��ĸ���Ϣ���ý��̱������������̽���������� 
	 * ��ˣ�����¼�����ʹ�ã������Ӧ�ó���ʱӦע�⡣
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("EventBeans.xml");
		// Let us raise a start event.
		context.start();
		
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();

		// Let us raise a stop event.
		context.stop();
	}
	/**
	 * Spring �����¼� & ����
		1	
		ContextRefreshedEvent
		ApplicationContext ����ʼ����ˢ��ʱ�����¼���������
		��Ҳ������ ConfigurableApplicationContext �ӿ���ʹ�� refresh() ������������
		2	
		ContextStartedEvent
		��ʹ�� ConfigurableApplicationContext �ӿ��е� start() �������� ApplicationContext ʱ�����¼���������
		����Ե���������ݿ⣬����������ڽ��ܵ�����¼��������κ�ֹͣ��Ӧ�ó���
		3	
		ContextStoppedEvent
		��ʹ�� ConfigurableApplicationContext �ӿ��е� stop() ����ֹͣ ApplicationContext ʱ����������¼���
		������ڽ��ܵ�����¼�������Ҫ������Ĺ�����
		4	
		ContextClosedEvent
		��ʹ�� ConfigurableApplicationContext �ӿ��е� close() �����ر� ApplicationContext ʱ�����¼���������
		һ���ѹرյ������ĵ�����������ĩ�ˣ������ܱ�ˢ�»�������
		5	
		RequestHandledEvent
		����һ�� web-specific �¼����������� bean HTTP �����Ѿ�������
	 */
}
