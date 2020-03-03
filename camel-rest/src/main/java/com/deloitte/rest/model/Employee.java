package com.deloitte.rest.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


public class Employee {

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	private int empNo;
	private String empName;
	private String orgName;

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", orgName=" + orgName + "]";
	}

	public Employee(int empNo, String empName, String orgName) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.orgName = orgName;
	}

	public Employee() {
		
	}
}
