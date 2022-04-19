package com.ipme.ortiecare.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ipme.ortiecare.services.ConseilDeCultureService;

@Controller
public class ConseilDeCultureController {
	
	@Autowired
	private ConseilDeCultureService conseilService;
	
	@RequestMapping("/conseilsDeCulture")
	public ModelAndView getConseils(HttpSession session)
	{
		ModelAndView mAV = new ModelAndView("conseilDeCulture/liste-conseils");
		mAV.addObject("conseilsDeCulture", conseilService.findAll());
		return mAV;
	}
	@RequestMapping("/conseilsDeCulture/loltest")
	public String getTest()
	{
		return "megalol";
	}
	
	
	@RequestMapping("/conseilsDeCulture/search")
	public ModelAndView getConseils(@RequestParam("search")String boutDesc)
	{
		ModelAndView mAV = new ModelAndView("conseilDeCulture/liste-conseils");
		mAV.addObject("conseilDeCulture", conseilService.findByDescriptionContaining(boutDesc));
		mAV.addObject("search", boutDesc);
		
		return mAV;
	}
	
	@RequestMapping("/conseilsDeCulture/legume")
	public ModelAndView getConseils(@RequestParam("legume") UUID idLegume)
	{
		ModelAndView mAV = new ModelAndView("conseilDeCulture/liste-conseils");
		mAV.addObject("conseilDeCulture", conseilService.findListeConseilPourLegume(idLegume));
		mAV.addObject("legume", idLegume);
		
		return mAV;
	}
	
	
}