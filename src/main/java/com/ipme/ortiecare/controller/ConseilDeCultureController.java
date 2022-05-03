package com.ipme.ortiecare.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ipme.ortiecare.model.ConseilDeCulture;
import com.ipme.ortiecare.services.ConseilDeCultureService;

@Controller
public class ConseilDeCultureController {

	@Autowired
	private ConseilDeCultureService conseilService;

	// Fonctionne
	@GetMapping("/conseilsDeCulture")
	public ModelAndView getConseils(HttpSession session) {
		ModelAndView mAV = new ModelAndView("conseils/listeConseils");
		mAV.addObject("conseilsDeCulture", conseilService.findAll());

		return mAV;
	}

	// Necessaire pour afficher le formulaire de creation CECI EST UN GET
	@GetMapping("/conseilsDeCulture/addConseil")
	public ModelAndView showConseilForm() {
		return new ModelAndView("conseils/addConseil");
	}

	// Fonctionne (ajout de conseil) Validation ko CECI EST UN POST
	@PostMapping("/conseilsDeCulture/addConseil")
	public ModelAndView addConseils(@Valid ConseilDeCulture newConseil, BindingResult result) {
		if (!result.hasErrors()) {
			conseilService.create(newConseil.getTitre(), newConseil.getDescription());
			return new ModelAndView("redirect:/conseilsDeCulture");
		} else {
			return new ModelAndView("conseils/addConseil");
		}
	}

	// Get pour récupérer et afficher le formulaire de recherche
	@GetMapping("/conseilsDeCulture/searchConseil")
	public ModelAndView showConseilSearchForm() {
		return new ModelAndView("conseils/searchConseil");
	}

	// Post pour récup les resultats obtenus via la recherche
	@PostMapping("/conseilsDeCulture/searchConseil")
	public ModelAndView searchConseils(String boutDesc) {
		ModelAndView mAV = new ModelAndView("conseils/searchConseil");
		mAV.addObject("conseilsSearched", conseilService.findByDescriptionContaining(boutDesc));
		return mAV;
	}

	// Get pour récupérer et afficher le formulaire de recherche
	@GetMapping("/conseilsDeCulture/legume")
	public ModelAndView showLegumeConseilSearchForm() {
		return new ModelAndView("conseils/conseilLegume");
	}

	// A FAIRE
	@PostMapping("/conseilsDeCulture/legume")
	public ModelAndView getLegumeConseils(UUID idLegume) {
		ModelAndView mAV = new ModelAndView("conseils/conseilLegume");
		mAV.addObject("legumeResult", conseilService.findListeConseilPourLegume(idLegume));

		return mAV;
	}

}