package com.ioc.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {

	/**
	 * 基于构造函数的依赖注入
	 * 获取ApplicationContext的时候就会执行所有的构造函数.
	 * 但是用依赖注入的方式,构造函数的重载不能体现了,需要指定不同的Bean的id 
	 * 传递构造函数参数的方式:必须顺序一致/普通类型可以指定type/最好用index属性/引用类型用ref属性
	 * 
	 */
	/**
	 * 基于设值函数的依赖注入
	 * 1.必须实现相应的set方法和无参构造函数
	 * 2.配置xml时,可以用property或者 p-namespace方式,例如:
	 * 	<bean name="jane" class="com.example.Person">
      		<property name="name" value="John Doe"/>
      		<property name="spouse" ref="jane"/>
   		</bean>
   		<bean name="jane" class="com.example.Person"
      		p:name="John Doe"/>
      		p:spouse-ref="jane"/>
   		</bean>
   	 * 其中-ref代表这是个引用 ,代码在DIBeans.xml的 bean id="textEditor4",可以自行实验
	 */
	/**
	 * 注入内部 Beans:在其他 bean 的范围内定义的 bean,例如:
	 *    <bean id="outerBean" class="...">
      		<property name="target">
         		<bean id="innerBean" class="..."/>
      		</property>
      	  </bean>
	 * 
	 */
	/**
	 * 注入集合
	 * Spring 提供了四种类型的集合的配置元素，如下所示：
		元素	描述
		<list>	它有助于连线，如注入一列值，允许重复。
		<set>	它有助于连线一组值，但不能重复。(见DIBeans.xml)
		<map>	它可以用来注入名称-值对的集合，其中名称和值可以是任何类型。
		<props>	它可以用来注入名称-值对的集合，其中名称和值都是字符串类型。
	 *  在DIBeans.xml中  普通值<value>xxxx</value> 引用<ref bean="xxx"/>
	 */
	/**
	 * 空字符串""
	 * null值<null/>
	 * 例如在map集合中我们这样使用:
	 *      <entry key="5"><null/></entry>
	 *      <entry key="6" value=""/>
	 */
	/**
	 * 自动装配, 使用<bean>元素的 autowire 属性为一个 bean 定义指定自动装配模式。
		模式	描述
		no				这是默认的设置，它意味着没有自动装配，你应该使用显式的bean引用来连线。
					你不用为了连线做特殊的事。在依赖注入章节你已经看到这个了。
		byName			由属性名自动装配。
					Spring 容器看到在 XML 配置文件中 bean 的自动装配的属性设置为 byName。
					然后尝试匹配，并且将它的属性与在配置文件中被定义为相同名称的 beans 的属性进行连接。
		byType			由属性数据类型自动装配。
					Spring 容器看到在 XML 配置文件中 bean 的自动装配的属性设置为 byType。
					然后如果它的类型匹配配置文件中的一个确切的 bean 名称，它将尝试匹配和连接属性的类型。
					如果存在不止一个这样的 bean，则一个致命的异常将会被抛出。
		constructor		类似于 byType，但该类型适用于构造函数参数类型。
					如果在容器中没有一个构造函数参数类型的 bean，则一个致命错误将会发生。
		autodetect		Spring首先尝试通过 constructor 使用自动装配来连接，如果它不执行，
					Spring 尝试通过 byType 来自动装配。
	 * 
	 * 自动装配的局限性
		限制	描述
		重写的可能性		你可以使用总是重写自动装配的 <constructor-arg>和 <property> 设置来指定依赖关系。
		原始数据类型		你不能自动装配所谓的简单类型包括基本类型，字符串和类。
		混乱的本质		自动装配不如显式装配精确，所以如果可能的话尽可能使用显式装配。
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("DIBeans.xml");
		/*
		TextEditor te = (TextEditor) context.getBean("textEditor");
	    te.spellCheck();
		*/
	    
	    /*注入集合示例*/
		/*
	      JavaCollection jc=(JavaCollection)context.getBean("javaCollection");
	      jc.getAddressList();
	      jc.getAddressSet();
	      jc.getAddressMap();
	      jc.getAddressProp();
	    */
	    
	    /*自动装配示例*/ 
		/*
		//匹配属性名和bean id完全一致的,区分大小写
		TextEditor byName = (TextEditor) context.getBean("textEditor5");
		byName.spellCheck();
		//匹配属性类型和bean class完全一致的,有多个bean的class相同会报错,需要手动装配.
		TextEditor byType = (TextEditor) context.getBean("textEditor6");
		byType.spellCheck();
		//匹配构造函数参数,尽量显示装配,自动装配容易造成混乱.
		TextEditor constructor = (TextEditor) context.getBean("textEditor7");
		constructor.spellCheck();
		*/
	}

}
