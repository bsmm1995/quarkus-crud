package com.bsmm.quarkus.service;

import com.bsmm.quarkus.domain.dto.EmployeeDto;
import com.bsmm.quarkus.domain.entity.DepartmentEntity;

import javax.ws.rs.core.Response;
import java.util.List;

public interface EmployeeService {

    EmployeeDto getEmployee(Long id);

    List<EmployeeDto> getAllEmployees();

    List<EmployeeDto> getEmployeesByDepartment(Long deptId);

    List<EmployeeDto> searchEmpsByName(String name);

    EmployeeDto createEmployee(EmployeeDto employee);

    EmployeeDto updateEmployee(Long id, EmployeeDto employee);

    EmployeeDto updateEmployee(EmployeeDto employee);

    EmployeeDto updateEmpDepartment(Long empId, DepartmentEntity department);

    EmployeeDto updateEmpDepartment(Long empId, Long deptId);

    Response deleteEmployee(Long id);
}
