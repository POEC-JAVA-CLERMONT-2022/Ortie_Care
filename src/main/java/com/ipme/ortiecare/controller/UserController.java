package com.ipme.ortiecare.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ipme.ortiecare.services.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("user")
	public ModelAndView getUser(HttpSession session) {
		ModelAndView mAV = new ModelAndView("listUsers");
		mAV.addObject("users", userService.findAll());
		return mAV;

	}

	@RequestMapping("/user/search")
	public ModelAndView getUser(@RequestParam("search") UUID id) {
		ModelAndView mAV = new ModelAndView("user/listUsers");

		mAV.addObject("user", userService.findByUUID(id));
		mAV.addObject("search", id);

		return mAV;
	}

	
//	@RequestMapping("creationUser")
//	public ModelAndView createUser(HttpSession session) {
//		ModelAndView mAV = new ModelAndView("creationUsers");
//		
//		mAV.addObject("user", userService.create(null, null, null, null));
//		return mAV;
//		
//	}
}
