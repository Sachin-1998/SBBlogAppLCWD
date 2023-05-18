package com.validateapi;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Validated
public class JavaxValidationApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaxValidationApisApplication.class, args);
	}

	@PostMapping(value="/validate")
	public String getData(  @Valid  @RequestBody Requestdata data)
	{
		System.out.println("In method getData");
		return data.getRequest();
	}
	@PostMapping("/student")
	public Student getStudentDetails(@Valid @RequestBody Student s)
	{
		System.out.println("Inside student details method");
		
		return s;
		
	}
}
