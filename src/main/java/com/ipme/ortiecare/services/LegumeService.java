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
	
	public List<Legume> findAll()
	{
		return this.legumesRepo.findAll();
	}
	
	public Legume findById(UUID id)
	{
		return this.legumesRepo.getById(id);
	}
	
	public Legume create(String nom,int tempsAvantRecolteEnMois, int poidsMoyenFruitEnG, Set<ConseilDeCulture> conseilsDeCulture, boolean autoReseme, boolean isGousse, Sol bestSol)
	{
		Legume ceLegume = new Legume(UUID.randomUUID(), nom, tempsAvantRecolteEnMois, poidsMoyenFruitEnG ,conseilsDeCulture, autoReseme, isGousse, bestSol);
		this.legumesRepo.save(ceLegume);
		return ceLegume;
		
	}
	
	
	
}
