package com.nagarro.java.training.flightSearch.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.nagarro.java.training.flightSearch.constants.Constants.*;

@Entity
@Table(name = USER_TABLE_TABLE_NAME)
public class User {

	@Column(name = USER_TABLE_USERNAME_COLUMN)
	@Id
	@NotNull(message = USER_TABLE_USERNAME_VALIDATION_MESSAGE)
	@Size(min = 1, message = USER_TABLE_USERNAME_VALIDATION_MESSAGE)
	private String username;
	
	@Column(name = USER_TABLE_PASSWORD_COLUMN)
	@NotNull(message = USER_TABLE_PASSWORD_VALIDATION_MESSAGE)
	@Size(min = 1, message = USER_TABLE_PASSWORD_VALIDATION_MESSAGE)
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
