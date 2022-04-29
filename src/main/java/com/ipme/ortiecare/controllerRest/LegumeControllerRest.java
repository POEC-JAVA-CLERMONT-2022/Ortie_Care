package com.ipme.ortiecare.controllerRest;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipme.ortiecare.model.ConseilDeCulture;
import com.ipme.ortiecare.model.Legume;
import com.ipme.ortiecare.services.ConseilDeCultureService;
import com.ipme.ortiecare.services.LegumeService;
import com.ipme.ortiecare.services.DTO.ConseilDeCultureDTO;
import com.ipme.ortiecare.services.DTO.LegumeDTO;

@RestController
@RequestMapping("api/legumes")
public class LegumeControllerRest {
	
	@Autowired
	private LegumeService legumeService;
	
	@GetMapping("getAll")
	@ResponseBody
	public ResponseEntity<List<LegumeDTO>> getLegumes(HttpSession session) {
		try {
			return ResponseEntity.ok(legumeService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
		}
	}
	
	@PostMapping("create")
	@ResponseBody
	public ResponseEntity<Legume> createLegume(@RequestBody Legume legume, HttpSession session) {
		return new ResponseEntity<Legume>(legumeService.create(legume.getNom(), legume.getTempsAvantRecolteEnMois(), legume.getPoidsMoyenFruitEnG(), legume.getConseils(), legume.getLegumesAssocies(), legume.isAutoReseme(), legume.isGousse(), legume.getBestSol()),HttpStatus.CREATED);
	}
	
	@GetMapping("delete/{id}")
	@ResponseBody
	public ResponseEntity<Integer> deleteLegume(@PathVariable("id") UUID id)
	{
		try {
			return ResponseEntity.ok(legumeService.deleteById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
		}
	}
	
	@GetMapping("{id}")
	@ResponseBody
	public ResponseEntity<LegumeDTO> getLegumeById(@PathVariable("id")UUID idLegume, HttpSession session) {
		try {
			return ResponseEntity.ok(legumeService.findByUUID(idLegume));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
		}
	}
	
	@GetMapping("getAssociations/{id}")
	@ResponseBody
	public ResponseEntity<List<LegumeDTO>> getAssociations(@PathVariable("id") UUID idLegume, HttpSession session) {
		try {
			return ResponseEntity.ok(legumeService.findListeLegumesAssocies(idLegume));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
		}
//		return new ResponseEntity<List<LegumeDTO>>(legumeService.findListeLegumesAssocies(idLegume),HttpStatus.FOUND);
	}
	
}
