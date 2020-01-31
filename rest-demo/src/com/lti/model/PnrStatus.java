package com.lti.model;

import java.time.LocalDate;
import java.util.List;

public class PnrStatus {

	private long pnrNo;
	private int trainNo;
	private LocalDate travelDate;
	
	private List<Passenger> passengers;

	public PnrStatus() {
	}
	
	public PnrStatus(long pnrNo, int trainNo, LocalDate travelDate, List<Passenger> passengers) {
		super();
		this.pnrNo = pnrNo;
		this.trainNo = trainNo;
		this.travelDate = travelDate;
		this.passengers = passengers;
	}

	
	
	public long getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(long pnrNo) {
		this.pnrNo = pnrNo;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	
}
