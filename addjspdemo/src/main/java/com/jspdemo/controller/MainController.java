package com.jspdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MainController 
{
	@RequestMapping("/home")
	public String home() 
	{
		System.out.println("This is my home page");
		return "home";
		
	}

}
