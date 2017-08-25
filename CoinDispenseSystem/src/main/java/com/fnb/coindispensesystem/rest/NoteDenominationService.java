package com.fnb.coindispensesystem.rest;

/**
 * 
 * @author Benny Pholo
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fnb.coindispensesystem.data.DenominationBreakdownImpl;
import com.fnb.coindispensesystem.model.NotesBreackdown;

@Path("/notes")
@RequestScoped
@Stateful
public class NoteDenominationService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<NotesBreackdown> cashDenominationBreackdown(@QueryParam("notes") BigDecimal notes) {
		DenominationBreakdownImpl db = new DenominationBreakdownImpl();
		//List<NotesBreackdown> results = new ArrayList<>();
		//Response.ResponseBuilder builder = null;
		//NotesBreackdown a = new NotesBreackdown();
		//try {
		//	System.out.println("Calling DenominationBreakdown");
			//results = db.calculateDenomination(notes);
//			for (Object o :results){
//				 a = (NotesBreackdown) o;
//				System.out.println("++++++++++Benn+++++++");
//				System.out.println(a.getName()+a.getValue());
//			}
//			
//			builder = Response.ok().entity(a);
//		} catch (Exception e) {
//			Map<String, String> responseObj = new HashMap<>();
//			responseObj.put("error", e.getMessage());
//			builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
//		}
//		System.out.println("+++++++++++++++++");
//		System.out.println(builder.build());
		return db.calculateDenomination(notes);

	}

}
