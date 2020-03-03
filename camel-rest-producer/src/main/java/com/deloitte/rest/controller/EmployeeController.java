package com.deloitte.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.deloitte.rest.model.Employee;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value="/api/employee")
public class EmployeeController {

	private static java.util.List<Employee> employees=new ArrayList<Employee>();
	static {
		
		employees=createEmployee();
	}
	
	public static  List<Employee> createEmployee(){
		 java.util.List<Employee> employees=new ArrayList<Employee>();
		 employees.add(new Employee(1, "prashanth", "deloitte"));
		 employees.add(new Employee(2, "ram", "dell"));
		 employees.add(new Employee(3, "kiran", "cisco"));
		 return employees;
		
	}
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Employee> getAllEmployees(){
		
		return employees;
	}
	
	@GetMapping(value="/getEmployee/{id}")
	public Employee getEmployeeById(@PathVariable(name="id") int id) {
		
		Employee employee1=null;
		for(Employee employee :employees) {
				
			if(employee.getEmpNo()==id) {
				
				employee1= employee;
			}
		}
		return employee1;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/save")
	public String saveEmployee(@RequestBody Employee employee) {
		
		employee.setEmpNo(employees.size()+1);
		employees.add(employee);
		return "employee added";
	}
	
}
