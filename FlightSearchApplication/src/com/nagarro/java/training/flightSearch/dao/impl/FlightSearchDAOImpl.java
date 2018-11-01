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

@Repository
public class FlightSearchDAOImpl implements FlightSearchDAO {

	@Autowired
	SessionFactory factory;
	
	@Override
	@Transactional
	public List<Flight> getFlights(FlightSearchInputDTO flightSearchInputDTO) throws Exception {
		
		Session session = factory.getCurrentSession();
		
		String getFlightsQuery = "FROM Flight WHERE departureLocation = :departureLocation "
									+ "AND arrivalLocation = :arrivalLocation "
									+ "AND validTill >= :validTill "
									+ "AND flightClass LIKE :flightClass AND seatAvailability = 'Y'";
	
		Query query = session.createQuery(getFlightsQuery);
		
		query.setParameter("departureLocation", flightSearchInputDTO.getDepartureLocation());
		
		query.setParameter("arrivalLocation", flightSearchInputDTO.getArrivalLocation());
		
		query.setParameter("validTill", flightSearchInputDTO.getDepartureDate());
		
		query.setParameter("flightClass", "%" + flightSearchInputDTO.getFlightClass().charAt(0) + "%");
		
		List<Flight> filteredFlights = (List<Flight>)query.getResultList();
		
		System.out.println(filteredFlights);
		
		return filteredFlights;
	
	}

}
