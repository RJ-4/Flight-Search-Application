package com.nagarro.java.training.flightSearch.sort;

import java.util.List;

import com.nagarro.java.training.flightSearch.dto.FlightSearchOutputDTO;

public interface SortResults {

	public List<FlightSearchOutputDTO> sortFlightList(List<FlightSearchOutputDTO> filteredFlights);
}
