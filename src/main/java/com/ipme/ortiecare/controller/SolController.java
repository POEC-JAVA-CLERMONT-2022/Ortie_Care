package com.ipme.ortiecare.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ipme.ortiecare.services.SolService;

@Controller
public class SolController {

	@Autowired
	private SolService solService;
	
	@RequestMapping("/sol")
	public ModelAndView getSol(HttpSession session) {
		ModelAndView mAV = new ModelAndView("sol/list-sol");
		
		mAV.addObject("sol", solService.findAll());
	
		
		return mAV;
	}
	
	
}
