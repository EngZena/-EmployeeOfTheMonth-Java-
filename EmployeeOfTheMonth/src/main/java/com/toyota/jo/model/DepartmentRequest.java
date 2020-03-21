package com.toyota.jo.model;

public class DepartmentRequest {

	private String depName;
	
	

	public String getDepName() {
		return depName;
	}



	public void setDepName(String depName) {
		this.depName = depName;
	}



	public DepartmentRequest(String depName) {
		super();
		this.depName = depName;
	}
	
	
}
