package com.bsmm.quarkus.domain.dto;


import com.bsmm.quarkus.domain.dto.outs.DepartmentOutDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate birthDate;
    private LocalDate hireDate;
    public DepartmentOutDto department;
}
