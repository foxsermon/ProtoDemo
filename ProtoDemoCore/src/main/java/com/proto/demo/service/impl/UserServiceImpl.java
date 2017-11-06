package com.proto.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proto.demo.model.User;
import com.proto.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public User find(Integer id) {
		return null;
	}
}
