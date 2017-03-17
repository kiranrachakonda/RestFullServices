package com.aspire.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWordService {

	@GET
	@Path("/{message}")
	public Response getMessage(@PathParam("message") String message) {
		String returnMessage = "Jersey Say :" + message;
		return Response.status(200).entity(returnMessage).build();
	}
}
