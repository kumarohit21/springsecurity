package com.sample.service.impl;

import com.sample.dto.EmployeeSearchSpecification;
import com.sample.employee.entity.Employee;
import com.sample.employee.repo.EmployeeRepository;
import com.sample.service.EmployeeService;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EntityManager entityManager;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EntityManager entityManager) {
        this.employeeRepository = employeeRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> searchEmployee(EmployeeSearchSpecification searchSpecification) {

        Specification<Employee> specification = (employee, cq, cb) -> cb.equal(employee.get("lName"), searchSpecification.lName());


       return  employeeRepository.findAll(specification);
    }

    @Override
    public List<Employee> getEmployeeByLName(String lName) {
        return employeeRepository.findByLname(lName);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setId(null);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.getReferenceById(id);
    }
}
