package com.github.rest.controller;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/user")
public class UserService {

	@GET
	public Response getUser() {
		return Response.status(200).entity("getUser service called").build();
	}

	@GET
	@Path("/{id : \\d+}") // supports only digits
	public Response getUserByID(@PathParam("id") String userID) {
		return Response.status(200).entity("User found with" + userID).build();
	}

	@GET	
	@Path("/name/{name :[a-zA-Z][a-zA-Z_0-9]}")
	public Response getUserByName(@PathParam("name") String name) {
		return Response.status(200).entity("User find by User name:" + name).build();
	}

	@GET
	@Path("{year}/{month}/{date}")
	public Response getUserHistory(@PathParam("year") String year, @PathParam("month") String month,
			@PathParam("date") String date) {

		return Response.status(200).entity("UserHistory Service called").build();
	}

	@GET
	@Path("/query1")
	public Response getUsers(@QueryParam("from") String from, @QueryParam("to") String to) {

		return Response.status(200).entity("getUser Service called with Query param").build();
	}

	@GET
	@Path("/query2")
	public Response getUsers(@Context UriInfo info) {

		String from = info.getQueryParameters().getFirst("from1");
		String to = info.getQueryParameters().getFirst("to1");
		List<String> orderBy = info.getQueryParameters().get("orderBy");

		return Response.status(200)
				.entity("getUsers is called, from : " + from + ", to : " + to + ", orderBy" + orderBy.toString())
				.build();
	}

	@GET
	@Path("/query")
	public Response getUsers(@DefaultValue("1000") @QueryParam("venu") int from,
			@DefaultValue("999") @QueryParam("reddy") int to) {

		return Response.status(200)
				.entity("hi venu").build();

	}

}
