package com.glearning.emps.exception;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandlerController implements ErrorController{
	@GetMapping("/error")
	public String customError() {
		return "Welcome Rest API Home Page Go to  Enter /api/employees in above URL REST API display in Browser.";
	}

	
	public String getErrorPath() {
		return "/error";
	}

}
