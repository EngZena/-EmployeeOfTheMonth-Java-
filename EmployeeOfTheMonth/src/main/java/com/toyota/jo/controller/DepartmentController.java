package com.toyota.jo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toyota.jo.entity.Department;
import com.toyota.jo.service.DepartmentService;

@RestController
@RequestMapping("/toyta")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/department")
	public Long AddNewDepartment(@RequestBody String depName) {
		System.out.println("name" + depName);
		Long id = departmentService.AddDepartment(depName);
		return id;
	}
	
	@GetMapping("/AllDepartments")
	public List<Department> getAllDepartments(){
		List<Department> Departments = departmentService.getAllDepartments();
		return Departments;
	}
	
	@DeleteMapping("/department/{depId}")
	public void DeleteDepartment(@PathVariable Long id) {
		System.out.println("id" + id);
		 departmentService.DeleteDepartment(id);
	}
}
