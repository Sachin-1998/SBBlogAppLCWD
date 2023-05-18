package com.blog.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CommentDto 
{
	private int comment_Id;
	@NotBlank
	@Size(max = 200)
	private String content;
	public int getComment_Id() {
		return comment_Id;
	}
	public void setComment_Id(int comment_Id) {
		this.comment_Id = comment_Id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public CommentDto(int comment_Id, String content) {
		super();
		this.comment_Id = comment_Id;
		this.content = content;
	}
	public CommentDto() {
		super();
		
	}
	
	

}
