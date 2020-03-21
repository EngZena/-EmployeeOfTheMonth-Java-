package com.toyota.jo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.toyota.jo.entity.Department;
import com.toyota.jo.repository.DepartmentRepository;
import com.toyota.jo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public Long AddDepartment(String depName) {
		Department department = new Department(depName);
		Long id = department.getDepId();
		departmentRepository.save(department);
		return id;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> allDeps = new ArrayList<Department>();
		allDeps = departmentRepository.findAll();
		return allDeps;
	}

	@Override
	public void DeleteDepartment(Long id) {
		Optional<Department> dep = departmentRepository.findById(id);
		if(dep.isPresent())
			System.out.println("present");
		departmentRepository.deleteById(id);			
	}

}
