package com.heybanco.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.heybanco.exam.dto.RoleDto;
import com.heybanco.exam.model.Role;
import com.heybanco.exam.repository.IRoleJpaRepository;

@Validated
@Service
public class RoleServiceImpl implements IRoleService{

    @Autowired
    private IRoleJpaRepository roleJpaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RoleDto create(RoleDto roleDto) {
        // TODO Auto-generated method stub
        Role roleEntity = modelMapper.map(roleDto, Role.class);
        roleJpaRepository.save(roleEntity);
        return modelMapper.map(roleEntity, RoleDto.class);
    }
}
