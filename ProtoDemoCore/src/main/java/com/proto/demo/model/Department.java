package com.proto.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"deptId", "departmentName", "subdepartments"})
public class Department {

	private Integer deptId;
	private String departmentName;
	private List<Subdepartment> subdepartments = new ArrayList<>();
	
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<Subdepartment> getSubdepartments() {
		return subdepartments;
	}
	public void setSubdepartments(List<Subdepartment> subdepartments) {
		this.subdepartments = subdepartments;
	}
}
