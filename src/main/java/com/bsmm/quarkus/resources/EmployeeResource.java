package com.bsmm.quarkus.resources;


import com.bsmm.quarkus.domain.dto.EmployeeDto;
import com.bsmm.quarkus.service.impl.EmployeeServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    @Inject
    EmployeeServiceImpl empService;

    @GET
    @Path("/{id}")
    public EmployeeDto getEmployee(@PathParam(value = "id") Long id) {
        return empService.getById(id);
    }

    @GET
    @Path("/department/{departmentId}")
    public List<EmployeeDto> getByDepartmentId(@PathParam(value = "departmentId") Long departmentId) {
        return empService.getByDepartmentId(departmentId);
    }

    @GET
    @Path("/search/{name}")
    public List<EmployeeDto> getByName(@PathParam(value = "name") String name) {
        return empService.getByName(name);
    }

    @GET
    public List<EmployeeDto> getAll() {
        return empService.getAll();
    }

    @POST
    public EmployeeDto createEmployee(EmployeeDto employee) {
        return empService.create(employee);
    }

    @PUT
    @Path("/{id}")
    public EmployeeDto updateEmployee(@PathParam(value = "id") Long id, EmployeeDto employee) {
        return empService.update(id, employee);
    }

    @PATCH
    @Path("/{id}/department/{departmentId}")
    public EmployeeDto updateEmpDepartment(@PathParam(value = "id") Long id, @PathParam(value = "departmentId") Long departmentId) {
        return empService.updateDepartment(id, departmentId);
    }

    @DELETE
    @Path("/{id}")
    public Long deleteEmployee(@PathParam(value = "id") Long id) {
        return empService.deleteById(id);
    }
}
