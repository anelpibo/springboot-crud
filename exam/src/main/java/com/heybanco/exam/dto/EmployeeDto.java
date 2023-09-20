package com.heybanco.exam.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmployeeDto {
    @EqualsAndHashCode.Include
    private Long id;
    private String employeeId;
    private String firstName;
    private String lastName;
    private RoleDto role;
    private List<ProjectDto> projects = new ArrayList<ProjectDto>();
}
