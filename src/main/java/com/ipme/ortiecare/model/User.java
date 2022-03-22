package com.ipme.ortiecare.model;

public class User {

	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;

	public User(String password, String firstName, String lastName, String email, String phone) {

		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}
}
