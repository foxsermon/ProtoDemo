package com.proto.demo.service;

import java.util.List;

import com.proto.demo.model.User;

public interface UserService {

	List<User> findAll();
	
	User find(Integer id);

}
