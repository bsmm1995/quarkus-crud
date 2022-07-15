package com.bsmm.quarkus.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "EMPLOYEE")
public class EmployeeEntity extends PanacheEntity {
    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    public String gender;

    @Column(name = "birth_date")
    public LocalDate birthDate;

    @Column(name = "hire_date")
    public LocalDate hireDate;

    @ManyToOne(fetch = FetchType.LAZY)
    public DepartmentEntity department;

    public static List<EmployeeEntity> findEmployeesByDepartmentId(Long departmentId) {
        return find("department.id", departmentId).list();
    }

    public static List<EmployeeEntity> searchEmpsByName(String name) {
        return find("first_name like CONCAT('%',?1, '%') ", name).list();
    }
}
