package com.nagarro.java.training.flightSearch.validations.impl;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;

import com.nagarro.java.training.flightSearch.validations.Validations;

@Component
public class ValidationsImpl implements Validations{

	public void checkForWhiteSpaces(WebDataBinder dataBinder) {
		
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, editor);
	}
}
