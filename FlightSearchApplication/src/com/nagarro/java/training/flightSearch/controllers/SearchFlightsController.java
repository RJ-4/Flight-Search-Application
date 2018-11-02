package com.nagarro.java.training.flightSearch.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.java.training.flightSearch.dto.FlightSearchOutputDTO;
import com.nagarro.java.training.flightSearch.models.Flight;
import com.nagarro.java.training.flightSearch.services.SearchFlightsService;
import com.nagarro.java.training.flightSearch.validations.Validations;

import static com.nagarro.java.training.flightSearch.constants.Constants.*;

@Controller
public class SearchFlightsController {

	@Autowired
	Validations validations;
	
	@Autowired
	SearchFlightsService searchFlightsService;
	
	@InitBinder
	private void checkForWhiteSpaces(WebDataBinder dataBinder) {
		
		validations.checkForWhiteSpaces(dataBinder);
	}
	
	
	@GetMapping(SEARCH_FLIGHTS_CONTROLLER_MAPPING)
	public String searchForFlights(@Valid @ModelAttribute(FLIGHTS_MODEL) Flight currentSelection, 
										BindingResult bindingResult, 
										@RequestParam("departureDate") String date, 
										@RequestParam("flightClass") String flightClass, 
										@RequestParam("sortBy") String outputPreference, 
										Model model) {
		
		
		boolean isFlightsFound = true;
		
		if(bindingResult.hasErrors()) {
			
			return SEARCH_FLIGHTS_JSP_PAGE_PATH;
			
		} else {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
			
			LocalDate departureDate = LocalDate.parse(date, formatter);
			 
			try{
				
				List<FlightSearchOutputDTO> filteredFlights = searchFlightsService.searchFlights(currentSelection,
																								 departureDate, 
																								 flightClass, 
																								 outputPreference);
			
				isFlightsFound = true;
				
				model.addAttribute("isFlightsFound", isFlightsFound);
				
				model.addAttribute("filteredFlights", filteredFlights);
				
				return SEARCH_FLIGHTS_JSP_PAGE_PATH;
				
			} catch(Exception e) {
				
				isFlightsFound = false;
				
				model.addAttribute("isFlightsFound", isFlightsFound);
				
				return SEARCH_FLIGHTS_JSP_PAGE_PATH;
			}
			
		}
	}
}
