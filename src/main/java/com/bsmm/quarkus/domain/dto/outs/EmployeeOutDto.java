package com.bsmm.quarkus.domain.dto.outs;


import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeOutDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
}
