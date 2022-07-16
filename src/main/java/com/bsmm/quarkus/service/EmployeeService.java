package com.bsmm.quarkus.service;

import com.bsmm.quarkus.domain.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto getById(long id);

    List<EmployeeDto> getByDepartmentId(long departmentId);

    List<EmployeeDto> getByName(String name);

    List<EmployeeDto> getAll();

    EmployeeDto create(EmployeeDto employee);

    EmployeeDto update(long id, EmployeeDto employee);

    EmployeeDto updateDepartment(long id, long departmentId);

    long deleteById(long id);
}
