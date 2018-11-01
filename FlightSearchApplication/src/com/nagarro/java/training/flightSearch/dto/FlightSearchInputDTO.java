package com.nagarro.java.training.flightSearch.dto;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class FlightSearchInputDTO {

	private String departureLocation;
	
	private String arrivalLocation;
	
	private LocalDate departureDate;
	
	private String flightClass;
	
	private String outputPreference;

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public String getOutputPreference() {
		return outputPreference;
	}

	public void setOutputPreference(String outputPreference) {
		this.outputPreference = outputPreference;
	}
	
	
}
