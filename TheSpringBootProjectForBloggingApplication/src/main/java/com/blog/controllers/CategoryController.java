package com.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.ApiResponse;
import com.blog.payloads.CategoryDto;
import com.blog.services.impl.CategoryServiceimpl;

@RestController
@RequestMapping("/api/category")
public class CategoryController 
{
	@Autowired
	private CategoryServiceimpl categoryServiceimpl;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> addCategory( @Valid @RequestBody CategoryDto categoryDto)
	{
		CategoryDto getCategory=this.categoryServiceimpl.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(getCategory,HttpStatus.CREATED);
	}
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory()
	{
		List<CategoryDto> listOfCategory=this.categoryServiceimpl.getAllCategory();
		return ResponseEntity.status(HttpStatus.OK).body(listOfCategory);
	}
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> singleCategory(@PathVariable Integer categoryId)
	{
		CategoryDto listSingleCategory=this.categoryServiceimpl.getById(categoryId);
		return ResponseEntity.status(HttpStatus.OK).body(listSingleCategory);
	}
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> modifyThroughId( @Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId)
	{
		CategoryDto upadteById=this.categoryServiceimpl.updateById(categoryDto, categoryId);
		return ResponseEntity.status(HttpStatus.OK).body(upadteById);
	}
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteById(@PathVariable Integer categoryId)
	{
		this.categoryServiceimpl.deleteByid(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
		
	}
	

}
