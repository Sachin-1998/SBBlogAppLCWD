package com.blog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.blog.entities.User;
import com.blog.payloads.UserDto;
import com.blog.repositories.UserRepository;
import com.blog.services.impl.UserServiceImpl;

public class TestUserRestApis 
{
	@Mock
	private UserRepository userRepoMock;
	@InjectMocks
	private  UserServiceImpl service;
	
		
	public TestUserRestApis()
	{
		MockitoAnnotations.openMocks(this);
	}
	
}
