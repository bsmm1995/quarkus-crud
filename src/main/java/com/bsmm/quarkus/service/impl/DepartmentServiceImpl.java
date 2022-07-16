package com.bsmm.quarkus.service.impl;


import com.bsmm.quarkus.domain.dto.DepartmentDto;
import com.bsmm.quarkus.domain.entity.DepartmentEntity;
import com.bsmm.quarkus.service.DepartmentService;
import com.bsmm.quarkus.util.DepartmentMapper;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.inject.Singleton;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import java.util.List;
import java.util.Optional;

@Singleton
public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public DepartmentDto getById(long id) {
        return DepartmentMapper.toDto(getEntityById(id));
    }

    @Override
    public List<DepartmentDto> getAll() {
        return DepartmentMapper.toDtos(PanacheEntityBase.listAll());
    }

    @Override
    @Transactional
    public DepartmentDto create(DepartmentDto department) {
        DepartmentEntity entity = DepartmentMapper.toEntity(department);
        PanacheEntityBase.persist(entity);
        return DepartmentMapper.toDto(entity);
    }

    @Override
    @Transactional
    public DepartmentDto update(long id, DepartmentDto department) {
        DepartmentEntity entity = getEntityById(id);
        entity.setName(department.getName());
        PanacheEntityBase.persist(entity);
        return DepartmentMapper.toDto(entity);
    }

    @Override
    @Transactional
    public long deleteById(long id) {
        if (!PanacheEntityBase.deleteById(id)) {
            webApplicationException(id);
        }
        return id;
    }

    private DepartmentEntity getEntityById(long id) {
        Optional<DepartmentEntity> optional = PanacheEntityBase.findByIdOptional(id);
        if (optional.isEmpty()) {
            webApplicationException(id);
        }
        return optional.get();
    }

    private void webApplicationException(long id) {
        throw new WebApplicationException("Department with id of " + id + " does not exist.", 404);
    }
}
