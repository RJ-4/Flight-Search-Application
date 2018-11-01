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
	
	@RequestMapping("/signUp")
	public String registerNewUser(@RequestParam("confirm-password") String confirmPassword, 
									@Valid @ModelAttribute("user") User newUser, BindingResult bindingResult, 
									Model model){
		
		boolean usernameAlreadyExists = false;
		
		boolean passwordsDontMatch = false;
		
		if (bindingResult.hasErrors()) {
			
			return "sign-up";
		
		} else if (!newUser.getPassword().equals(confirmPassword)) {

			passwordsDontMatch = true;
			
			model.addAttribute("passwordsDontMatch", passwordsDontMatch);
			
			return "sign-up";
			
		} else {
			
			try {
				
				signUpService.registerNewUser(newUser);
				
				model.addAttribute("flights", new Flight());

				return "search-flights";
				
			} catch(Exception e) {
				
				usernameAlreadyExists = true;

				model.addAttribute("usernameAlreadyExists", usernameAlreadyExists);
				
				return "sign-up";
			}
		}
	}
}
