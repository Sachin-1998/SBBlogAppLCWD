package com.blog.security;

public class JwtAuthResponse 
{
	private String jwt;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public JwtAuthResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public JwtAuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
