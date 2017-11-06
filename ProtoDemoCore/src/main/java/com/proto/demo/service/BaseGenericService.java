package com.proto.demo.service;

import java.util.List;

public interface BaseGenericService<T> {

	List<T> findAll();
	
	T find(Integer id);
}
