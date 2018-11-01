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

import com.nagarro.java.training.flightSearch.models.User;
import com.nagarro.java.training.flightSearch.services.LoginService;
import com.nagarro.java.training.flightSearch.validations.Validations;

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

	@RequestMapping("/loginUser")
	public String loginUser(@Valid @ModelAttribute("user") User existingUser, BindingResult bindingResult, 
							Model model) {
		
		boolean loginUnsuccessful = false;
		
		if(bindingResult.hasErrors()) {
			
			return "log-in";
			
		} else {
			
			try{
			
				loginService.checkUser(existingUser);
		
				return "search-flights";
				
			} catch (Exception e) {
			
				System.out.println("----------------------------IN CATCH BLOCK------------------------------");
				loginUnsuccessful = true;
				
				model.addAttribute("loginUnsuccessful", loginUnsuccessful);
				System.out.println(loginUnsuccessful);
				return "log-in";
			}
		}
	}
}
