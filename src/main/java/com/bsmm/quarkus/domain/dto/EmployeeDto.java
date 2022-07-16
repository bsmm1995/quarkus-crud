package com.bsmm.quarkus.domain.dto;


import com.bsmm.quarkus.domain.dto.outs.DepartmentOutDto;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
public class EmployeeDto {
    @Null
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String gender;
    @Past
    private LocalDate birthDate;
    private LocalDate hireDate;
    private DepartmentOutDto department;
}
