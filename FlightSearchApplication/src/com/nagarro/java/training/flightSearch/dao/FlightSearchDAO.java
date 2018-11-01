package com.nagarro.java.training.flightSearch.dao;

import java.util.List;

import com.nagarro.java.training.flightSearch.dto.FlightSearchInputDTO;
import com.nagarro.java.training.flightSearch.models.Flight;

public interface FlightSearchDAO {

	public List<Flight> getFlights(FlightSearchInputDTO flightSearchInputDTO) throws Exception ;
	
}
