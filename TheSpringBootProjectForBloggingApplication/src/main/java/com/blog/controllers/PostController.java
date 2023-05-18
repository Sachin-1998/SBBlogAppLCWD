package com.blog.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blog.config.AppConstants;
import com.blog.payloads.ApiResponse;
import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;
import com.blog.services.FileService;
import com.blog.services.impl.PostServiceImpl;



@RestController
@RequestMapping("/api/")
public class PostController 
{
	@Autowired
	private PostServiceImpl postServiceImpl;
	@Autowired
	private FileService fileService;
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> addNewPost( @Valid  @RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId)
	{
		PostDto createPost=this.postServiceImpl.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	}
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getAllPostByCategory( @PathVariable Integer categoryId)
	{
		List<PostDto> lists=this.postServiceImpl.getPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(lists,HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getAllPostByUser( @PathVariable Integer userId)
	{
		List<PostDto> lists=this.postServiceImpl.getPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(lists,HttpStatus.OK);
	}
	//get all post
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPosts(@RequestParam(value = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
		@RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE,required = false) Integer pageSize,
		@RequestParam(value="sortBy",defaultValue = AppConstants.SORT_BY,required = false) String sortBy,
		@RequestParam(value="sortDir",defaultValue = AppConstants.SORT_DIR,required = false) String sortDir)
	{
		PostResponse postResponse = this.postServiceImpl.getAllPost(pageNumber,pageSize,sortBy,sortDir);
		return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);
	}
	//delete post
	@DeleteMapping("/{postId}")
	public ResponseEntity<ApiResponse> removePost(@PathVariable Integer postId)
	{
		this.postServiceImpl.deletePost(postId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Post Deleted Successfully",true),HttpStatus.OK);
	}
	//get single post
	@GetMapping("/post/{postId}")
	public ResponseEntity<PostDto> getSinglePost(@PathVariable Integer postId)
	{
		PostDto singlePostDtos=this.postServiceImpl.getSinglePost(postId);
		return new ResponseEntity<PostDto>(singlePostDtos,HttpStatus.OK);
	}
	//update post
	@PutMapping("/post/{postId}")
	public ResponseEntity<PostDto> upadtePost(@Valid @RequestBody PostDto postDto,@PathVariable Integer postId)
	{
		PostDto updatedPostDtos=this.postServiceImpl.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatedPostDtos,HttpStatus.OK);
		
	}
	//search post
	@GetMapping("/search/post/{keyword}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable String keyword)
	{
		List<PostDto> results = this.postServiceImpl.searchPosts(keyword);
		return new ResponseEntity<List<PostDto>>(results,HttpStatus.OK);
	}
	//file upload controller
	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadPostImage(@RequestParam("image") MultipartFile image,@PathVariable Integer postId) throws IOException
	{
		//provide the postId for which we are uploading image
		PostDto postDto = this.postServiceImpl.getSinglePost(postId);
		//call the upload image method
		String imageName = this.fileService.uploadImage(path, image);
		//set the image which we are going to upload
		postDto.setImageName(imageName);
		//call the update method from post Service
		PostDto updatePost = this.postServiceImpl.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK); 
	
	}
	//method to serve images
	@GetMapping(value="/post/image/{imageName}",produces=MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable String imageName,HttpServletResponse response) throws IOException
	{
	InputStream resource=this.fileService.getResInputStream(path, imageName);
	response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	StreamUtils.copy(resource, response.getOutputStream());
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
