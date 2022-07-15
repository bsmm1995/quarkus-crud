package com.bsmm.quarkus.service;

import com.bsmm.quarkus.domain.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto getDepartment(Long id);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto createDepartment(DepartmentDto department);
}
