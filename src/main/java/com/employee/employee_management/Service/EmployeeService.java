package com.employee.employee_management.Service;

import com.employee.employee_management.model.Employee;
import com.employee.employee_management.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    public List<Employee> getAllEmployees()
    {
        List<Employee> employees = new ArrayList<>();
        employeeRepo.findAll().forEach((emp) -> employees.add(emp));
        return employees;
    }

    public Optional<Employee> getEmployeeById(Long id)
    {
        Optional<Employee> employee = employeeRepo.findById(id);
        return employee;
    }

    public Employee createEmployee(Employee employee)
    {
        Employee newEmployee = employeeRepo.save(employee);
        return newEmployee;
    }

    public Employee updateEmployee(Long id, Employee employee)
    {
        Optional<Employee> employeeContainer= employeeRepo.findById(id);
        if(employeeContainer.isPresent()) {
            Employee newEmployee = employeeContainer.get();
            newEmployee.setFirstName(employee.getFirstName());
            newEmployee.setLastName(employee.getLastName());
            newEmployee.setEmail(employee.getEmail());
            newEmployee.setDepartment(employee.getDepartment());
            newEmployee.setSalary(employee.getSalary());

            return employeeRepo.save(newEmployee);
        }
        else return null;
    }

    public boolean deleteEmployee(Long id)
    {
        Optional<Employee> employeeContainer= employeeRepo.findById(id);

        if(employeeContainer.isPresent())
        {
            employeeRepo.deleteById(id);
            return true;
        }
        else return false;
    }

}
