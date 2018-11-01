package com.nagarro.java.training.flightSearch.models;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "flights")
public class Flight {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "flight_number")
	private String flightNumber;
	
	@Column(name = "departure_location")
	@NotNull(message = "Departure Location cannot be empty!!!")
	@Size(min = 1, message = "Departure Location cannot be empty!!!")
	private String departureLocation;
	
	@Column(name = "arrival_location")
	@NotNull(message = "Departure Location cannot be empty!!!")
	@Size(min = 1, message = "Departure Location cannot be empty!!!")
	private String arrivalLocation;
	
	@Column(name = "valid_till")
	private LocalDate validTill;
	
	@Column(name = "flight_time")
	private int flightTime;
	
	@Column(name = "flight_duration")
	private double flightDuration;
	
	@Column(name = "fare")
	private int fare;
	
	@Column(name = "seat_availability")
	private String seatAvailability;
	
	@Column(name = "flight_class")
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
