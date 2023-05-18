package com.blog.services.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.Category;
import com.blog.exception.ResourceNotFoundException;
import com.blog.payloads.CategoryDto;
import com.blog.repositories.CategoryRepo;
import com.blog.services.CategoryService;

@Service
public  class CategoryServiceimpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) 
	{
		Category category=this.dtoToCategory(categoryDto);
		Category savedCategory=categoryRepo.save(category);
		return this.CategoryToDto(savedCategory);
	}

	@Override
	public List<CategoryDto> getAllCategory() 
	{
		List<Category> categorys=this.categoryRepo.findAll();
		List<CategoryDto> categoryDtos=categorys.stream().map(category -> this.CategoryToDto(category)).collect(Collectors.toList());
		return categoryDtos;
	}

	@Override
	public CategoryDto getById(Integer categoryId) {
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", categoryId));
		return this.CategoryToDto(category);
	}

	@Override
	public void deleteByid(Integer categoryId) {
		Category  category=this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));
		this.categoryRepo.delete(category);
		
	
	}

	@Override
	public CategoryDto updateById(CategoryDto categoryDto, Integer categoryId) {
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedcategory=this.categoryRepo.save(category);
		CategoryDto categorydto =this.CategoryToDto(updatedcategory);
		return categorydto;

	}
	
	//dto to category conversion
	public Category dtoToCategory(CategoryDto categoryDto)
	{
		Category category=this.modelMapper.map(categoryDto,Category.class);
		return category;
	}
	//category to dto conversion
	
	public CategoryDto CategoryToDto(Category category)
	{
		CategoryDto categorydto=this.modelMapper.map(category,CategoryDto.class);
		return categorydto;
	}
	
	
	
	
	

}
