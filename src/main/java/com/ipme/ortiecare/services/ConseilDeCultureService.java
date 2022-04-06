package com.ipme.ortiecare.services;
import com.ipme.ortiecare.model.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipme.ortiecare.repository.ConseilDeCultureRepository;

@Service
public class ConseilDeCultureService {
	
	@Autowired
	private ConseilDeCultureRepository conseilRepo;
	
	public List<ConseilDeCulture> findAll()
	{
		return conseilRepo.findAll();
	}
	
	public ConseilDeCulture findById(UUID id)
	{
		return conseilRepo.getById(id);
	}
	
	public ConseilDeCulture create(String titre, String description)
	{
		ConseilDeCulture ceConseil = new ConseilDeCulture(UUID.randomUUID(), titre, description);
		conseilRepo.save(ceConseil);
		return ceConseil;
	}
	
	
	
	
	
}
