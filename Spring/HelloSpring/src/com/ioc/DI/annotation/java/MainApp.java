package com.ioc.DI.annotation.java;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	/**
	 * 基于 Java 的配置
	 * 
	 */
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		//示例1
		ctx.register(HelloWorldConfig.class);
		//示例2
		ctx.register(TextEditorConfig.class);
		//只能执行一次,如果直接把XXXConfig.class写在new里,会自动调用refresh(),所以不能再register()了
		ctx.refresh();
		
		HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		helloWorld.setMessage("Hello World!");
		helloWorld.getMessage();
		
		TextEditor te = ctx.getBean(TextEditor.class);
		te.spellCheck();
	}
	
	/**
	 * @import 注解允许从另一个配置类中加载 @Bean 定义,例如:
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
	 *现在,当实例化上下文时,不需要同时指定 ConfigA.class 和 ConfigB.class,只有 ConfigB 类需要提供
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
	 * 生命周期回调
	 * 可以在XXXConfig.java中使用
	 * @Bean(initMethod = "init", destroyMethod = "destroy" )
	 * 也可以继续用之前的办法在XXX类的init方法和destroy方法中使用
	 * @PostConstruct  @PreDestroy
	 * 
	 */
	/**
	 * Bean 的范围
	 * 默认范围是单实例,但是你可以重写带有 @Scope 注解的方法,例如:
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
