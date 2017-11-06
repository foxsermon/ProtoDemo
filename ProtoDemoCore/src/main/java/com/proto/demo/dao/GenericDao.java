package com.proto.demo.dao;

import java.util.List;

public interface GenericDao<T> {

	List<T> findAll(Class<T> clazz);
	
	T find(Integer id, Class<T> clazz);
	
	List<T> findByParentId(Integer id, String fieldName, Class<T> clazz);

}
