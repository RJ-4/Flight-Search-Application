package com.nagarro.java.training.flightSearch.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.java.training.flightSearch.dao.SignUpDAO;
import com.nagarro.java.training.flightSearch.models.User;

@Repository
public class SignUpDAOImpl implements SignUpDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void insertNewUser(User user) throws Exception{
		
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		
	}

}
