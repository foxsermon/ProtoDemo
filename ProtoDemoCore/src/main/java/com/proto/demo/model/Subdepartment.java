package com.proto.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"subdeptId", "subdepartmentName", "products"})
public class Subdepartment {

	private Integer subdeptId;
	private String subdepartmentName;
	private List<Product> products = new ArrayList<>();
	
	public Integer getSubDeptId() {
		return subdeptId;
	}
	public void setSubDeptId(Integer subdeptId) {
		this.subdeptId = subdeptId;
	}
	public String getSubDepartmentName() {
		return subdepartmentName;
	}
	public void setSubDepartmentName(String subdepartmentName) {
		this.subdepartmentName = subdepartmentName;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
