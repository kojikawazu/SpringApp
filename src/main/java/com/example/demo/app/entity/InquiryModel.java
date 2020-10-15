package com.example.demo.app.entity;

import java.time.LocalDateTime;
import java.util.List;

public class InquiryModel {
	
	private int id;
	private String name;
	private String email;
	private String comment;
	private LocalDateTime created;
	
	private List<InquiryReplyModel> replyList;

	public InquiryModel() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	
	public List<InquiryReplyModel> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<InquiryReplyModel> replyList) {
		this.replyList = replyList;
	}
	
}
