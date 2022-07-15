package com.bsmm.quarkus.domain.dto.outs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeOutDto {
    private Long id;
    private String firstName;
    private String lastName;
}
