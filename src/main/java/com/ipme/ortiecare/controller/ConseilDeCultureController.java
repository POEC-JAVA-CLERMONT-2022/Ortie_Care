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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.ipme.ortiecare.model.ConseilDeCulture;
import com.ipme.ortiecare.model.Legume;
import com.ipme.ortiecare.services.ConseilDeCultureService;

@Controller
public class ConseilDeCultureController {
	
	@Autowired
	private ConseilDeCultureService conseilService;
	
	// Fonctionne
	@GetMapping("/conseilsDeCulture")
	public ModelAndView getConseils(HttpSession session)
	{
		ModelAndView mAV = new ModelAndView("listeConseils");
		mAV.addObject("conseilsDeCulture", conseilService.findAll());
		
		return mAV;
	}
	
	// Fonctionne (retour Json)
	@GetMapping("/conseilsDeCulture/json")
	@ResponseBody
	public List<ConseilDeCulture> getConseilsJson(HttpSession session)
	{
		return conseilService.findAll();
	}
	
	@GetMapping("/conseilsDeCulture/search")
	public ModelAndView getConseils(@RequestParam("search")String boutDesc)
	{
		ModelAndView mAV = new ModelAndView("conseilsDeCulture/liste-conseils");
		mAV.addObject("conseilDeCulture", conseilService.findByDescriptionContaining(boutDesc));
		mAV.setViewName("searchConseil");
		return mAV;
	}
	
	@GetMapping("/conseilsDeCulture/legume")
	public ModelAndView getConseils(@RequestParam("legume") UUID idLegume)
	{
		ModelAndView mAV = new ModelAndView("conseilsDeCulture/liste-conseils");
		mAV.addObject("conseilDeCulture", conseilService.findListeConseilPourLegume(idLegume));
		mAV.setViewName("conseilLegume");
		
		return mAV;
	}
	
	@GetMapping("/conseilsDeCulture/addConseil")
    public ModelAndView showConseilForm() {
        return new ModelAndView("addConseil");
    }
	
	@PostMapping("/conseilsDeCulture/addConseil")
	public ModelAndView addConseils(@Valid ConseilDeCulture newConseil, BindingResult result)
	{
		if(!result.hasErrors())
		{
			conseilService.create(newConseil.getTitre(), newConseil.getDescription());
			return new ModelAndView("redirect:/conseilsDeCulture");
		}
		else
		{
			return new ModelAndView("addConseil");
		}
	}
	
	
}