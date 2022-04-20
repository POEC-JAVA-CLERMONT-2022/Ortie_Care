package com.ipme.ortiecare.services;

import com.ipme.ortiecare.model.User;
import com.ipme.ortiecare.repository.UserRepository;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public UserService (UserRepository userRepo) 
	{
		this.userRepo = userRepo;
	}

	public List<User> findAll() 
	{
		return this.userRepo.findAll();
	}

	public User findById(UUID id) 
	{
		return this.userRepo.getById(id);
	}
	
	public List<User> findByIs_Admin(int vraiOuFaux)
	{
		return userRepo.findByIsAdmin(vraiOuFaux);
	}
	
	public User findByFirstNameAndLastName(String firstName, String lastName)
	{
		return this.userRepo.findByFirstNameAndLastName(firstName, lastName);
	}
	
	public User create(String password, String firstName, String lastName, String email)
	{
		User ceUser = new User(UUID.randomUUID(), password, firstName, lastName, email);
		this.userRepo.save(ceUser);
		return ceUser;
	}
	
	// Pas sur de cette methode = Le changement sur l'appli est repercut� en base ? ou il faudrait le save dans le repo apr�s l'avoir modifi� sur la plateforme
	public void passageAdmin(User leUserQueJeManipule) 
	{ 
		if(leUserQueJeManipule.isAdmin()==false) {
			leUserQueJeManipule.setAdmin(true);
		}
	}

	public User findByUUID(UUID id) {
		
		return userRepo.findByUUID(id);
	}
}


