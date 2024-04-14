package com.sample.web;

import com.sample.dto.EmployeeSearchSpecification;
import com.sample.employee.entity.Employee;
import com.sample.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/search")
    public ResponseEntity<List<Employee>> searchEmployee(@RequestBody EmployeeSearchSpecification searchSpecification) {
        List<Employee> employees = employeeService.searchEmployee(searchSpecification);
        return ResponseEntity.ok().body(employees);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> getById(@PathVariable(name = "id") Integer id) {
        Employee employees = employeeService.getEmployeeById(id);
        return ResponseEntity.ok().body(employees);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee employees = employeeService.createEmployee(employee);
        return ResponseEntity.ok().body(employees);
    }




}
