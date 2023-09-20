package com.heybanco.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heybanco.exam.model.Employee;
import com.heybanco.exam.model.Role;

@Repository
public interface IEmployeeJpaRepository extends JpaRepository<Employee, Long> {
    // select fields from employee where employeeid='[param]'
    Employee findByemployeeId(String employeeId);
    
    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    List<Employee> findByRole(Role role);
}
