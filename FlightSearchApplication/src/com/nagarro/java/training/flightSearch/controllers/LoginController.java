package com.nagarro.java.training.flightSearch.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarro.java.training.flightSearch.models.Flight;
import com.nagarro.java.training.flightSearch.models.User;
import com.nagarro.java.training.flightSearch.services.LoginService;
import com.nagarro.java.training.flightSearch.validations.Validations;

import static com.nagarro.java.training.flightSearch.constants.Constants.*;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired
	Validations validations;
	
	@InitBinder
	private void checkForWhiteSpaces(WebDataBinder dataBinder) {

		validations.checkForWhiteSpaces(dataBinder);
	}

	@RequestMapping(LOGIN_CONTROLLER_MAPPING)
	public String loginUser(@Valid @ModelAttribute(USER_MODEL) User existingUser, BindingResult bindingResult, 
							Model model) {
		
		boolean loginUnsuccessful = false;
		
		if(bindingResult.hasErrors()) {
			
			return LOGIN_JSP_PAGE_PATH;
			
		} else {
			
			try{
			
				loginService.checkUser(existingUser);
		
				model.addAttribute(FLIGHTS_MODEL, new Flight());
				
				model.addAttribute("username", existingUser.getUsername());
				
				return SEARCH_FLIGHTS_JSP_PAGE_PATH;
				
			} catch (Exception e) {
			
				loginUnsuccessful = true;
				
				model.addAttribute("loginUnsuccessful", loginUnsuccessful);
				
				return LOGIN_JSP_PAGE_PATH;
			}
		}
	}
}
