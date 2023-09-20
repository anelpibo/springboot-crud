package com.heybanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heybanco.model.Employee;


@Repository
public interface IEmployeeJpaRepository extends JpaRepository<Employee,Long>{
    Employee findByEmployeeId(String employeeId);
}
