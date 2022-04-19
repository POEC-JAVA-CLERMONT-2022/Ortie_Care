package com.ipme.ortiecare.services;
import com.ipme.ortiecare.model.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipme.ortiecare.repository.ConseilDeCultureRepository;
import com.ipme.ortiecare.repository.LegumesRepository;

@Service
public class LegumeService {
	
	@Autowired
	private LegumesRepository legumesRepo;
	
	public LegumeService (LegumesRepository legumesRepo)
	{
		this.legumesRepo = legumesRepo;
	}
	
	public Legume create(String nom,int tempsAvantRecolteEnMois, int poidsMoyenFruitEnG, Set<LegumesConseilsDeCulture> conseilsDeCulture, Set<LegumesLegumesAssocies> legumesAssocies, boolean autoReseme, boolean isGousse, Sol bestSol)
	{
		Legume ceLegume = new Legume(UUID.randomUUID(), nom, tempsAvantRecolteEnMois, poidsMoyenFruitEnG ,conseilsDeCulture, legumesAssocies, autoReseme, isGousse, bestSol);
		this.legumesRepo.save(ceLegume);
		return ceLegume;
	}
	
	public List<Legume> findAll()
	{
		return this.legumesRepo.findAll();
	}
	public Legume findByUUID(UUID id)
	{
		return this.legumesRepo.findByUUID(id);
	}
	// Recup la liste des legumes associes pour un legume
	public List<Legume> findListeLegumesAssocies(UUID idLegume)
	{
		return this.legumesRepo.findLegumesAssocies(idLegume);
	}
	
	public Legume findByNom(String nom)
	{
		return this.legumesRepo.findByNom(nom);
	}
	public List<Legume> findByNomStartingWith(String nom)
	{
		return this.legumesRepo.findByNomStartingWith(nom);
	}
	
	public void addAssociationLegumeLegume(Legume premierLegume, Legume deuxiemeLegume)
	{
		boolean check = true;
		for (LegumesLegumesAssocies unLegume : premierLegume.getLegumesAssocies()) {
			if(unLegume.getAssoLegumes().getLegume1().getIdLegume().equals(deuxiemeLegume.getIdLegume()))
			{
				check = false;
			}
		}
		for (LegumesLegumesAssocies unLegume : deuxiemeLegume.getLegumesAssocies()) {
			if(unLegume.getAssoLegumes().getLegume1().getIdLegume().equals(premierLegume.getIdLegume()))
			{
				check = false;
			}
		}
		if(check)
		{
			this.legumesRepo.addAssociationLegumeLegume(premierLegume.getIdLegume(), deuxiemeLegume.getIdLegume());
			System.out.println("Association entre " + premierLegume.getNom() + " et " + deuxiemeLegume.getNom() + " ajout�e en base !");
		}
		else
		{
			System.out.println("L'ajout de l'association a �chou� ; l'association existe d�j�.");
		}
	}
	
	
	
}
