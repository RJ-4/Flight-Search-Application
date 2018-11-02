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
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.java.training.flightSearch.models.Flight;
import com.nagarro.java.training.flightSearch.models.User;
import com.nagarro.java.training.flightSearch.services.SignUpService;
import com.nagarro.java.training.flightSearch.validations.Validations;

import static com.nagarro.java.training.flightSearch.constants.Constants.*;

@Controller
public class SignUpController {
	
	@Autowired
	SignUpService signUpService;
	
	@Autowired
	Validations validations;
	
	@InitBinder
	private void checkForWhiteSpaces(WebDataBinder dataBinder) {

		validations.checkForWhiteSpaces(dataBinder);
	}
	
	@RequestMapping(SIGN_UP_CONTROLLER_MAPPING)
	public String registerNewUser(@RequestParam("confirm-password") String confirmPassword, 
									@Valid @ModelAttribute(USER_MODEL) User newUser, BindingResult bindingResult, 
									Model model){
		
		boolean usernameAlreadyExists = false;
		
		boolean passwordsDontMatch = false;
		
		if (bindingResult.hasErrors()) {
			
			return SIGN_UP_JSP_PAGE_PATH;
		
		} else if (!newUser.getPassword().equals(confirmPassword)) {

			passwordsDontMatch = true;
			
			model.addAttribute("passwordsDontMatch", passwordsDontMatch);
			
			return SIGN_UP_JSP_PAGE_PATH;
			
		} else {
			
			try {
				
				signUpService.registerNewUser(newUser);
				
				model.addAttribute(FLIGHTS_MODEL, new Flight());

				return SEARCH_FLIGHTS_JSP_PAGE_PATH;
				
			} catch(Exception e) {
				
				usernameAlreadyExists = true;

				model.addAttribute("usernameAlreadyExists", usernameAlreadyExists);
				
				return SIGN_UP_JSP_PAGE_PATH;
			}
		}
	}
}
