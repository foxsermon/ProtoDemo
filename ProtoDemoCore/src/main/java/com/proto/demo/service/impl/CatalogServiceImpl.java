package com.proto.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proto.demo.dao.GenericDao;
import com.proto.demo.model.Catalog;
import com.proto.demo.service.CatalogService;

@Service
public class CatalogServiceImpl implements CatalogService {

	@Autowired
	private GenericDao<Catalog> dao;
	
	public List<Catalog> findAll() {
		return dao.findAll(Catalog.class);
	}

	public Catalog find(Integer id) {
		return dao.find(id, Catalog.class);
	}
}
