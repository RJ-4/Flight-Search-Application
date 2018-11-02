package com.nagarro.java.training.flightSearch.constants;

public class Constants {

	public static final String BASE_PACKAGE_FOR_SCAN = "com.nagarro.java.training.flightSearch";
	
	public static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/views/";
	
	public static final String VIEW_RESOLVER_SUFFIX = ".jsp";
	
	public static final String RESOURCE_HANDLER = "/resources/**";
	
	public static final String RESOURCE_LOCATION = "/resources/";
	
	public static final String COMPONENT_SCAN = "{" + BASE_PACKAGE_FOR_SCAN + "}";
	
	public static final String HIBERNATE_CONFIG_PROPERTIES_LOCATION = "classpath:application.properties";
	
	public static final String LOGIN_PAGE = "login";
	
	public static final String LOGIN_PAGE_MAPPING = "/" + LOGIN_PAGE;
	
	public static final String USER_MODEL = "user";
	
	public static final String LOGIN_JSP_PAGE_PATH = "log-in";
	
	public static final String SIGN_UP_JSP_PAGE_PATH = "sign-up";
	
	public static final String SIGN_UP_PAGE_MAPPING = "/" + SIGN_UP_JSP_PAGE_PATH;
	
	public static final String LOGIN_CONTROLLER_MAPPING = "/loginUser";
	
	public static final String FLIGHTS_MODEL = "flights";
	
	public static final String SEARCH_FLIGHTS_JSP_PAGE_PATH = "search-flights";
	
	public static final String SEARCH_FLIGHTS_CONTROLLER_MAPPING = "/searchFlights";
	
	public static final String SIGN_UP_CONTROLLER_MAPPING = "/signUp";
	
	public static final String DEAPARTURE_LOCATION_QUERY_LABEL = "departureLocation";
	
	public static final String ARRIVAL_LOCATION_QUERY_LABEL = "arrivalLocation";
	
	public static final String VALID_TILL_QUERY_LABEL = "validTill";
	
	public static final String FLIGHT_CLASS_QUERY_LABEL = "flightClass";
	
	public static final String GET_FLIGHTS_QUERY = "FROM Flight WHERE departureLocation = :" + DEAPARTURE_LOCATION_QUERY_LABEL
													+ " AND arrivalLocation = :" + ARRIVAL_LOCATION_QUERY_LABEL
													+ " AND validTill >= :" + VALID_TILL_QUERY_LABEL
													+ " AND flightClass LIKE :" + FLIGHT_CLASS_QUERY_LABEL 
													+ " AND seatAvailability = 'Y'";
	
	public static final String USERNAME_LABEL = "username";
	
	public static final String PASSWORD_LABEL = "password";
	
	public static final String LOGIN_QUERY = "FROM User where username = :" + USERNAME_LABEL +  
												" AND password = :" + PASSWORD_LABEL;
	
	public static final String FLIGHTS_TABLE_NAME = "flights";
	
	public static final String FLIGHTS_TABLE_ID_COLUMN = "id";
	
	public static final String FLIGHTS_TABLE_FLIGHT_NUMBER_COLUMN = "flight_number";
	
	public static final String FLIGHTS_TABLE_DEPARTURE_LOCATION_COLUMN = "departure_location";
	
	public static final String FLIGHTS_TABLE_ARRIVAL_LOCATION_COLUMN = "arrival_location";
	
	public static final String FLIGHTS_TABLE_VALID_TILL_COLUMN = "valid_till";
	
	public static final String FLIGHTS_TABLE_FLIGHT_DURATION_COLUMN = "flight_duration";
	
	public static final String FLIGHTS_TABLE_FLIGHT_TIME_COLUMN = "flight_time";
	
	public static final String FLIGHTS_TABLE_FARE_COLUMN = "fare";
	
	public static final String FLIGHTS_TABLE_SEAT_AVAILABILITY_COLUMN = "seat_availability";
	
	public static final String FLIGHTS_TABLE_FLIGHT_CLASS_COLUMN = "flight_class";
	
	public static final String DEPARTURE_LOCATION_VALIDATION_MESSAGE = "Departure Location cannot be empty!!!";
	
	public static final String ARRIVAL_LOCATION_VALIDATION_MESSAGE = "Arrival Location cannot be empty!!!";
	
	public static final String USER_TABLE_TABLE_NAME = "user";
	
	public static final String USER_TABLE_USERNAME_COLUMN = "username";
	
	public static final String USER_TABLE_PASSWORD_COLUMN = "password";
	
	public static final String USER_TABLE_USERNAME_VALIDATION_MESSAGE = "Username cannot be empty";
	
	public static final String USER_TABLE_PASSWORD_VALIDATION_MESSAGE = "Password cannot be empty";
	
	public static final String SORT_BY_FARE = "Sort by Fare";

	public static final String SORT_BY_FARE_AND_DURATION = "Sort by Fare and Duration" ;
	
	public static final String BUSINESS_CLASS = "Business";
	
	public static final String LOGOUT_JSP_PAGE_PATH = "log-out";
	
	public static final String LOGOUT_PAGE_MAPPING = "/logout";
	
}
