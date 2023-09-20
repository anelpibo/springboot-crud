package com.heybanco.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heybanco.exam.model.Employee;

@Repository
public interface IEmployeeJpaRepository extends JpaRepository<Employee, Long> {
    // select fields from employee where employeeid='[param]'
    Employee findByemployeeId(String employeeId);
}
