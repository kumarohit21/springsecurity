package com.sample.employee.repo;

import com.sample.employee.entity.Employee;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.query.criteria.spi.CriteriaBuilderExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {


    List<Employee> findByLname(String lname);
}
