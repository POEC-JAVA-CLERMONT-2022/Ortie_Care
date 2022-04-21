package com.ipme.ortiecare.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ipme.ortiecare.model.User;
import com.ipme.ortiecare.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/user")
	public ModelAndView getUsers(HttpSession session) {
		ModelAndView mAV = new ModelAndView("users/listeUsers");
		mAV.addObject("users", userService.findAll());
		return mAV;
	}

	@GetMapping("/user/addUser")
	public ModelAndView showUserForm() {
		return new ModelAndView("users/addUser");
	}

	@PostMapping("/user/addUser")
	public ModelAndView addUser(@Valid User newUser, BindingResult result) {
		if (!result.hasErrors()) {
			userService.create(newUser.getFirstName(), newUser.getLastName(),
					newUser.getEmail(), newUser.getPassword());
			return new ModelAndView("redirect:/user");
		} else {
			return new ModelAndView("users/addUser");
		}
	}

	@GetMapping("/user/searchUser")
	public ModelAndView searchUser() {
		return new ModelAndView("users/searchUser");
	}
}
