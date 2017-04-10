package com.sample.dong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.any())
		.paths(PathSelectors.any())
		.build()
		.apiInfo(infoData());
	}
	
	private ApiInfo infoData() {
	ApiInfo apiInfo = new ApiInfo(
		"User Simple API", 
		"Using MariaDB, Document by Swagger 2", 
		"1.0", 
		"Term of Service", 
		new Contact("Dong", "https://abc.com", "dong@gmail.com"), 
		"Free license", 
		"https://free.com");
	return apiInfo;
	}
}
