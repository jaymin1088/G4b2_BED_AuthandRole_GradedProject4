package com.glearning.emps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employee API", contact = @Contact(email = "admin@company.com")))

public class EmpCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpCrudApplication.class, args);
	}
}
