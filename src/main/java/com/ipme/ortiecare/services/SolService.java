package com.ipme.ortiecare.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import com.ipme.ortiecare.model.Sol;
import com.ipme.ortiecare.repository.SolRepository;

public class SolService {
	@Autowired
	private SolRepository solRepo;

	public List<Sol> findAll() {
		return solRepo.findAll();
	}

	public Sol findById(UUID id) {
		return solRepo.getById(id);
	}

	public Sol create(String nomSol, String textureSol,  String structureSol, String avantageSol, String inconvenientSol) {
		Sol ceSol = new Sol(UUID.randomUUID(), nomSol, textureSol, structureSol, avantageSol, inconvenientSol);
		solRepo.save(ceSol);
		return ceSol;
	}

}
