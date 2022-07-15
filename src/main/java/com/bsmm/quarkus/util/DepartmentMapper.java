package com.bsmm.quarkus.util;

import com.bsmm.quarkus.domain.dto.DepartmentDto;
import com.bsmm.quarkus.domain.entity.DepartmentEntity;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentMapper {
    private static final ModelMapper MAPPER = new ModelMapper();

    public static DepartmentEntity toEntity(DepartmentDto dto) {
        return MAPPER.map(dto, DepartmentEntity.class);
    }

    public static DepartmentDto toDto(DepartmentEntity entity) {
        return MAPPER.map(entity, DepartmentDto.class);
    }

    public static List<DepartmentEntity> toEntities(List<DepartmentDto> dtos) {
        return dtos.stream().map(DepartmentMapper::toEntity).collect(Collectors.toList());
    }

    public static List<DepartmentDto> toDtos(List<DepartmentEntity> entities) {
        return entities.stream().map(DepartmentMapper::toDto).collect(Collectors.toList());
    }
}
