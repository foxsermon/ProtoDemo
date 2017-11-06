package com.proto.demo.service;

import java.util.List;

import com.proto.demo.model.Role;

public interface RoleService {

	List<Role> findAll();
	
	Role find(Integer id);

}
