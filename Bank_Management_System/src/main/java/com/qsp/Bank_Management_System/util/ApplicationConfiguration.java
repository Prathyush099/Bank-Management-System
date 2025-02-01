package com.qsp.Bank_Management_System.util;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class ApplicationConfiguration {
	
	    @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	                .components(new Components())
	                .info(new Info()
	                        .title("Bank Management System")
	                        .description("Banking management system is a project for online and offline purpose. "
	                                + "This system allows users to browse Accounts, transfer money, and choose different loan. "
	                                + "It helps streamline the process of transaction with various banks, within the account , "
	                                + "manage the online transaction status.")
	                        .version("1.0")
	                        .contact(new Contact()
	                                .name("Prathyush Kotapati")
	                                .email("mr.prathyush694@gmail.com"))
	                        .license(new License().name("License").url("#")));
	    }

		@Bean
		public GroupedOpenApi publicApi() {
			return GroupedOpenApi.builder().group("public").
					packagesToScan("com.qsp.Bank_Management_System").build();
		}
	}
