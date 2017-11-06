package com.proto.user.demo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proto.demo.model.User;
import com.proto.demo.service.UserService;

@RestController
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/users", headers = "Accept=application/json")
	public List<User> findAll() {
		List<User> users = service.findAll();
		logger.info("Size : " + users.size());
		return users;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}", headers = "Accept=application/json")
	public User findById(@PathVariable("id") Integer id) {
		logger.info("Looking for User Id :( " + id);
		return service.find(id);
	}

}
