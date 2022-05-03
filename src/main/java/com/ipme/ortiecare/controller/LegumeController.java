package com.ipme.ortiecare.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ipme.ortiecare.model.Legume;
import com.ipme.ortiecare.services.ConseilDeCultureService;
import com.ipme.ortiecare.services.LegumeService;
import com.ipme.ortiecare.services.SolService;

@Controller
@RequestMapping("legume")
public class LegumeController {

	@Autowired
	private LegumeService legumeService;
	@Autowired
	private SolService solService;
	@Autowired
	private ConseilDeCultureService conseilService;

	@GetMapping("/getAll")
	public ModelAndView getLegume(HttpSession session)
	{
		ModelAndView mAV = new ModelAndView("legumes/listeLegumes");
		mAV.addObject("legumes", legumeService.findAll());
		
		return mAV;
	}
	
	
//		
	// Necessaire pour afficher le formulaire de creation CECI EST UN GET
	@GetMapping("/addLegume")
    public ModelAndView showConseilForm() {
		ModelAndView mAV = new ModelAndView("legumes/addLegume");
        mAV.addObject("listeConseils", conseilService.findAll());
        mAV.addObject("listeLegumes", legumeService.findAll());
        mAV.addObject("listeSols", solService.findAll());
		return mAV; 
    }
	
	// Fonctionne (ajout de conseil) Validation ko CECI EST UN POST
	@PostMapping("/addLegume")
	public ModelAndView addConseils(@Valid Legume newLegume, BindingResult result)
	{
		if(!result.hasErrors())
		{
			legumeService.create(newLegume.getNom(), newLegume.getTempsAvantRecolteEnMois(), newLegume.getPoidsMoyenFruitEnG(), newLegume.getConseils(), newLegume.getLegumesAssocies(), newLegume.isAutoReseme(), newLegume.isGousse(), newLegume.getBestSol());
			return new ModelAndView("redirect:/legume/getAll");
		}
		else
		{
			return new ModelAndView("legumes/addLegume");
		}
	}
	
}
