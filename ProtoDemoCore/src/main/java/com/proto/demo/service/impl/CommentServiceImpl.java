package com.proto.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proto.demo.model.Comment;
import com.proto.demo.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Override
	public List<Comment> findAll() {
		return null;
	}

	@Override
	public Comment find(Integer id) {
		return null;
	}
}
