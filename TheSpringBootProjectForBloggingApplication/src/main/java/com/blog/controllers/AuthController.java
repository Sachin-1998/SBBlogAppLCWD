package com.blog.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.exception.ApiException;
import com.blog.payloads.UserDto;
import com.blog.security.CustomUserDetailsService;
import com.blog.security.JwtAuthResponse;
import com.blog.security.JwtTokenHelper;
import com.blog.security.authenticationRequest;
import com.blog.services.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/auth/")
public class AuthController 
{
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken( @Valid @RequestBody authenticationRequest request) 
	{
		this.authenticate(request.getUsername(),request.getPassword());
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(request.getUsername());
		String token = this.jwtTokenHelper.generateToken(userDetails);
		//Object claim = this.jwtTokenHelper.extractClaim(token, null);
		JwtAuthResponse response=new JwtAuthResponse();
		response.setJwt(token);
		return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
	}
	private void authenticate(String username, String password) {
		UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username, password);
		try {
			this.authenticationManager.authenticate(authenticationToken);
			
		} catch (BadCredentialsException e) 
		{
			System.out.println("Invalid password..");
			throw new ApiException("Invalid Password ..please try with correct password!!");
		}
	}
	
	//registered new user
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerNewUser(@RequestBody UserDto userDto)
	{
		UserDto registeredUser = this.userService.registerNewUser(userDto);
		
		return new ResponseEntity<UserDto>(registeredUser,HttpStatus.CREATED);
	}

}
