package com.nagarro.java.training.flightSearch.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.java.training.flightSearch.dao.FlightSearchDAO;
import com.nagarro.java.training.flightSearch.dto.FlightSearchInputDTO;
import com.nagarro.java.training.flightSearch.dto.FlightSearchOutputDTO;
import com.nagarro.java.training.flightSearch.models.Flight;
import com.nagarro.java.training.flightSearch.modifyFare.ModifyFare;
import com.nagarro.java.training.flightSearch.services.SearchFlightsService;

@Service
public class SearchFlightsServiceImpl implements SearchFlightsService {

	@Autowired
	FlightSearchInputDTO flightSearchInputDTO;
	
	FlightSearchOutputDTO flightSearchOutputDTO;
	
	@Autowired
	ModifyFare modifyFare;
	
	@Autowired
	FlightSearchDAO flightSearchDAO;
	
	@Override
	public List<FlightSearchOutputDTO> searchFlights(Flight currentInputSelection, LocalDate departureDate, 
													String flightClass, String outputPreference) throws Exception{
	
		initializeInputDTO(currentInputSelection, departureDate, flightClass, outputPreference);
		
		List<Flight> filteredFlights = flightSearchDAO.getFlights(flightSearchInputDTO);
		
		List<FlightSearchOutputDTO> filteredFlightsDTO = new ArrayList<FlightSearchOutputDTO>();
		
		for(Flight filteredFlight: filteredFlights){
		
			filteredFlightsDTO.add(initializeOutputDTO(filteredFlight));
		
		}
		
		filteredFlightsDTO = modifyFare(filteredFlightsDTO, flightClass);
		
		return filteredFlightsDTO;
	}
	
	private List<FlightSearchOutputDTO> modifyFare(List<FlightSearchOutputDTO> filteredFlights, 
													String flightClass) {
		
		for(FlightSearchOutputDTO filteredFlight: filteredFlights) {
			
			if(flightClass.equals("Business")){
				
				filteredFlight.setFare(modifyFare.modifyFare(filteredFlight.getFare()));
			}
			
		}
		
		return filteredFlights;
	}
	
	private FlightSearchOutputDTO initializeOutputDTO(Flight filteredFlight) {
		
		flightSearchOutputDTO = new FlightSearchOutputDTO();
		
		flightSearchOutputDTO.setDepartureLocation(filteredFlight.getDepartureLocation());
		
		flightSearchOutputDTO.setArrivalLocation(filteredFlight.getArrivalLocation());
		
		flightSearchOutputDTO.setValidTill(filteredFlight.getValidTill());
		
		flightSearchOutputDTO.setFlightNumber(filteredFlight.getFlightNumber());
		
		flightSearchOutputDTO.setFlightTime(filteredFlight.getFlightTime());
		
		flightSearchOutputDTO.setFlightDuration(filteredFlight.getFlightDuration());
		
		flightSearchOutputDTO.setFare(filteredFlight.getFare());
		
		flightSearchOutputDTO.setSeatAvailability(filteredFlight.getSeatAvailability());
		
		flightSearchOutputDTO.setFlightClass(filteredFlight.getFlightClass());
		
		return flightSearchOutputDTO;
		
	}
	
	private void initializeInputDTO(Flight currentInputSelection, LocalDate departureDate, 
										String flightClass, String outputPreference) {
		
		flightSearchInputDTO.setDepartureLocation(currentInputSelection.getDepartureLocation());
		
		flightSearchInputDTO.setArrivalLocation(currentInputSelection.getArrivalLocation());
		
		flightSearchInputDTO.setDepartureDate(departureDate);
		
		flightSearchInputDTO.setFlightClass(flightClass);
		
		flightSearchInputDTO.setOutputPreference(outputPreference);
	}

}