package com.blog.services;

import java.util.List;

import com.blog.entities.Post;
import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;

public interface PostService 
{
	//create post
	
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update post post
	
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//get all post
	
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	
	//delete post
	
	void deletePost(Integer postId);
	
	//get post by id
	
	PostDto getSinglePost(Integer postId);
	
	//get all post by category
	
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	
	List<PostDto> getPostsByUser(Integer userId);
	
	//search post
	
	List<PostDto> searchPosts(String keyword);

}
