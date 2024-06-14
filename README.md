# Employee-management-app

## Overview
This is a simple Employee Management Application developed using Java and Spring Boot. The application performs basic CRUD (Create, Read, Update, Delete) operations for managing employee details.

## Features
- Create a new employee
- Get a list of all employees
- Get an employee by ID
- Update employee details by ID
- Delete an employee by ID

## Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Spring Boot DevTools

## Application Structure
- Model : Defines the "Employee" entity class
- Repo : Defines the "EmployeeRepository" with extends to JPA repository interface
- Service : Defines the "EmployeeService" service layer
- Controller : Defines the "EmployeeController" controller layer

  ## API Endpoints
  - GET http://localhost:8080/employees
  - GET http://localhost:8080/employees/{id}
  - POST http://localhost:8080/employees
    Content-Type: application/json
    Body:
    {
      "firstName": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com",
      "department": "Engineering",
      "salary": 60000
    }
    - PUT http://localhost:8080/employees/{id}
      Content-Type: application/json
      Body:
      {
        "firstName": "John",
        "lastName": "Doe",
        "email": "john.doe@example.com",
        "department": "Marketing",
        "salary": 8000
      }
      -DELETE http://localhost:8080/employees/{id}



