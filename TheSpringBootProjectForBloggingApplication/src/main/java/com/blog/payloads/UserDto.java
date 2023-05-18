package com.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "Details About The User.")
public class UserDto {

	@ApiModelProperty(notes = "The Unique Id Of User..")
	private int id;
	@Size(min = 3, max = 20, message = "The characters must be between 3 to 20 !!")
	@NotBlank(message = "the name should not be empty")
	@ApiModelProperty(name="This is Name Of User")
	private String name;
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid Mail Id ? Please enter the valid mail Id..")
	private String email;
	@Size(min = 9, max = 15, message = "Password must be in between 9 to 15 Characters")
	private String password;
	@NotBlank
	private String about;
	private Set<RoleDto> roles = new HashSet<>();

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Set<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleDto> roles) {
		this.roles = roles;
	}

	public UserDto(int id,
			@Size(min = 3, max = 20, message = "The characters must be between 3 to 20 !!") @NotBlank(message = "the name should not be empty") String name,
			@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid Mail Id ? Please enter the valid mail Id..") String email,
			@Size(min = 9, max = 15, message = "Password must be in between 9 to 15 Characters") String password,
			@NotBlank String about, Set<RoleDto> roles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
		this.roles = roles;
	}
	

	

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
