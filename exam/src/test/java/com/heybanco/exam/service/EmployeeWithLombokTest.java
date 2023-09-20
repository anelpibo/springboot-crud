package com.heybanco.exam.service;

import org.junit.jupiter.api.Test;

import com.heybanco.exam.dto.EmployeeDto;

public class EmployeeWithLombokTest {
    @Test
    public void EmployeeWithLombokTest(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeId("123123");
    }
}
