package com.bsmm.quarkus.domain.dto;


import com.bsmm.quarkus.domain.dto.outs.EmployeeOutDto;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class DepartmentDto implements Serializable {
    @Null
    private Long id;
    @NotEmpty
    private String name;
    private List<EmployeeOutDto> employees = new ArrayList<>();
}