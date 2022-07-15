package com.bsmm.quarkus.service.impl;


import com.bsmm.quarkus.domain.dto.DepartmentDto;
import com.bsmm.quarkus.domain.entity.DepartmentEntity;
import com.bsmm.quarkus.service.DepartmentService;
import com.bsmm.quarkus.util.DepartmentMapper;

import javax.inject.Singleton;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@Singleton
public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public DepartmentDto getDepartment(Long id) {
        Optional<DepartmentEntity> optionalDepartment = DepartmentEntity.findByIdOptional(id);
        DepartmentEntity department = optionalDepartment.orElseThrow(NotFoundException::new);
        return DepartmentMapper.toDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        return DepartmentMapper.toDtos(DepartmentEntity.listAll());
    }

    @Override
    @Transactional
    public DepartmentDto createDepartment(DepartmentDto department) {

        DepartmentEntity entity = DepartmentMapper.toEntity(department);
        DepartmentEntity.persist(entity);

        if (entity.isPersistent()) {
            Optional<DepartmentEntity> optionalDept = DepartmentEntity.findByIdOptional(entity.id);
            entity = optionalDept.orElseThrow(NotFoundException::new);
            return DepartmentMapper.toDto(entity);
        } else {
            throw new PersistenceException();
        }
    }
}
