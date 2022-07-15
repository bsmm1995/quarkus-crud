package com.bsmm.quarkus.controller;


import com.bsmm.quarkus.domain.dto.DepartmentDto;
import com.bsmm.quarkus.service.DepartmentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/departments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentController {

    @Inject
    DepartmentService departmentService;


    @GET
    @Path("/{id}")
    public DepartmentDto getDepartment(@PathParam(value = "id") Long id) {
        return departmentService.getDepartment(id);
    }

    @GET
    public List<DepartmentDto> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @POST
    public DepartmentDto createEmployee(DepartmentDto department) {
        return departmentService.createDepartment(department);
    }

}