package com.ioc.beanPostProcessor;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.BeansException;

public class InitHelloWorld implements BeanPostProcessor {
   public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
      System.out.println("BeforeInitialization : " + beanName);
      return bean;  // you can return any other object as well
   }
   public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
      System.out.println("AfterInitialization : " + beanName);
      return bean;  // you can return any other object as well
   }
}

/**
 * ApplicationContext ���Զ������ BeanPostProcessor �ӿڵ�ʵ�ֶ���� bean��
 * ע����Щ bean Ϊ���ô�������Ȼ��ͨ���������д��� bean�����ʵ���ʱ���������
 * 
 * ��������ApplicationContext��ʱ��,�ֱ���ÿ��bean��init����ǰ�����.
 * ��������bean��ִ�н������:
 *  BeforeInitialization : helloWorld
	Bean is going through init.
	AfterInitialization : helloWorld
	
	BeforeInitialization : helloWorld1
	Bean is going through init.
	AfterInitialization : helloWorld1
 */
