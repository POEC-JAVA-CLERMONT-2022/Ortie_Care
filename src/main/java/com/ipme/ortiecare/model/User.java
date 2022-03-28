package com.ipme.ortiecare.model;
import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@Column(name = "idUser", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID idUser;
	
	@Column(name ="password", length=50)
	private String password;
	
	@Column(name ="firstName", length=100)
	private String firstName;
	
	@Column(name ="lastName", length=100)
	private String lastName;
	
	@Column(name ="email", length=255)
	private String email;

	@Column(name ="isAdmin", length=255)
	private boolean isAdmin;
	
	public User(UUID idUser, String password, String firstName, String lastName, String email) {
		this.idUser = idUser;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.isAdmin = false;
	}
	
	public String nomComplet() {
		return this.firstName + " " + this.lastName; 
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public UUID getIdUser() {
		return idUser;
	}
	
	
	
	
}