package com.nagarro.java.training.flightSearch.sort.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nagarro.java.training.flightSearch.dto.FlightSearchOutputDTO;
import com.nagarro.java.training.flightSearch.sort.SortResults;

@Component
public class SortByFareAndDuration implements SortResults {
	
	@Override
	public List<FlightSearchOutputDTO> sortFlightList(List<FlightSearchOutputDTO> filteredFlights) {

		filteredFlights = new SortByFare().sortFlightList(filteredFlights);
		
		Collections.sort(filteredFlights, byFareAndDurationComparator);
		
		return filteredFlights;
		
	}
	
	private Comparator<FlightSearchOutputDTO> byFareAndDurationComparator = new Comparator<FlightSearchOutputDTO>(){
		
		public int compare(FlightSearchOutputDTO flight1, FlightSearchOutputDTO flight2){
			
			Double duration1 = flight1.getFlightDuration();
			
			Double duration2 = flight2.getFlightDuration();
			
			Integer fare1 = flight1.getFare();
			
			Integer fare2 = flight2.getFare();
			
			if(fare1.compareTo(fare2) == 0){
			
				return duration1.compareTo(duration2);
			
			}else{
				
				return fare1.compareTo(fare2);
			}
		}
	};
	
}
