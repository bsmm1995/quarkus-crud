package com.bsmm.quarkus.service;

import com.bsmm.quarkus.domain.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto getById(long id);

    List<DepartmentDto> getAll();

    DepartmentDto create(DepartmentDto department);

    DepartmentDto update(long id, DepartmentDto department);

    long deleteById(long id);
}
