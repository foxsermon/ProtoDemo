package com.proto.demo.service;

import java.util.List;

import com.proto.demo.model.Comment;

public interface CommentService {

	List<Comment> findAll();
	
	Comment find(Integer id);

}
