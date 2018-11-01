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

@Controller
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class,
									HibernateJpaAutoConfiguration.class})
public class HomeController {
	
	@RequestMapping("/")
	public void redirectToLoginForm(HttpServletResponse response){
		try {
			response.sendRedirect("login");
		} catch (IOException e) {
		
		}
	}
	
	@RequestMapping("/login")
	public String showLoginForm(Model model){
		model.addAttribute("user", new User());
		return "log-in";
	}
	
	@RequestMapping("/sign-up")
	public String showSignUpForm(Model model){
		model.addAttribute("user", new User());
		return "sign-up";
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(HomeController.class, args);
	}
}
