package com.bsmm.quarkus.service.impl;


import com.bsmm.quarkus.domain.dto.EmployeeDto;
import com.bsmm.quarkus.domain.entity.DepartmentEntity;
import com.bsmm.quarkus.domain.entity.EmployeeEntity;
import com.bsmm.quarkus.service.EmployeeService;
import com.bsmm.quarkus.util.EmployeeMapper;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.inject.Singleton;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import java.util.List;
import java.util.Optional;

@Singleton
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public EmployeeDto getById(long id) {
        return EmployeeMapper.toDto(getEntityById(id));
    }

    @Override
    public List<EmployeeDto> getByDepartmentId(long deptId) {
        return EmployeeMapper.toDtos(EmployeeEntity.findEmployeesByDepartmentId(deptId));
    }

    @Override
    public List<EmployeeDto> getByName(String name) {
        return EmployeeMapper.toDtos(EmployeeEntity.searchEmpsByName(name));
    }

    @Override
    public List<EmployeeDto> getAll() {
        return EmployeeMapper.toDtos(PanacheEntityBase.findAll().list());
    }

    @Override
    @Transactional
    public EmployeeDto create(EmployeeDto employee) {
        EmployeeEntity entity = EmployeeMapper.toEntity(employee);
        PanacheEntityBase.persist(entity);
        entity.persistAndFlush();
        if (entity.isPersistent()) {
            entity = getEntityById(entity.id);
            return EmployeeMapper.toDto(entity);
        } else {
            throw new PersistenceException();
        }
    }

    @Override
    @Transactional
    public EmployeeDto update(long id, EmployeeDto employee) {
        EmployeeEntity entity = getEntityById(id);
        entity.setLastName(employee.getLastName());
        entity.setFirstName(employee.getFirstName());
        PanacheEntityBase.persist(entity);
        return EmployeeMapper.toDto(entity);
    }

    @Override
    @Transactional
    public EmployeeDto updateDepartment(long id, long deptId) {
        EmployeeEntity entity = getEntityById(id);
        Optional<DepartmentEntity> department = PanacheEntityBase.findByIdOptional(deptId);
        department.ifPresent(departmentEntity -> {
            entity.department = departmentEntity;
            PanacheEntityBase.persist(entity);
        });
        return EmployeeMapper.toDto(entity);
    }

    @Override
    @Transactional
    public long deleteById(long id) {
        boolean isEntityDeleted = PanacheEntityBase.deleteById(id);
        if (!isEntityDeleted) {
            throw new WebApplicationException("Employee with id of " + id + " does not exist.", 404);
        }
        return id;
    }

    private EmployeeEntity getEntityById(long id) {
        Optional<EmployeeEntity> optional = PanacheEntityBase.findByIdOptional(id);
        if (optional.isEmpty()) {
            webApplicationException(id);
        }
        return optional.get();
    }

    private void webApplicationException(long id) {
        throw new WebApplicationException("Employee with id of " + id + " does not exist.", 404);
    }

}
