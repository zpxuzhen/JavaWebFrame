package com.ioc.DI.annotation.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig {
	@Bean
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}
/**
 * ��ͬ��
 * 	<beans>
   		<bean id="helloWorld" class="com.ioc.DI.annotation.java.HelloWorld" />
	</beans>
 */
}
