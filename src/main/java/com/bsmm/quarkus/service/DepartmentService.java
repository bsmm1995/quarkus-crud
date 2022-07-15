package com.bsmm.quarkus.service;

import com.bsmm.quarkus.domain.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto getById(Long id);

    List<DepartmentDto> getAll();

    DepartmentDto create(DepartmentDto department);
}
