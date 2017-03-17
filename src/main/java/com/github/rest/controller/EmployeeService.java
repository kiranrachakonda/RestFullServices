package com.github.rest.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.rest.dao.Employee;
import com.github.rest.dao.EmployeeDAO;
 

/**
 * 
 * @author kiran.rachakonda
 * Date : 17th Mar, 2017
 * EmployeeService to create new employee
 * and update employee and delete and search employees..
 *
 */
 
 
@Path("/employees")
public class EmployeeService {
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployee() {
        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> employees = dao.getEmployees();
       return employees;
    }
 
    
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEmployee(Employee emp){
        emp.setName(emp.getName());
        emp.setAge(emp.getAge());
                
        EmployeeDAO dao = new EmployeeDAO();
        dao.addEmployee(emp);
        
        return Response.ok().build();
    }
    
    @PUT
    @Path("/update/{id}")
    @Consumes("application/json")
    public Response updateEmployee(@PathParam("id") int id, Employee emp){
        EmployeeDAO dao = new EmployeeDAO();
        int count = dao.updateEmployee(id, emp);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
    
    @DELETE
    @Path("/delete/{id}")
    @Consumes("application/json")
    public Response deleteEmployee(@PathParam("id") int id){
        EmployeeDAO dao = new EmployeeDAO();
        int count = dao.deleteEmployee(id);
        if(count==0){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }
}
	