package com.bsmm.quarkus.resources;


import com.bsmm.quarkus.domain.dto.DepartmentDto;
import com.bsmm.quarkus.service.impl.DepartmentServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/departments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentResource {

    @Inject
    DepartmentServiceImpl departmentService;

    @GET
    @Path("/{id}")
    public DepartmentDto getById(@PathParam(value = "id") Long id) {
        return departmentService.getById(id);
    }

    @GET
    public List<DepartmentDto> getAll() {
        return departmentService.getAll();
    }

    @POST
    public DepartmentDto create(DepartmentDto department) {
        return departmentService.create(department);
    }
}