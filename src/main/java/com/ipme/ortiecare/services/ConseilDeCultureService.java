package com.ipme.ortiecare.services;
import com.ipme.ortiecare.model.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipme.ortiecare.repository.ConseilDeCultureRepository;
import com.ipme.ortiecare.services.DTO.ConseilDeCultureDTO;

@Service
public class ConseilDeCultureService {

	Logger logger = LoggerFactory.getLogger(ConseilDeCultureService.class);
	
	@Autowired
	private ConseilDeCultureRepository conseilRepo;
	
	// Methode de conversion DTO
	public ConseilDeCultureDTO convertConseil(ConseilDeCulture conseil)
	{
		if(conseil != null)
		{
			return new ConseilDeCultureDTO(conseil.getTitre(), conseil.getDescription());
		}
		else
		{
			return new ConseilDeCultureDTO();
		}
	}
	
	// Récupération de l'ensembles des conseils de culture
	public List<ConseilDeCultureDTO> findAll()
	{
		ArrayList<ConseilDeCultureDTO> conseilsDTO = new ArrayList<>();
		for (ConseilDeCulture unConseil : conseilRepo.findAll())
		{
			conseilsDTO.add(convertConseil(unConseil));
		}
		return conseilsDTO;
	}
	
	// Recuperation de conseil par ID
	public ConseilDeCultureDTO findById(UUID id)
	{
		if(id != null && id.toString() != "")
		{
			logger.info("La recherche par id a fonctionné pour l'id " + id );
			return convertConseil(conseilRepo.getById(id));
		}
		else
		{
			logger.warn("La recherche par id n'a pas fonctionné, renvoi d'un objet vide conseil de culture. Valeur du paramètre passé : " + id);
			return new ConseilDeCultureDTO();
		}
	}
	
	// Suppression de conseil par ID
	public int deleteById(UUID id)
	{
		if(id != null && id.toString() != "")
		{
			logger.info("Début de suppression d'objet");
			conseilRepo.deleteById(id);
			return 1;
		}
		else
		{
			logger.warn("La suppression a échouée ; id null ou vide");
			return 0;
		}
			
	}
	
	// Recupération de conseil grâce a une partie de la description
	public List<ConseilDeCultureDTO> findByDescriptionContaining(String boutDescription)
	{
		if(boutDescription != null && boutDescription != "")
		{
			logger.info("Recherche par bout de description : " + boutDescription);
			ArrayList<ConseilDeCultureDTO> conseilsDTO = new ArrayList<>();
			for (ConseilDeCulture unConseil : conseilRepo.findByDescriptionContaining(boutDescription))
			{
				conseilsDTO.add(convertConseil(unConseil));
			}
			return conseilsDTO;
		}
		else
		{
			logger.warn("Recherche par description échouée : retour d'une liste vide");
			return new ArrayList<ConseilDeCultureDTO>();
		}
	}
	
	// Création de conseil de culture
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
	public List<ConseilDeCultureDTO> findListeConseilPourLegume(UUID idLegume)
	{
		if(idLegume != null && idLegume.toString() != "")
		{
			logger.info("Récupération des conseils pour le legume " + idLegume);
			ArrayList<ConseilDeCultureDTO> conseilsDTO = new ArrayList<>();
			for (ConseilDeCulture unConseil : this.conseilRepo.findConseilsLegume(idLegume))
			{
				conseilsDTO.add(convertConseil(unConseil));
			}
			return conseilsDTO;
		}
		else 
		{
			logger.warn("Retour d'une liste vide ; la recherche a échoué");
			return new ArrayList<ConseilDeCultureDTO>();
		}
		
	}
	
	
	
}
