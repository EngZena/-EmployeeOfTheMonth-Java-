package com.toyota.jo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toyota.jo.entity.ContractType;
import com.toyota.jo.entity.Department;
import com.toyota.jo.entity.Employee;
import com.toyota.jo.model.EmployeeRequest;
import com.toyota.jo.service.EmployeeService;


@RestController
@RequestMapping("/toyta/Employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public Long AddNewEmployee(@RequestBody EmployeeRequest employeeRequest) {
		System.out.println("name" + employeeRequest.getEmpName());
		Long id = employeeService.AddEmployee(employeeRequest);
		return id;
	}
	
	@PutMapping("/{empId}")
	public void updateEmployee(@RequestBody EmployeeRequest employeeRequest , @PathVariable Long empId) {
		Boolean exist = employeeService.getEmployeeById(empId);
		if(exist == true) {
			employeeService.UpdateEmployee(employeeRequest);
		}
	}
	
	@DeleteMapping("/{empId}")
	public void deleteEmployee(@PathVariable Long empId) {
		employeeService.DeleteEmployee(empId);
	}
	@GetMapping("/AllEmployees")
	public List<Employee> getAllEmployees(){
		List<Employee> Employees = employeeService.getAllEmployees();
		return Employees;
	}
	
	@GetMapping("/getByDepartment/{empDepartment}")
	public List<Employee> getEmployeesByDepartment(@RequestBody Department department) {
		List<Employee> Employees = employeeService.getEmployeesByDepartment(department);
		return Employees;
	}
	
	@GetMapping("/getByContractType/{empContractType}")
	public List<Employee> getEmployeesByContractType(@RequestBody ContractType contractType){
		List<Employee> Employees = employeeService.getEmployeesByContractType(contractType);
		return Employees;
	}
	
	
	@GetMapping("/employeeOfTheMonth")
	public Employee EmployeeOfTheMonth(@RequestBody Double empBonus) {
		return employeeService.EmployeeOfTheMonth(empBonus);
	}
}
