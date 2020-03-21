package com.toyota.jo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Department")
public class Department {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long depId;
	@Column(name="DEP_NAME")
	private String depName;
	
	@OneToMany(mappedBy = "department")
	private List<Employee> employees;

	
	
	public Department() {
		super();
	}
	
	

	public Department(String depName) {
		super();
		this.depName = depName;
	}



	public Long getDepId() {
		return depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
