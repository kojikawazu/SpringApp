package com.example.demo.app.entity;

import java.time.LocalDateTime;
import java.util.List;

public class BlogMainModel {
	
	private int id;
	private String title;
	private String tag;
	private String comment;
	private int thanksCnt;
	private LocalDateTime created;
	private LocalDateTime updated;
	
	private List<BlogReplyModel> replyList;
	
	public BlogMainModel() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
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
	public LocalDateTime getUpdated() {
		return updated;
	}
	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}
	
	public List<BlogReplyModel> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<BlogReplyModel> replyList) {
		this.replyList = replyList;
	}

}
