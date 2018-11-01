package com.nagarro.java.training.flightSearch.services;

import java.time.LocalDate;
import java.util.List;

import com.nagarro.java.training.flightSearch.dto.FlightSearchOutputDTO;
import com.nagarro.java.training.flightSearch.models.Flight;


public interface SearchFlightsService {

	public List<FlightSearchOutputDTO> searchFlights(Flight currentInputSelection, LocalDate departureDate, 
													String flightClass, String outputPreference) throws Exception;
}
