package com.nagarro.java.training.flightSearch.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.nagarro.java.training.flightSearch.constants.Constants.*;

@Entity
@Table(name = FLIGHTS_TABLE_NAME)
public class Flight {

	@Id
	@Column(name = FLIGHTS_TABLE_ID_COLUMN)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = FLIGHTS_TABLE_FLIGHT_NUMBER_COLUMN)
	private String flightNumber;
	
	@Column(name = FLIGHTS_TABLE_DEPARTURE_LOCATION_COLUMN)
	@NotNull(message = DEPARTURE_LOCATION_VALIDATION_MESSAGE)
	@Size(min = 1, message = DEPARTURE_LOCATION_VALIDATION_MESSAGE)
	private String departureLocation;
	
	@Column(name = FLIGHTS_TABLE_ARRIVAL_LOCATION_COLUMN)
	@NotNull(message = ARRIVAL_LOCATION_VALIDATION_MESSAGE)
	@Size(min = 1, message = ARRIVAL_LOCATION_VALIDATION_MESSAGE)
	private String arrivalLocation;
	
	@Column(name = FLIGHTS_TABLE_VALID_TILL_COLUMN)
	private LocalDate validTill;
	
	@Column(name = FLIGHTS_TABLE_FLIGHT_TIME_COLUMN)
	private int flightTime;
	
	@Column(name = FLIGHTS_TABLE_FLIGHT_DURATION_COLUMN)
	private double flightDuration;
	
	@Column(name = FLIGHTS_TABLE_FARE_COLUMN)
	private int fare;
	
	@Column(name = FLIGHTS_TABLE_SEAT_AVAILABILITY_COLUMN)
	private String seatAvailability;
	
	@Column(name = FLIGHTS_TABLE_FLIGHT_CLASS_COLUMN)
	private String flightClass;
	
	public int getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(int flightTime) {
		this.flightTime = flightTime;
	}

	public double getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(double flightDuration) {
		this.flightDuration = flightDuration;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public String getSeatAvailability() {
		return seatAvailability;
	}

	public void setSeatAvailability(String seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

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


	public LocalDate getValidTill() {
		return validTill;
	}

	public void setValidTill(LocalDate validTill) {
		this.validTill = validTill;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}
}
