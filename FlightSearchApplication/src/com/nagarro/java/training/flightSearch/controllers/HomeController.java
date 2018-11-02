package com.nagarro.java.training.flightSearch.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarro.java.training.flightSearch.models.User;

import static com.nagarro.java.training.flightSearch.constants.Constants.*;

@Controller
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class,
									HibernateJpaAutoConfiguration.class})
public class HomeController {
	
	@RequestMapping("/")
	public void redirectToLoginForm(HttpServletResponse response){
		try {
			response.sendRedirect(LOGIN_PAGE);
		} catch (IOException e) {
		
		}
	}
	
	@RequestMapping(LOGIN_PAGE_MAPPING)
	public String showLoginForm(Model model){
		model.addAttribute(USER_MODEL, new User());
		return LOGIN_JSP_PAGE_PATH;
	}
	
	@RequestMapping(SIGN_UP_PAGE_MAPPING)
	public String showSignUpForm(Model model){
		model.addAttribute(USER_MODEL, new User());
		return SIGN_UP_JSP_PAGE_PATH;
	}
	
	@RequestMapping(LOGOUT_PAGE_MAPPING)
	public String onLogout(Model model) {
		return LOGOUT_JSP_PAGE_PATH;
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HomeController.class, args);
	}
}
