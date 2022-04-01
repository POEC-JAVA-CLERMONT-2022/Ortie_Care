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

	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public List<User> findAll() {
		return this.userRepo.findAll();
	}

	public User findById(UUID id) {
		return this.userRepo.getById(id);
	}
	
	public User findByFirstNameAndLastName(String firstName, String lastName)
	{
		return this.userRepo.findByFirstNameAndLastName(firstName, lastName);
	}
	
	public String create(String password, String firstName, String lastName, String email)
	{
		User ceUser = new User(UUID.randomUUID(), password, firstName, lastName, email);
		this.userRepo.save(ceUser);
		return ceUser.getFirstName() + " " +  ceUser.getLastName();
	}

	public void passageAdmin(User leUserQueJeManipule) 
	{ 
	if(leUserQueJeManipule.isAdmin()==false) {
		leUserQueJeManipule.setAdmin(true);
	}
		

}
}


