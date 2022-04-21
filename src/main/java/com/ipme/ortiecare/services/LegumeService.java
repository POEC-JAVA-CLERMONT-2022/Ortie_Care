package com.ipme.ortiecare.services;
import com.ipme.ortiecare.model.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipme.ortiecare.repository.ConseilDeCultureRepository;
import com.ipme.ortiecare.repository.LegumesRepository;

@Service
public class LegumeService {
	
	@Autowired
	private LegumesRepository legumesRepo;
	// Logger
	Logger logger = LoggerFactory.getLogger(LegumeService.class);

	
	public LegumeService (LegumesRepository legumesRepo)
	{
		this.legumesRepo = legumesRepo;
	}
	
	public Legume create(String nom,int tempsAvantRecolteEnMois, int poidsMoyenFruitEnG, Set<LegumesConseilsDeCulture> conseilsDeCulture, Set<LegumesLegumesAssocies> legumesAssocies, boolean autoReseme, boolean isGousse, Sol bestSol)
	{
		if(nom != null && nom != "" && tempsAvantRecolteEnMois != 0 && poidsMoyenFruitEnG != 0 && conseilsDeCulture != null && legumesAssocies != null && bestSol != null)
		{
			logger.info("Debut creation de legume");
			Legume ceLegume = new Legume(UUID.randomUUID(), nom, tempsAvantRecolteEnMois, poidsMoyenFruitEnG ,conseilsDeCulture, legumesAssocies, autoReseme, isGousse, bestSol);
			this.legumesRepo.save(ceLegume);
			logger.info("Legume " + ceLegume.getNom() + " créé en base.");
			return ceLegume;
		}
		else
		{
			logger.warn("Erreur lors de la création du légume : nom : " + nom + " ; Retour legume vide");
			return new Legume();
		}
		
	}
	
	public List<Legume> findAll()
	{
		return this.legumesRepo.findAll();
	}
	
	public Legume findByUUID(UUID id)
	{
		if(id != null && id.toString() != "")
		{
			logger.info("Legume trouvé grace a son id ");
			return this.legumesRepo.getById(id);
		}
		else
		{
			logger.warn("Aucun legume trouvé avec cet id(" + id + ") : retour d'un objet vide");
			return new Legume();
		}
	}
	
	// Recup la liste des legumes associes pour un legume
	public List<Legume> findListeLegumesAssocies(UUID idLegume)
	{
		if(idLegume != null && idLegume.toString() != "") 
		{
			logger.info("Liste de legumes associes trouvée ");
			return this.legumesRepo.findLegumesAssocies(idLegume);
		}
		else
		{
			logger.warn("Aucun legume associés trouvés avec cet id(" + idLegume + ") : retour d'une liste vide");
			return new ArrayList<Legume>();
		}
	}
	
	public Legume findByNom(String nom)
	{
		if(nom != null && nom != "")
		{
			logger.info("Legume trouvé avec son nom");
			return this.legumesRepo.findByNom(nom);
		}
		else
		{
			logger.warn("Aucun legume trouvé avec ce nom (" + nom + ") : retour d'un objet vide");
			return new Legume();
		}
	}
	
	public List<Legume> findByNomStartingWith(String nom)
	{
		if(nom != null && nom != "")
		{
			logger.info("Liste de Legumes trouvé avec son nom");
			return this.legumesRepo.findByNomStartingWith(nom);
		}
		else
		{
			logger.warn("Aucun legume trouvé avec ce nom (" + nom + ") : retour d'une liste vide");
			return new ArrayList<Legume>();
		}
	}
	
	public void addAssociationLegumeLegume(Legume premierLegume, Legume deuxiemeLegume)
	{
		boolean check = true;
		for (LegumesLegumesAssocies unLegume : premierLegume.getLegumesAssocies())
		{
			if(unLegume.getAssoLegumes().getLegume1().getIdLegume().equals(deuxiemeLegume.getIdLegume()))
			{
				logger.info("L'asso existe déjà entre " + premierLegume.getNom() + " et " + deuxiemeLegume.getNom());
				check = false;
			}
		}
		for (LegumesLegumesAssocies unLegume : deuxiemeLegume.getLegumesAssocies()) 
		{
			if(unLegume.getAssoLegumes().getLegume2().getIdLegume().equals(premierLegume.getIdLegume()))
			{
				logger.info("L'asso existe déjà entre " + premierLegume.getNom() + " et " + deuxiemeLegume.getNom());
				check = false;
			}
		}
		if(check)
		{
			this.legumesRepo.addAssociationLegumeLegume(premierLegume.getIdLegume(), deuxiemeLegume.getIdLegume());
			logger.info("Association entre " + premierLegume.getNom() + " et " + deuxiemeLegume.getNom() + " ajout�e en base !");
		}
		else
		{
			logger.warn("L'ajout de l'association a �chou� ; l'association existe d�j�.");
		}
	}
}
