package com.ioc.DI.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {
	
	/**
	 * ע��Ĭ������²���,��Ҫ��xml������<context:annotation-config/>
	 * @Autowired  ������set����,����,���캯�� .
	 * �������ַ�ʽ �����Զ�ȥxml�а�byType��bean,����ж��,��ᰴbyName��,������Ҳ����ͱ���
	 * Ĭ�������@Autowired �������Ǳ����,����ʹ��@Autowired(required=false)ѡ��ر�Ĭ����Ϊ
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("DIannotationBeans.xml");
	    TextEditor te = (TextEditor) context.getBean("textEditor");
	    te.spellCheck();
	}

}
