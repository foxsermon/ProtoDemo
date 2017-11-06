package com.proto.demo.service;

import java.util.List;

import com.proto.demo.model.Permission;

public interface PermissionService {

	List<Permission> findAll();
	
	Permission find(Integer id);

}
