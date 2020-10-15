package com.example.demo.app.entity;

import java.time.LocalDateTime;

public class BlogCommentModel {
	
	private int id;
	private int blogid;
	private String name;
	private String comment;
	private int thanksCnt;
	private LocalDateTime created;
	
	public BlogCommentModel() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBlogid() {
		return blogid;
	}

	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getThanksCnt() {
		return thanksCnt;
	}

	public void setThanksCnt(int thanksCnt) {
		this.thanksCnt = thanksCnt;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	
	
	
}
