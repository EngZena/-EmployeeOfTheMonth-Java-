package com.toyota.jo.service;

import java.util.List;
import com.toyota.jo.entity.Department;

public interface DepartmentService {

	
	public Long AddDepartment(String depName);
	
	public void DeleteDepartment(Long id);
	
	public List<Department> getAllDepartments();
	
}
