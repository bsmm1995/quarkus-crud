package com.bsmm.quarkus.domain.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDto {
    private Long id;
    private String first_name;
    private String last_name;
    private String gender;
    private LocalDate birth_date;
    private LocalDate hire_date;
    public DepartmentDto department;
}
