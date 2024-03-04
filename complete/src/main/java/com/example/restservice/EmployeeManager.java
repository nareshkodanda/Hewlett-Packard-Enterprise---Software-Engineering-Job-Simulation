package com.example.restservice;

import org.springframework.stereotype.Component;


@Component
public class EmployeeManager {
	
	private Employees employees;
	
	public EmployeeManager() {
		    this.employees = new Employees();
		    employees.getEmployees().add(new Employee(1, "John", "Doe", "john@example.com", "Software Engineer"));
	        employees.getEmployees().add(new Employee(2, "Jane", "Smith", "jane@example.com", "Product Manager"));
	        employees.getEmployees().add(new Employee(3, "Bob", "Johnson", "bob@example.com", "Quality Assurance"));
	}
	
	 public Employees getEmployees() {
	        return employees;
	    }

}
