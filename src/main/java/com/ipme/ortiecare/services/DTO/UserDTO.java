package com.ipme.ortiecare.services.DTO;

public class UserDTO {
	
	private boolean isAdmin; 
	private String firstName; 
	private String lastName; 
	private String email;
	
	public UserDTO() {
		
	}
	public UserDTO(boolean isAdmin, String firstName, String lastName, String email) {
		
		this.isAdmin = isAdmin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public boolean getIsAdmin() {return isAdmin;}
	
	public String getFirstName() {return firstName;}
	
	public String getLastName() {return lastName;}
	
	public String getEmail() {return email;}
	
	

}
