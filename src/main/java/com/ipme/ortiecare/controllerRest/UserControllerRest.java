package com.ipme.ortiecare.controllerRest;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

@PostMapping("create")
public ResponseEntity<User> createUser(@RequestBody User user) {
	return new ResponseEntity<User>(userService.create(user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail()), HttpStatus.CREATED);
}

@GetMapping("getAll")
public List<UserDTO> getAllUsers(){
	return userService.findAll();
}

@GetMapping("{id}")
public UserDTO getByUUID(@PathVariable("id") UUID id) {
	return userService.findById(id);
}
}
