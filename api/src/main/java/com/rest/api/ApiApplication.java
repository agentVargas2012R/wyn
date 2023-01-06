package com.rest.api;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	public OpenAPI apiInfo() {
		return new OpenAPI().info(new Info().title("Controller REST API").version("1.0.0"));
	}

	@Bean
	public GroupedOpenApi httpApi() {
		return GroupedOpenApi.builder()
				.group("http")
				.pathsToMatch("/**")
				.build();
	}

}
