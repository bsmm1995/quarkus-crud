package com.bsmm.quarkus.util;

import com.bsmm.quarkus.domain.dto.EmployeeDto;
import com.bsmm.quarkus.domain.entity.EmployeeEntity;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapper {
    private static final ModelMapper MAPPER = new ModelMapper();

    private EmployeeMapper() {
    }

    public static EmployeeEntity toEntity(EmployeeDto dto) {
        return MAPPER.map(dto, EmployeeEntity.class);
    }

    public static EmployeeDto toDto(EmployeeEntity entity) {
        return MAPPER.map(entity, EmployeeDto.class);
    }

    public static List<EmployeeEntity> toEntities(List<EmployeeDto> dtos) {
        return dtos.stream().map(EmployeeMapper::toEntity).collect(Collectors.toList());
    }

    public static List<EmployeeDto> toDtos(List<EmployeeEntity> entities) {
        return entities.stream().map(EmployeeMapper::toDto).collect(Collectors.toList());
    }
}
