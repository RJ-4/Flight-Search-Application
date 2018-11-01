package com.nagarro.java.training.flightSearch.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.java.training.flightSearch.dao.SignUpDAO;
import com.nagarro.java.training.flightSearch.models.User;
import com.nagarro.java.training.flightSearch.services.SignUpService;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	SignUpDAO signUpDAO;
	
	@Override
	public void registerNewUser(User user) throws Exception{
		
		signUpDAO.insertNewUser(user);
	}

}
