package com.validateapi;

import javax.validation.constraints.NotBlank;


import org.springframework.validation.annotation.Validated;

@Validated
public class Requestdata 
{
	@NotBlank(message="Your request is null!!!")
	private String request;

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}
	

}
