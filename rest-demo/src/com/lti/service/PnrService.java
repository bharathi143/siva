package com.lti.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import com.lti.model.Passenger;
import com.lti.model.Passenger.Gender;
import com.lti.model.Passenger.Status;
import com.lti.model.PnrStatus;

/**
 * 
 * @author IRCTC
 *
 */
@Path("/pnr")
public class PnrService {
	
	@GET// WHICH METHOD OF HTTP (GET,POST,PUT,DELETE...)
	@Produces("application/json") //How will the data be represented? (xml,json)
	public PnrStatus getStatus(@QueryParam("pnrNo")long pnrNo, 
			@Context HttpServletResponse response ) {
		//How will the client send the pnrNo?(QueryParam/PathParam/MatrixParam)
		
		//in a real system, we migth invoke
		//some DAO class from here to get the 
		//pnr status from the databse and then return it
		//for the time begin we will return some dummy data
		
		//enabling CORS
		response.setHeader("Access-Control-Allow-Origin","http://localhost:4200");
		
		PnrStatus pnrStatus = new PnrStatus();
		pnrStatus.setPnrNo(pnrNo);
		pnrStatus.setTrainNo(12345);
		pnrStatus.setTravelDate(LocalDate.of(2020, 02, 10));
		
		Passenger p1 = new Passenger();
		p1.setName("Pooja");
		p1.setAge(21);
		p1.setGender(Gender.FEMALE);
		p1.setStatus(Status.CONFIRMED);
		
		Passenger p2 = new Passenger();
		p2.setName("Tejas");
		p2.setAge(19);
		p2.setGender(Gender.MALE);
		p2.setStatus(Status.WAITING);
		
		Passenger p3 = new Passenger();
		p3.setName("Bharathi");
		p3.setAge(20);
		p3.setGender(Gender.FEMALE);
		p3.setStatus(Status.RAC);
		
		List<Passenger> passengers = new ArrayList<>();
		passengers.add(p1);
		passengers.add(p2);
		passengers.add(p3);
		
		pnrStatus.setPassengers(passengers);
		
		return pnrStatus;
		
	}
	
}
