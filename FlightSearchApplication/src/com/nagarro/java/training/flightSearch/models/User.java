package com.nagarro.java.training.flightSearch.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

	@Column(name = "username")
	@Id
	@NotNull(message = "username cannot be empty")
	@Size(min = 1, message = "username cannot be empty")
	private String username;
	
	@Column(name = "password")
	@NotNull(message = "password cannot be empty")
	@Size(min = 1, message = "password cannot be empty")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}