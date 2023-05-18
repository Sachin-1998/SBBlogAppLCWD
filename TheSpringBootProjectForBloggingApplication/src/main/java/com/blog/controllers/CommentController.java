package com.blog.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entities.Comment;
import com.blog.payloads.ApiResponse;
import com.blog.payloads.CommentDto;
import com.blog.services.impl.CommentServiceImpl;

@RestController
@RequestMapping("/api")
public class CommentController 
{
	@Autowired
	private CommentServiceImpl commentServiceImpl;
	@PostMapping("/comments/{postId}")
	public ResponseEntity<CommentDto> addComment( @Valid @RequestBody CommentDto commentDto, @PathVariable Integer postId)
	{
		CommentDto createComment = this.commentServiceImpl.createComment(commentDto, postId);
		return new ResponseEntity<CommentDto>(createComment,HttpStatus.CREATED);
	}
	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponse> removeComment(@PathVariable Integer commentId)
	{
		this.commentServiceImpl.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted Successfully",true),HttpStatus.OK);
	}
}
