package com.web.s3;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Factory method 'stackResourceRegistryFactoryBean' threw exception; nested exception is java.lang.IllegalArgumentException: No valid instance id defined
 * 
 * autoConfiguration 을 위한 적절한 properties를 제공안해줘서 그렇다고 한다,,
 * properties 에  secret-key랑 access-key 이름이 잘못설정되어있었음
 * 이 문제 아니었음, @Configuration 클래스 만들어서 세팅해줬으나, 좋은방법 아닌거 같다
 */

@SpringBootApplication
public class SimpleS3FileUploadApplication {
	
	public static final String APPLICATION_PROPERTIES = "spring.config.location="
			+ "classpath:application.properties,"
			+ "classpath:aws.properties";

	public static void main(String[] args) {
		new SpringApplicationBuilder(SimpleS3FileUploadApplication.class)
		.properties(APPLICATION_PROPERTIES)
		.run(args);
	}
}