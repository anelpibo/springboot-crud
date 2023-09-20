package com.heybanco.exam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.heybanco.exam.dto.RoleDto;

import jakarta.validation.ConstraintViolationException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RoleConstraintsValidationExceptionTest {

    private static final String ADMIN = "ADMIN";
    @Autowired
    private RoleServiceImpl roleServiceImpl;

    @Test
    public void constraintsValidationExceptionTest(){
        assertThrows(ConstraintViolationException.class, ()-> {roleServiceImpl.create(new RoleDto(null));});
        assertThrows(ConstraintViolationException.class, ()-> {roleServiceImpl.create(new RoleDto(""));});
        assertThrows(ConstraintViolationException.class, ()-> {roleServiceImpl.create(new RoleDto("1234567890123456"));});
    }

    @Test
    public void createRoleOk(){
        RoleDto roleDto = roleServiceImpl.create(new RoleDto(ADMIN));
        assertNotNull(roleDto);
        assertEquals(ADMIN, roleDto.getName());
        assertNotNull(roleDto.getId());
    }
}
