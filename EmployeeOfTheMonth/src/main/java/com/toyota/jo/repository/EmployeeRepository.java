package com.toyota.jo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toyota.jo.entity.ContractType;
import com.toyota.jo.entity.Department;
import com.toyota.jo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	public List<Employee> findAll();
		
	public List<Employee> findAllByDepartment(Department department);
	
	public List<Employee> findAllByEmpContractType(ContractType contractType);
	
	
}
