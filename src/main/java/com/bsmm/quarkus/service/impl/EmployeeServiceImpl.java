package com.bsmm.quarkus.service.impl;


import com.bsmm.quarkus.domain.dto.EmployeeDto;
import com.bsmm.quarkus.domain.entity.DepartmentEntity;
import com.bsmm.quarkus.domain.entity.EmployeeEntity;
import com.bsmm.quarkus.service.EmployeeService;
import com.bsmm.quarkus.util.EmployeeMapper;

import javax.inject.Singleton;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Singleton
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public EmployeeDto getEmployee(Long id) {
        return EmployeeMapper.toDto(EmployeeEntity.findById(id));
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return EmployeeMapper.toDtos(EmployeeEntity.findAll().list());
    }

    @Override
    public List<EmployeeDto> getEmployeesByDepartment(Long deptId) {
        return EmployeeMapper.toDtos(EmployeeEntity.findEmployeesByDepartmentId(deptId));
    }

    @Override
    public List<EmployeeDto> searchEmpsByName(String name) {
        return EmployeeMapper.toDtos(EmployeeEntity.searchEmpsByName(name));
    }

    @Override
    @Transactional
    public EmployeeDto createEmployee(EmployeeDto employee) {
        EmployeeEntity entity = EmployeeMapper.toEntity(employee);
        EmployeeEntity.persist(entity);
        entity.persistAndFlush();
        if (entity.isPersistent()) {
            Optional<EmployeeEntity> optionalEmp = EmployeeEntity.findByIdOptional(entity.id);
            entity = optionalEmp.orElseThrow(NotFoundException::new);
            return EmployeeMapper.toDto(entity);
        } else {
            throw new PersistenceException();
        }

    }

    @Override
    @Transactional
    public EmployeeDto updateEmployee(Long id, EmployeeDto employee) {
        EmployeeEntity entity = EmployeeEntity.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Employee with id of " + id + " does not exist.", 404);
        }
        return EmployeeMapper.toDto(entity);
    }

    @Override
    @Transactional
    public EmployeeDto updateEmployee(EmployeeDto employee) {
        EmployeeEntity entity = EmployeeEntity.findById(employee.getId());
        if (entity == null) {
            throw new WebApplicationException("Employee with id " + employee.getId() + " does not exist.", 404);
        }
        entity = EmployeeEntity.getEntityManager().merge(entity);
        return EmployeeMapper.toDto(entity);
    }

    @Override
    @Transactional
    public EmployeeDto updateEmpDepartment(Long empId, DepartmentEntity department) {
        EmployeeEntity entity = EmployeeEntity.findById(empId);
        if (entity == null) {
            throw new WebApplicationException("Employee with id " + empId + " does not exist.", 404);
        }
        entity.department = department;
        return EmployeeMapper.toDto(entity);
    }

    @Override
    @Transactional
    public EmployeeDto updateEmpDepartment(Long empId, Long deptId) {
        EmployeeEntity entity = EmployeeEntity.findById(empId);
        if (entity == null) {
            throw new WebApplicationException("Employee with id " + empId + " does not exist.", 404);
        }
        Optional<DepartmentEntity> department = DepartmentEntity.findByIdOptional(deptId);
        department.ifPresent(departmentEntity -> entity.department = departmentEntity);
        return EmployeeMapper.toDto(entity);
    }

    @Override
    @Transactional
    public Response deleteEmployee(Long id) {
        boolean isEntityDeleted = EmployeeEntity.deleteById(id);
        if (!isEntityDeleted) {
            throw new WebApplicationException("Employee with id of " + id + " does not exist.", 404);
        }
        return Response.status(204).build();
    }
}
