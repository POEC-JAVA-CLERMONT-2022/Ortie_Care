package com.ipme.ortiecare.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ipme.ortiecare.model.Sol;
import com.ipme.ortiecare.services.SolService;

@Controller
public class SolController {
	
	Logger logger = LoggerFactory.getLogger(Sol.class);

	@Autowired
	private SolService solService;
	
	

	@RequestMapping("sol")
	public ModelAndView getSol(HttpSession session) {
		ModelAndView mAV = new ModelAndView("sols/listeSols");

		mAV.addObject("sols", solService.findAll());

		return mAV;

	}
	// a faire
	@RequestMapping("/sol/search")
	public ModelAndView getSol(@RequestParam("search") UUID id) {
	ModelAndView mAV = new ModelAndView("sols/list-sol");

		mAV.addObject("sol", solService.findByUUID(id));
	    mAV.addObject("search", id);

		return mAV;
	}

}
