package com.bsmm.quarkus.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "EMPLOYEE")
@Getter
@Setter
public class EmployeeEntity extends PanacheEntity {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private DepartmentEntity department;

    public static List<EmployeeEntity> findEmployeesByDepartmentId(Long departmentId) {
        return find("department.id", departmentId).list();
    }

    public static List<EmployeeEntity> searchEmpsByName(String name) {
        return find("first_name like CONCAT('%',?1, '%') ", name).list();
    }
}
