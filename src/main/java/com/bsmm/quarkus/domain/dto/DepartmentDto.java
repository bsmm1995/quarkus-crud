package com.bsmm.quarkus.domain.dto;


import com.bsmm.quarkus.domain.dto.outs.EmployeeOutDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto implements Serializable {
    @Null
    private Long id;
    @NotEmpty
    private String name;
    public List<EmployeeOutDto> employees = new ArrayList<>();
}