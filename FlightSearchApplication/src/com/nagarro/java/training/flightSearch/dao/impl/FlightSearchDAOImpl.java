package com.nagarro.java.training.flightSearch.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.java.training.flightSearch.dao.FlightSearchDAO;
import com.nagarro.java.training.flightSearch.dto.FlightSearchInputDTO;
import com.nagarro.java.training.flightSearch.models.Flight;

import static com.nagarro.java.training.flightSearch.constants.Constants.*;

@Repository
public class FlightSearchDAOImpl implements FlightSearchDAO {

	@Autowired
	SessionFactory factory;
	
	@Override
	@Transactional
	public List<Flight> getFlights(FlightSearchInputDTO flightSearchInputDTO) throws Exception {
		
		Session session = factory.getCurrentSession();
		
		String getFlightsQuery = GET_FLIGHTS_QUERY;
	
		Query query = session.createQuery(getFlightsQuery);
		
		query.setParameter(DEAPARTURE_LOCATION_QUERY_LABEL, flightSearchInputDTO.getDepartureLocation());
		
		query.setParameter(ARRIVAL_LOCATION_QUERY_LABEL, flightSearchInputDTO.getArrivalLocation());
		
		query.setParameter(VALID_TILL_QUERY_LABEL, flightSearchInputDTO.getDepartureDate());
		
		query.setParameter(FLIGHT_CLASS_QUERY_LABEL, "%" + flightSearchInputDTO.getFlightClass().charAt(0) + "%");
		
		List<Flight> filteredFlights = (List<Flight>)query.getResultList();
		
		return filteredFlights;
	
	}

}
