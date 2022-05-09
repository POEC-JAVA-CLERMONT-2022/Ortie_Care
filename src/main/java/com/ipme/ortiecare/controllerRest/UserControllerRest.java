package com.ipme.ortiecare.controllerRest;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		try {
			user.getNomComplet();
			return new ResponseEntity<User>(
					userService.create(user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail()),
					HttpStatus.CREATED);
		}

		catch (Exception e) {

			System.out.println("L'utilisateur " + user.getNomComplet() + " existe déjà.");

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("getAll")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		try {
			return ResponseEntity.ok(userService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	@GetMapping("{id}")
	public ResponseEntity<UserDTO> getByUUID(@PathVariable("id") UUID id) {
		try {
			if (id != null) {
				return ResponseEntity.ok(userService.findById(id));
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<Integer> DeleteUser(@PathVariable("id") UUID idUser) {
		try {
			return ResponseEntity.ok(userService.deleteById(idUser));
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") UUID id, @RequestBody User user) {
		try {
			return ResponseEntity.ok(userService.modifById(id, user.getFirstName(), user.getLastName(), user.getEmail()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
