package com.blog.services;

import java.util.List;

import com.blog.payloads.UserDto;

public interface UserService 
{
	UserDto registerNewUser(UserDto userDto);
	UserDto createUser(UserDto userDto);
	UserDto getById(Integer userId);
	UserDto updateById(UserDto userDto,Integer userId);
	List<UserDto> getAllUser();
	void deleteUser(Integer userId);

}
