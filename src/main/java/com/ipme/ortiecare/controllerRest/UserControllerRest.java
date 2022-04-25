package com.ipme.ortiecare.controllerRest;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipme.ortiecare.model.User;
import com.ipme.ortiecare.services.UserService;
import com.ipme.ortiecare.services.DTO.UserDTO;

@RestController
@RequestMapping("/api/users")
public class UserControllerRest {

private UserService userService;

public UserControllerRest(UserService userService) {
	this.userService = userService;
}

@PostMapping
public ResponseEntity<User> createUser(@RequestBody User user) {
	return new ResponseEntity<User>(userService.create(user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail()), HttpStatus.CREATED);
}

@GetMapping
public List<UserDTO> getAllUsers(){
	return userService.findAll();
}

@GetMapping
public UserDTO getByUUID(UUID id) {
	return userService.findById(id);
}
}
