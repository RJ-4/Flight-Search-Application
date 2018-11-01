package com.nagarro.java.training.flightSearch.services;

import com.nagarro.java.training.flightSearch.models.User;

public interface LoginService {

	public User checkUser(User user) throws Exception;
}
