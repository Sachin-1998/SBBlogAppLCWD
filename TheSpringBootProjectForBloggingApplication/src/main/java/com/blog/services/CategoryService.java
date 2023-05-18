package com.blog.services;

import java.util.List;

import com.blog.payloads.CategoryDto;

public interface CategoryService
{
	//get category
	
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//get all category
	
	List<CategoryDto> getAllCategory();
	
	//get category by id
	
	CategoryDto getById(Integer categoryId);
	
	//delete by id
	
	void deleteByid(Integer categoryId);
	
	//update by id
	
	CategoryDto updateById(CategoryDto categoryDto,Integer categoryId);

}
