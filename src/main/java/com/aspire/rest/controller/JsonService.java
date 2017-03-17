package com.aspire.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.aspire.rest.dto.Customer;

@Path("/json")
public class JsonService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getTrackInJSON() {

		Customer customer =  new Customer();
		customer.setAge("12");
		customer.setName("122");
		customer.setPin(122);
		return customer;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Customer track) {

		String result = "Track saved : " + track;
		return Response.status(201).entity(result).build();

	}
	
}
