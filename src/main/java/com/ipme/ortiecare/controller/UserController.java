package com.ipme.ortiecare.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ipme.ortiecare.model.User;
import com.ipme.ortiecare.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("user")
	public ModelAndView getUser(HttpSession session) {
		ModelAndView mAV = new ModelAndView("listeUsers");
		mAV.addObject("users", userService.findAll());
		return mAV;
	}

		
		
		@GetMapping("/user/addUser")
	    public ModelAndView showUserForm() {
	        return new ModelAndView("addUser");
	    }
		
		@PostMapping("/conseilsDeCulture/addConseil")
		public ModelAndView addUser(@Valid User newUser, BindingResult result)
		{
			if(!result.hasErrors())
			{
				userService.create(newUser.getFirstName(), newUser.getLastName(), newUser.getEmail(), newUser.getPassword());
				return new ModelAndView("redirect:/user");
			}
			else
			{
				return new ModelAndView("addUser");
			}
		}
		
	}


