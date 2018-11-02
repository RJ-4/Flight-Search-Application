package com.nagarro.java.training.flightSearch.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.java.training.flightSearch.dao.LoginDAO;
import com.nagarro.java.training.flightSearch.models.User;

import static com.nagarro.java.training.flightSearch.constants.Constants.*;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	SessionFactory factory;
	
	@Override
	@Transactional
	public User fetchUser(User user) throws Exception {

		Session session = factory.getCurrentSession();
		
		String loginQuery = LOGIN_QUERY;
		
		Query query = session.createQuery(loginQuery);
		
		query.setParameter(USERNAME_LABEL, user.getUsername());
		
		query.setParameter(PASSWORD_LABEL, user.getPassword());
		
		User result = (User)query.getSingleResult();
		
		return result;
	}

}
