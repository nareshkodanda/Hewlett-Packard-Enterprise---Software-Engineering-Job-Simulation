package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Employees {
	
	private List<Employee> employees;
	
	public Employees ( ) {
		this.employees = new ArrayList<>();
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void addEmployee(Employee employee) {
        ((Employees) employees).getEmployees().add(employee);
    }

    // Method to update an existing employee in the list
    public void updateEmployee(Employee updatedEmployee) {
        List<Employee> employeeList = ((Employees) employees).getEmployees();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployee_id() == updatedEmployee.getEmployee_id()) {
                employeeList.set(i, updatedEmployee);
                break;
            }
        }
    }

    public void deleteEmployee(int employeeId) {
        List<Employee> employeeList = ((Employees) employees).getEmployees();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployee_id() == employeeId) {
                employeeList.remove(i);
                break;
            }
        }
    }


}
