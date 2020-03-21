package com.toyota.jo.service;

import java.util.List;

import com.toyota.jo.entity.ContractType;
import com.toyota.jo.entity.Department;
import com.toyota.jo.entity.Employee;
import com.toyota.jo.model.EmployeeRequest;


public interface EmployeeService {
	
	public Long AddEmployee(EmployeeRequest emRequest);
	
	public void UpdateEmployee(EmployeeRequest emRequest);
	
	public void DeleteEmployee(Long id);
	
	public List<Employee> getAllEmployees();
	
	public List<Employee> getEmployeesByDepartment(Department department);
	
	public List<Employee> getEmployeesByContractType(ContractType contractType);

	public Boolean getEmployeeById(Long id);
	
	public Employee AddEmployeeBonus(Double empBonus, Long Id);
	
	public Employee EmployeeOfTheMonth(Double empBonus);
	
}
