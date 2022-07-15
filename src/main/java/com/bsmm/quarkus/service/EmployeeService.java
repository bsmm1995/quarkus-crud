package com.bsmm.quarkus.service;

import com.bsmm.quarkus.domain.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto getById(Long id);

    List<EmployeeDto> getByDepartmentId(Long deptId);

    List<EmployeeDto> getByName(String name);

    List<EmployeeDto> getAll();

    EmployeeDto create(EmployeeDto employee);

    EmployeeDto update(Long id, EmployeeDto employee);

    EmployeeDto updateDepartment(Long empId, Long deptId);

    long deleteById(Long id);
}
