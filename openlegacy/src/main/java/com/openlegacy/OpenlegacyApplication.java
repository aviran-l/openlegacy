package com.openlegacy;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class OpenlegacyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenlegacyApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.openlegacy"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		
		return new ApiInfo(
				"Inventory Database API",
				"API is part of a begginer Java developer exercise",
				"1.0",
				"Free for use",
				new springfox.documentation.service.Contact("Aviran Lavy", "http://www.openlegacy.com/", "aviran@openlegacy.com"),
				"API License",
				"http://www.openlegacy.com/",
				Collections.emptyList()
				);
	}

}
