package com.nagarro.java.training.flightSearch.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.java.training.flightSearch.dao.LoginDAO;
import com.nagarro.java.training.flightSearch.models.User;
import com.nagarro.java.training.flightSearch.services.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAO loginDAO;
	
	@Override
	public User checkUser(User user) throws Exception {
		
		return loginDAO.fetchUser(user);
		
	}

}
