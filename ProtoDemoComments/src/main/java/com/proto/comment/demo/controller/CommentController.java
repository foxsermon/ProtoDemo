package com.proto.comment.demo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proto.demo.model.Comment;
import com.proto.demo.service.CommentService;

@RestController
public class CommentController {

	private static final Logger logger = Logger.getLogger(CommentController.class);

	@Autowired
	private CommentService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/comments", headers = "Accept=application/json")
	public List<Comment> findAll() {
		List<Comment> comments = service.findAll();
		logger.info("Size : " + comments.size());
		return comments;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/comment/{id}", headers = "Accept=application/json")
	public Comment findById(@PathVariable("id") Integer id) {
		logger.info("Looking for Comment Id :( " + id);
		return service.find(id);
	}
}
