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
	
	public List<User> findAll()
	{
		return userRepo.findAll();
	}
	
	public User findById(UUID id)
	{
		return userRepo.getById(id);
	}
	
	public String create(String password, String firstName, String lastName, String email)
	{
		User ceUser = new User(UUID.randomUUID(), password, firstName, lastName, email);
		userRepo.save(ceUser);
		return ceUser.getFirstName() + " " +  ceUser.getLastName();
	}

}
