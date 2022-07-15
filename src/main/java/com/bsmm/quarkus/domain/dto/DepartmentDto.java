package com.bsmm.quarkus.domain.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class DepartmentDto implements Serializable {
    private Long id;
    private String name;
    public List<EmployeeDto> employees = new ArrayList<>();
}