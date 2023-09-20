package com.heybanco.exam.service;

import com.heybanco.exam.dto.RoleDto;

import jakarta.validation.Valid;

public interface IRoleService {
    public RoleDto create(@Valid RoleDto role);
}
