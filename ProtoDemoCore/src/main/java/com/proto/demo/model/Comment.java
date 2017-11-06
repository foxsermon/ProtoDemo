package com.proto.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
public class Comment {

	@Id
	private Integer userId;
	private Integer prdId;
	private String comment;
	private Integer rate;
	
	public Comment(Integer userId, Integer prdId, String comment, Integer rate) {
		super();
		this.userId = userId;
		this.prdId = prdId;
		this.comment = comment;
		this.rate = rate;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getPrdId() {
		return prdId;
	}
	public void setPrdId(Integer prdId) {
		this.prdId = prdId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
}
