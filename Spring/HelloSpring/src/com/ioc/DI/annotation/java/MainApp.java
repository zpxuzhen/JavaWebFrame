package com.ioc.DI.annotation.java;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	/**
	 * ���� Java ������
	 * 
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		//ʾ��1
		ctx.register(HelloWorldConfig.class);
		//ʾ��2
		ctx.register(TextEditorConfig.class);
		//ֻ��ִ��һ��,���ֱ�Ӱ�XXXConfig.classд��new��,���Զ�����refresh(),���Բ�����register()��
		ctx.refresh();
		
		HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		helloWorld.setMessage("Hello World!");
		helloWorld.getMessage();
		
		TextEditor te = ctx.getBean(TextEditor.class);
		te.spellCheck();
	}
	
	/**
	 * @import ע���������һ���������м��� @Bean ����,����:
	 *  @Configuration
		public class ConfigA {
		   @Bean
		   public A a() {
		      return new A(); 
		   }
		}
	 * 
	 * @Configuration
		@Import(ConfigA.class)
		public class ConfigB {
		   @Bean
		   public B a() {
		      return new A(); 
		   }
		}
	 *
	 *����,��ʵ����������ʱ,����Ҫͬʱָ�� ConfigA.class �� ConfigB.class,ֻ�� ConfigB ����Ҫ�ṩ
	 *public static void main(String[] args) {
		   ApplicationContext ctx = 
		   new AnnotationConfigApplicationContext(ConfigB.class);
		   // now both beans A and B will be available...
		   A a = ctx.getBean(A.class);
		   B b = ctx.getBean(B.class);
	  }
	 *
	 */
	/**
	 * �������ڻص�
	 * ������XXXConfig.java��ʹ��
	 * @Bean(initMethod = "init", destroyMethod = "destroy" )
	 * Ҳ���Լ�����֮ǰ�İ취��XXX���init������destroy������ʹ��
	 * @PostConstruct  @PreDestroy
	 * 
	 */
	/**
	 * Bean �ķ�Χ
	 * Ĭ�Ϸ�Χ�ǵ�ʵ��,�����������д���� @Scope ע��ķ���,����:
	 * @Configuration
		public class AppConfig {
		   @Bean
		   @Scope("prototype")
		   public Foo foo() {
		      return new Foo();
		   }
		}
	 * 
	 */

}
