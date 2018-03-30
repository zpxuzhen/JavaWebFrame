package com.ioc.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {

	/**
	 * ���ڹ��캯��������ע��
	 * ��ȡApplicationContext��ʱ��ͻ�ִ�����еĹ��캯��.
	 * ����������ע��ķ�ʽ,���캯�������ز���������,��Ҫָ����ͬ��Bean��id 
	 * ���ݹ��캯�������ķ�ʽ:����˳��һ��/��ͨ���Ϳ���ָ��type/�����index����/����������ref����
	 * 
	 */
	/**
	 * ������ֵ����������ע��
	 * 1.����ʵ����Ӧ��set�������޲ι��캯��
	 * 2.����xmlʱ,������property���� p-namespace��ʽ,����:
	 * 	<bean name="jane" class="com.example.Person">
      		<property name="name" value="John Doe"/>
      		<property name="spouse" ref="jane"/>
   		</bean>
   		<bean name="jane" class="com.example.Person"
      		p:name="John Doe"/>
      		p:spouse-ref="jane"/>
   		</bean>
   	 * ����-ref�������Ǹ����� ,������DIBeans.xml�� bean id="textEditor4",��������ʵ��
	 */
	/**
	 * ע���ڲ� Beans:������ bean �ķ�Χ�ڶ���� bean,����:
	 *    <bean id="outerBean" class="...">
      		<property name="target">
         		<bean id="innerBean" class="..."/>
      		</property>
      	  </bean>
	 * 
	 */
	/**
	 * ע�뼯��
	 * Spring �ṩ���������͵ļ��ϵ�����Ԫ�أ�������ʾ��
		Ԫ��	����
		<list>	�����������ߣ���ע��һ��ֵ�������ظ���
		<set>	������������һ��ֵ���������ظ���(��DIBeans.xml)
		<map>	����������ע������-ֵ�Եļ��ϣ��������ƺ�ֵ�������κ����͡�
		<props>	����������ע������-ֵ�Եļ��ϣ��������ƺ�ֵ�����ַ������͡�
	 *  ��DIBeans.xml��  ��ֵͨ<value>xxxx</value> ����<ref bean="xxx"/>
	 */
	/**
	 * ���ַ���""
	 * nullֵ<null/>
	 * ������map��������������ʹ��:
	 *      <entry key="5"><null/></entry>
	 *      <entry key="6" value=""/>
	 */
	/**
	 * �Զ�װ��, ʹ��<bean>Ԫ�ص� autowire ����Ϊһ�� bean ����ָ���Զ�װ��ģʽ��
		ģʽ	����
		no				����Ĭ�ϵ����ã�����ζ��û���Զ�װ�䣬��Ӧ��ʹ����ʽ��bean���������ߡ�
					�㲻��Ϊ��������������¡�������ע���½����Ѿ���������ˡ�
		byName			���������Զ�װ�䡣
					Spring ���������� XML �����ļ��� bean ���Զ�װ�����������Ϊ byName��
					Ȼ����ƥ�䣬���ҽ������������������ļ��б�����Ϊ��ͬ���Ƶ� beans �����Խ������ӡ�
		byType			���������������Զ�װ�䡣
					Spring ���������� XML �����ļ��� bean ���Զ�װ�����������Ϊ byType��
					Ȼ�������������ƥ�������ļ��е�һ��ȷ�е� bean ���ƣ���������ƥ����������Ե����͡�
					������ڲ�ֹһ�������� bean����һ���������쳣���ᱻ�׳���
		constructor		������ byType���������������ڹ��캯���������͡�
					�����������û��һ�����캯���������͵� bean����һ���������󽫻ᷢ����
		autodetect		Spring���ȳ���ͨ�� constructor ʹ���Զ�װ�������ӣ��������ִ�У�
					Spring ����ͨ�� byType ���Զ�װ�䡣
	 * 
	 * �Զ�װ��ľ�����
		����	����
		��д�Ŀ�����		�����ʹ��������д�Զ�װ��� <constructor-arg>�� <property> ������ָ��������ϵ��
		ԭʼ��������		�㲻���Զ�װ����ν�ļ����Ͱ����������ͣ��ַ������ࡣ
		���ҵı���		�Զ�װ�䲻����ʽװ�侫ȷ������������ܵĻ�������ʹ����ʽװ�䡣
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("DIBeans.xml");
		/*
		TextEditor te = (TextEditor) context.getBean("textEditor");
	    te.spellCheck();
		*/
	    
	    /*ע�뼯��ʾ��*/
		/*
	      JavaCollection jc=(JavaCollection)context.getBean("javaCollection");
	      jc.getAddressList();
	      jc.getAddressSet();
	      jc.getAddressMap();
	      jc.getAddressProp();
	    */
	    
	    /*�Զ�װ��ʾ��*/ 
		/*
		//ƥ����������bean id��ȫһ�µ�,���ִ�Сд
		TextEditor byName = (TextEditor) context.getBean("textEditor5");
		byName.spellCheck();
		//ƥ���������ͺ�bean class��ȫһ�µ�,�ж��bean��class��ͬ�ᱨ��,��Ҫ�ֶ�װ��.
		TextEditor byType = (TextEditor) context.getBean("textEditor6");
		byType.spellCheck();
		//ƥ�乹�캯������,������ʾװ��,�Զ�װ��������ɻ���.
		TextEditor constructor = (TextEditor) context.getBean("textEditor7");
		constructor.spellCheck();
		*/
	}

}
