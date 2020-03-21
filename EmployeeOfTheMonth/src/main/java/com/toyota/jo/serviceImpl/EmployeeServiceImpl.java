package com.toyota.jo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toyota.jo.entity.ContractType;
import com.toyota.jo.entity.Department;
import com.toyota.jo.entity.Employee;
import com.toyota.jo.model.EmployeeRequest;
import com.toyota.jo.repository.EmployeeRepository;
import com.toyota.jo.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Long AddEmployee(EmployeeRequest employeeRequest) {
		Employee employee = new Employee(employeeRequest);
		Long id = employee.getEmpId();
		System.out.println("name" + employee.getEmpName());
		employeeRepository.save(employee);
		System.out.println("Age" + employee.getEmpAge());
		return id;
	}

	@Override
	public void UpdateEmployee(EmployeeRequest employeeRequest) {
		Employee employee = new Employee(employeeRequest);
		employeeRepository.save(employee);
	}

	@Override
	public void DeleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
	
	@Override
	public List<Employee> getAllEmployees(){
		List<Employee> empList  = 	employeeRepository.findAll();
		if (empList.size() > 0) {
			return empList;
		}
		List<Employee> Empty = new ArrayList<>();
		return Empty;
	}
	@Override
	public List<Employee> getEmployeesByDepartment(Department department) {
		List<Employee> empList  = employeeRepository.findAllByDepartment(department);
		if (empList.size() > 0) {
			return empList;
		}
		List<Employee> Empty = new ArrayList<>();
		return Empty;
	}

	@Override
	public List<Employee> getEmployeesByContractType(ContractType contractType) {
		List<Employee> empList  = employeeRepository.findAllByEmpContractType(contractType);
		if (empList.size() > 0) {
			return empList;
		}
		List<Employee> Empty = new ArrayList<>();
		return Empty;
	}

	@Override
	public Boolean getEmployeeById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent())
		return true ;
		else return false;
	}

	@Override
	public Employee AddEmployeeBonus(Double empBonus, Long Id) {
		Optional<Employee> employee = employeeRepository.findById(Id);
		if(employee.isPresent())
			if(employee.get().getEmpContractType() == ContractType.FULL_TIME)
				employee.get().setEmpBonus(empBonus+10);
			else
					employee.get().setEmpBonus(empBonus);
		
		return fillEmployee(employee);
	}

	@Override
	public Employee EmployeeOfTheMonth(Double empBonus) {
		List<Employee> chosenEmployees = new ArrayList<>();
	List<Employee> allEmployees = employeeRepository.findAll();
	Employee employeeOfTheMonth = allEmployees.get(new Random().nextInt(allEmployees.size()));
	for (int i =0 ; i<allEmployees.size() ; i++) {
		if(chosenEmployees.contains(employeeOfTheMonth))
			employeeOfTheMonth = allEmployees.get(new Random().nextInt(allEmployees.size()));
		else
			break;
	}
	employeeOfTheMonth =AddEmployeeBonus(empBonus , employeeOfTheMonth.getEmpId());
	return employeeOfTheMonth;
	}
	
	
	public Employee fillEmployee(Optional<Employee> employee) {
		Employee newEmp = new Employee();
		newEmp.setEmpId(employee.get().getEmpId());
		newEmp.setDepartment(employee.get().getDepartment());
		newEmp.setEmpAge(employee.get().getEmpAge());
		newEmp.setEmpBonus(employee.get().getEmpBonus());
		newEmp.setEmpName(employee.get().getEmpName());
		newEmp.setEmpContractType(employee.get().getEmpContractType());
		return newEmp;
	}
}
