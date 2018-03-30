package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	/**
	 * �� OOP ��,�ؼ���Ԫģ�������,���� AOP �е�Ԫģ����Ƿ��档
	 * ����ע��������Ӧ�ó�������໥����,
	 * AOP ���԰������������Ӱ��Ķ����жԺ��й�ע����
	 * 
	 * ��һ��Ӧ�ó���Ķ����Ĺ��ܱ���Ϊ���й�ע��,
	 * ��Щ���й�ע���ڸ����϶�����Ӧ�ó����ҵ���߼���
	 * �и��ָ����ĳ����ĺܺõķ��������,
	 * ����־��¼����ơ�����ʽ���񡢰�ȫ�Ժͻ���ȡ�
	 * 
	 * Spring AOP ģ���ṩ������������һ��Ӧ�ó���,
	 * ����,��ִ��һ������ʱ,������ڷ���ִ��֮ǰ��֮����Ӷ���Ĺ��ܡ�
	 * 
	 * ֪ͨ������
		Spring �������ʹ�������ᵽ������֪ͨ����:
		֪ͨ				����
		ǰ��֪ͨ			��һ������ִ��֮ǰ,ִ��֪ͨ��
		����֪ͨ			��һ������ִ��֮��,����������,ִ��֪ͨ��
		���غ�֪ͨ		��һ������ִ��֮��,ֻ���ڷ����ɹ����ʱ,����ִ��֪ͨ��
		�׳��쳣��֪ͨ	��һ������ִ��֮��,ֻ���ڷ����˳��׳��쳣ʱ,����ִ��֪ͨ��
		����֪ͨ			�ڽ��鷽������֮ǰ��֮��,ִ��֪ͨ��
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("AopBeans.xml");
		Student student = (Student) context.getBean("student");
		student.getName();
		student.getAge();
		student.printThrowException();	
	}
	/**
	 * AOP�����Ҫ��������  aspectj.jar �е�lib������jar
	 */
	
}
