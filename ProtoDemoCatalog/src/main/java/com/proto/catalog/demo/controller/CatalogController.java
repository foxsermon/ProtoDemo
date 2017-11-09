package com.proto.catalog.demo.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proto.demo.model.Catalog;
import com.proto.demo.service.CatalogService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class CatalogController {

	private static final Logger logger = Logger.getLogger(CatalogController.class);
	
	@Autowired
	private CatalogService service;
	
	@PreAuthorize("#oauth2.hasScope('resource-server-read')")
	@RequestMapping(method = RequestMethod.GET, value = "/catalogs", headers = "Accept=application/json")
	//@ApiOperation(value = "Find all", notes = "${CatalogController.findAll.notes}")
	public List<Catalog> findAll() {
		List<Catalog> catalogs = service.findAll();
		logger.info("Size : " + catalogs.size());
		return catalogs;
	}

	@PreAuthorize("#oauth2.hasScope('resource-server-read')")
	@RequestMapping(method = RequestMethod.GET, value = "/catalog/{id}", headers = "Accept=application/json")
	//@ApiOperation(value = "Find By Catalog Id", notes = "${CatalogController.findById.notes}")
	public Catalog findById(
			//@ApiParam(value = "${CatalogController.findById.id}", required = true)
			@PathVariable("id") Integer id
			) {
		logger.info("Looking for Catalog :" + id);
		return service.find(id);
	}
}
