package com.blog.controllers;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.ApiResponse;
import com.blog.payloads.UserDto;
import com.blog.services.impl.UserServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/users")
public class UserController 
{
	@Autowired
	private UserServiceImpl userServiceImpl;
	//call create user method
	@ApiOperation("Add Users")
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser( @Valid @RequestBody UserDto userdto)
	{
		UserDto createdUser=this.userServiceImpl.createUser(userdto);
		return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
	}
	@ApiOperation("Get All Users")
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser()
	{
		List<UserDto> list=this.userServiceImpl.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	@ApiOperation("Get User Using UserId")
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId)
	{
		UserDto getSingleUser=this.userServiceImpl.getById(userId);
		return  new ResponseEntity<UserDto>(getSingleUser,HttpStatus.OK);
	}
	@ApiOperation("Update User Using UserId")
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateThroughId( @Valid @RequestBody UserDto userdto, @PathVariable Integer userId)
	{
		UserDto upadteUser=this.userServiceImpl.updateById(userdto, userId);
		return ResponseEntity.status(HttpStatus.OK).body(upadteUser);
	}
	//role Admin
	@PreAuthorize("hasRole('ADMIN')")
//	@Secured("ROLE_ADMIN") 
	@ApiOperation("Delete User Using UserId")
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteById(@PathVariable Integer userId)
	{
		this.userServiceImpl.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
	}
	
	

}
