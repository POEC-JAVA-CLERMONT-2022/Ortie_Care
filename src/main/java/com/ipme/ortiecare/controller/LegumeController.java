package com.ipme.ortiecare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.ipme.ortiecare.services.LegumeService;

@Controller
public class LegumeController {

	//@Autowired
	//private LegumeService legumeService;

	// TODO : un jour
//	@GetMapping("/legume")
//	public ModelAndView getLegume(HttpSession session)
//	{
//		ModelAndView mAV = new ModelAndView("legumes/listeLegumes");
//		mAV.addObject("conseilsDeCulture", legumeService.findAll());
//		
//		return mAV;
//	}
//		
//	// Necessaire pour afficher le formulaire de creation CECI EST UN GET
//	@GetMapping("/legume/addLegume")
//    public ModelAndView showConseilForm() {
//        return new ModelAndView("legumes/addLegume");
//    }
//	
//	// Fonctionne (ajout de conseil) Validation ko CECI EST UN POST
//	@PostMapping("/legume/addLegume")
//	public ModelAndView addConseils(@Valid Legume newLegume, BindingResult result)
//	{
//		if(!result.hasErrors())
//		{
//			legumeService.create();
//			return new ModelAndView("redirect:/conseilsDeCulture");
//		}
//		else
//		{
//			return new ModelAndView("conseils/addConseil");
//		}
//	}

}
