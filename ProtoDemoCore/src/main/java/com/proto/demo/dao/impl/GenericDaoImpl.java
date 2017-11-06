package com.proto.demo.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.proto.demo.dao.GenericDao;

@Repository
public class GenericDaoImpl<T> implements GenericDao<T> {

	private static final Logger logger = Logger.getLogger(GenericDaoImpl.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<T> findAll(Class<T> clazz) {
		logger.info(clazz.getSimpleName() + ", findAll");
		return (List<T>) mongoTemplate.findAll(clazz);
	}

	public T find(Integer id, Class<T> clazz) {
		logger.info(clazz.getSimpleName() + ", find, id : " + id);
		return (T) mongoTemplate.findById(id, clazz);
	}

	public List<T> findByParentId(Integer id, String fieldName, Class<T> clazz) {
		return (List<T>) mongoTemplate.find(new Query(Criteria.where(fieldName).is(id)), clazz);
	}

}	

