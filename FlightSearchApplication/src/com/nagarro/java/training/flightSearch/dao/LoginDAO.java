package com.nagarro.java.training.flightSearch.dao;

import com.nagarro.java.training.flightSearch.models.User;

public interface LoginDAO {

	public User fetchUser(User user) throws Exception;
}
