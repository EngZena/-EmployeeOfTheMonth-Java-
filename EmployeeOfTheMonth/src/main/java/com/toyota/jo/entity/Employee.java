package com.toyota.jo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.toyota.jo.model.EmployeeRequest;

@Entity
@Table(name= "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="EMPLOYEE_ID")
	private Long empId;
	
	@Column(name="EMPLOYEE_NAME")
	private String empName;
	@Column(name="EMPLOYEE_AGE")
	private Integer empAge;
	@Column(name="EMPLOYEE_CONTRACT_TYPE")
	private ContractType empContractType;
	@Column(name="EMPLOYEE_BONUS")
	private Double empBonus;
		
	@ManyToOne
	@JoinColumn(name = "ID_DEPARTMENT")
	private Department department;
	
	
	public Long getEmpId() {
		return empId;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	
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

	public Double getEmpBonus() {
		return empBonus;
	}

	public void setEmpBonus(Double empBonus) {
		this.empBonus = empBonus;
	}

	
	
	public Employee() {
		super();
	}

	public Employee(EmployeeRequest emRequest) {
		super();
		
		this.empName = emRequest.getEmpName();
		this.empAge = emRequest.getEmpAge();
		this.empContractType = emRequest.getEmpContractType();
		this.department = emRequest.getDepartment();
	}

	
}
