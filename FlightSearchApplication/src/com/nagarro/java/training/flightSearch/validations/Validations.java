package com.nagarro.java.training.flightSearch.validations;

import org.springframework.web.bind.WebDataBinder;

public interface Validations {

	public void checkForWhiteSpaces(WebDataBinder dataBinder);
	
}
