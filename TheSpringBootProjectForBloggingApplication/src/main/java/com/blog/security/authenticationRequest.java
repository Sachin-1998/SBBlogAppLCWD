package com.blog.security;

import javax.validation.constraints.NotBlank;

public class authenticationRequest 
{
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	public authenticationRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public authenticationRequest() {
		super();
	}
    public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
