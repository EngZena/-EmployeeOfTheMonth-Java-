package com.toyota.jo.model;

import com.toyota.jo.entity.ContractType;
import com.toyota.jo.entity.Department;

public class EmployeeRequest {

	private String empName;
	
	private Integer empAge;
	
	private ContractType empContractType;
	
	private Department department;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmpAge() {
		return empAge;
	}

	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}

	public ContractType getEmpContractType() {
		return empContractType;
	}

	public void setEmpContractType(ContractType empContractType) {
		this.empContractType = empContractType;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
