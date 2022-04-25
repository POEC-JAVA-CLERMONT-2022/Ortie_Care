package com.ipme.ortiecare.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipme.ortiecare.model.Sol;
import com.ipme.ortiecare.repository.SolRepository;

@Service
public class SolService {
	
	Logger logger = LoggerFactory.getLogger(Sol.class);
	
	@Autowired
	private SolRepository solRepo;
	
	public SolService (SolRepository solRepo)
	{
		this.solRepo = solRepo;
	}
	
	public Sol create(String nomSol, String textureSol,  String structureSol, String avantageSol, String inconvenientSol) 
	{
		Sol ceSol = new Sol(UUID.randomUUID(), nomSol, textureSol, structureSol, avantageSol, inconvenientSol);
		this.solRepo.save(ceSol);
		return ceSol;
	}
	
	public List<Sol> findAll() 
	{
		return this.solRepo.findAll();
	}

	public Sol findByUUID(UUID id) 
	{
		if(id != null && id.toString() != "") {
			logger.info("La recherche a fonctionné pour l'id : " + id);
			return solRepo.getById(id);
		}
		else {
			logger.warn("La recherche n'a pas fonctionné. Renvoi d'un objet Sol vide. Valeur du paramètre passé : " + id);
			return new Sol();
		}
	}
	
	public List<Sol> findByStructureSolContaining (String boutStructureSol)
	{
		if(boutStructureSol != null && boutStructureSol != "") {
			logger.info("Recherche par bout de structure de sol : " + boutStructureSol);
			return this.solRepo.findByStructureSolContaining(boutStructureSol);
		}
		else {
			logger.warn("Recherche de structure échouée : retour d'une liste vide");
			return new ArrayList<Sol>();
		}
		
	}
	
	public List<Sol> findByTextureSolContaining (String boutTextureSol)
	{
		if(boutTextureSol != null && boutTextureSol != "") {
			logger.info("Recherche par bout de texture sol : " + boutTextureSol);
			return this.solRepo.findByTextureSolContaining(boutTextureSol);
		}
		else {
			logger.warn("Recherche de texture échouée : retour d'une liste vide");
			return new ArrayList<Sol>();
		}
		
	}
	
}
