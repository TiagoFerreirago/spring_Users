package com.thlifestore.users.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("Restfull API Users with Java 18")
				.description("A RESTful API called 'users' provides user registration functionality")
				.version("v1")
				.termsOfService("http://users.com/api/v1/user/terms")
				.license(new License().name("Apache 2.0").url("http://users.com/api/v1/user"))
						);
	}
}
