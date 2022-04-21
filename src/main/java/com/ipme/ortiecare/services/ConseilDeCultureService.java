package com.ipme.ortiecare.services;
import com.ipme.ortiecare.model.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipme.ortiecare.repository.ConseilDeCultureRepository;

@Service
public class ConseilDeCultureService {

	//TODO: gestion des exceptions + log
	Logger logger = LoggerFactory.getLogger(ConseilDeCultureService.class);

	
	@Autowired
	private ConseilDeCultureRepository conseilRepo;
	
	public List<ConseilDeCulture> findAll()
	{
		return conseilRepo.findAll();
	}
	
	public ConseilDeCulture findById(UUID id)
	{
		if(id != null && id.toString() != "")
		{
			logger.info("La recherche par id a fonctionné pour l'id " + id );
			return conseilRepo.getById(id);
		}
		else
		{
			logger.warn("La recherche par id n'a pas fonctionné, renvoi d'un objet vide conseil de culture. Valeur du paramètre passé : " + id);
			return new ConseilDeCulture();
		}
	}
	
	public List<ConseilDeCulture> findByDescriptionContaining(String boutDescription)
	{
		if(boutDescription != null && boutDescription != "")
		{
			logger.info("Recherche par bout de description : " + boutDescription);
			return conseilRepo.findByDescriptionContaining(boutDescription);
		}
		else
		{
			logger.warn("Recherche par description échouée : retour d'une liste vide");
			return new ArrayList<ConseilDeCulture>();
		}
	}
	
	public ConseilDeCulture create(String titre, String description)
	{
		if(titre != null && description != null && titre != "" && description != "")
		{
			ConseilDeCulture ceConseil = new ConseilDeCulture(UUID.randomUUID(), titre, description);
			conseilRepo.save(ceConseil);
			logger.info(ceConseil.getTitre() + " a bien été créé ");
			return ceConseil;
		}
		else
		{
			logger.error("Appel de la methode create de Conseil de culture ; un des paramètres est null ou vide ; Renvoi d'un objet vide");
			return new ConseilDeCulture();
		}
	}
	// Recup la liste des conseil pour une ID legume
	public List<ConseilDeCulture> findListeConseilPourLegume(UUID idLegume)
	{
		if(idLegume != null && idLegume.toString() != "")
		{
			logger.info("Récupération des conseils pour le legume " + idLegume);
			return this.conseilRepo.findConseilsLegume(idLegume);
		}
		else 
		{
			logger.warn("Retour d'une liste vide ; la recherche a échoué");
			return new ArrayList<ConseilDeCulture>();
		}
		
	}
	
}
