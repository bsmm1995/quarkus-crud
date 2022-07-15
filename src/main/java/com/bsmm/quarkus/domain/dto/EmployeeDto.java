package com.bsmm.quarkus.domain.dto;


import com.bsmm.quarkus.domain.dto.outs.DepartmentOutDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public DepartmentOutDto department;
}
