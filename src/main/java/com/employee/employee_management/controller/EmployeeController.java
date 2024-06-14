package com.employee.employee_management.controller;

import com.employee.employee_management.Service.EmployeeService;
import com.employee.employee_management.model.Employee;
import com.employee.employee_management.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        try{
            List<Employee> employees = employeeService.getAllEmployees();

            if(employees.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            else return new ResponseEntity<>(employees, HttpStatus.OK);
        }catch(Exception err)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        try{
            Optional<Employee> employeeContainer= employeeService.getEmployeeById(id);

            if(employeeContainer.isPresent())
            {
                Employee employee = employeeContainer.get();
                return new ResponseEntity<>(employee, HttpStatus.OK);
            }
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(Exception err) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        try{

            return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.OK);
        }
        catch(Exception err) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        try{

            Employee newEmployee = employeeService.updateEmployee(id, employee);

            if(newEmployee == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(newEmployee, HttpStatus.OK);
        }
        catch(Exception err) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id){
        try{
            boolean deleted = employeeService.deleteEmployee(id);

            if(deleted)
                return new ResponseEntity<>(HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(Exception err) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
