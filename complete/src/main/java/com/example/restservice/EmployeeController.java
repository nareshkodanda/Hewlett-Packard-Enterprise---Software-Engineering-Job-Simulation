package com.example.restservice;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeManager employeeManager;

    public EmployeeController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @GetMapping("/employees")
    public Employees getAllEmployees() {
        return employeeManager.getEmployees();
    }
    
    @PostMapping("/employees")
    public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
        // Add employee to the list
        employeeManager.getEmployees().getEmployees().add(employee);
        // Return success response
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PutMapping("/employees/{id}")
    public ResponseEntity<Void> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        List<Employee> employees = employeeManager.getEmployees().getEmployees();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployee_id() == id) {
                // Update employee information
                employees.set(i, employee);
                // Return success response
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        }
        // If employee with the given id is not found, return 404 Not Found
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        // Find the employee by id
        List<Employee> employees = employeeManager.getEmployees().getEmployees();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployee_id() == id) {
                // Remove employee from the list
                employees.remove(i);
                // Return success response
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        }
        // If employee with the given id is not found, return 404 Not Found
        return ResponseEntity.notFound().build();
    }



}
