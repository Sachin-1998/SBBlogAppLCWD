package com.blog.payloads;

import javax.validation.constraints.NotBlank;

public class RoleDto
{
	private int id;
	@NotBlank
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RoleDto(int id, @NotBlank String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public RoleDto() {
		super();
		
	}
	
	

}
