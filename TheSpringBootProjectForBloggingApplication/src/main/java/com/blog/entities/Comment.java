package com.blog.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int comment_Id;
	private String content;
	@ManyToOne
	private Post post;
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
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Comment(int comment_Id, String content, Post post) {
		super();
		this.comment_Id = comment_Id;
		this.content = content;
		this.post = post;
	}
	public Comment() {
		super();
		
	}
	
	

}
