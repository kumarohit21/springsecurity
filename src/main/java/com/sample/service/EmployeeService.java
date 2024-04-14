package com.sample.service;

import com.sample.dto.EmployeeSearchSpecification;
import com.sample.employee.entity.Employee;

import java.util.List;

 public interface EmployeeService {

     List<Employee> searchEmployee(EmployeeSearchSpecification searchSpecification);

     List<Employee> getEmployeeByLName(String lName);
     Employee createEmployee(Employee employee);
     Employee getEmployeeById(Integer id);
}
