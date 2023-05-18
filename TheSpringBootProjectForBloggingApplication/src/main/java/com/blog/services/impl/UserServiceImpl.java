package com.blog.services.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.config.AppConstants;
import com.blog.entities.Role;
import com.blog.entities.User;
import com.blog.exception.ResourceNotFoundException;
import com.blog.payloads.UserDto;
import com.blog.repositories.RoleRepo;
import com.blog.repositories.UserRepository;
import com.blog.services.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user=this.dtoToUser(userDto);
		User savedUser=this.userRepository.save(user);
		return this.userToDto(savedUser);
	}
    
	@Override
	public UserDto getById(Integer userId) {
		User user=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		return this.userToDto(user);
	}


	@Override
	public UserDto updateById(UserDto userDto, Integer userId) {
		User user=this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updateduser=this.userRepository.save(user);
		UserDto userdto =this.userToDto(updateduser);
		return userdto;
	}


	@Override
	public List<UserDto> getAllUser() {
		List<User> users=this.userRepository.findAll();
		List<UserDto> userDtos=users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
		
	}


	@Override
	public void deleteUser(Integer userId) {
		User user=this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","Id", userId));
	    this.userRepository.delete(user);
		
	}
	
	@Override
	public UserDto registerNewUser(UserDto userDto) 
	{
		User user = this.modelmapper.map(userDto, User.class);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role role=this.roleRepo.findById(AppConstants.NORMAL_USER).get();
		user.getRoles().add(role);
		User newUser = this.userRepository.save(user);
		return this.modelmapper.map(newUser, UserDto.class);
	}
	
	//dto to user
	public User dtoToUser(UserDto userdto)
	{
		User user=this.modelmapper.map(userdto,User.class);
		
//		user.setId(userdto.getId());
//		user.setName(userdto.getName());
//		user.setEmail(userdto.getEmail());
//		user.setPassword(userdto.getPassword());
//		user.setAbout(userdto.getAbout());
		return user;
	}
	//user to dto
	public UserDto userToDto(User user)
	{
		UserDto userdto=this.modelmapper.map(user, UserDto.class);
		userdto.setId(user.getId());
		userdto.setName(user.getName());
		userdto.setEmail(user.getEmail());
		userdto.setPassword(user.getPassword());
		userdto.setAbout(user.getAbout());
		return userdto;
	}

	


		
	
	
}
