package com.fnb.coindispensesystem.rest;

/**
 * 
 * @author Benny Pholo
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.annotations.Param;

import com.fnb.coindispensesystem.data.UserRepository;
import com.fnb.coindispensesystem.model.Users;

@Path("/user")
@RequestScoped
@Stateful
public class UserService {

	@Inject
	private UserRepository userrepo;

	//http://localhost:8080/CoinDispenseSystem/rest/user/?{%22username%22:%22as%22,%22password%22:%22a%22}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkLoginDetails(@QueryParam("username")String username,@QueryParam("password") String password) {
		Response.ResponseBuilder builder =null;
		String msg=null;
		boolean found = userrepo.findUser(username,password);
		if (found) {
			System.out.println("Succeessful");
			Map<String, String> responseObj = new HashMap<>();
			responseObj.put("Successful","Logged In");
			builder= Response.ok(Response.Status.ACCEPTED).entity(responseObj);
		} else {
			System.out.println("Erroror");
			msg ="The username or password is incorrect";
			found = false;
			//throw new WebApplicationException(Response.Status.BAD_REQUEST);
			Map<String, String> responseObj = new HashMap<>();
			responseObj.put("error",msg);
			builder= Response.status(Response.Status.BAD_REQUEST).entity(responseObj);			
		}
		
		return builder.build();
	}

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Users> getAllUsers() {
		return userrepo.lookupUsers();
	}
}
