package com.ipme.ortiecare.controllerRest;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipme.ortiecare.model.Legume;
import com.ipme.ortiecare.model.Sol;
import com.ipme.ortiecare.services.LegumeService;
import com.ipme.ortiecare.services.DTO.LegumeDTO;

@RestController
@RequestMapping("api/legumes")
public class LegumeControllerRest {

	@Autowired
	private LegumeService legumeService;

	@GetMapping("getAll")
	public ResponseEntity<List<LegumeDTO>> getLegumes(HttpSession session) {
		try {
			return ResponseEntity.ok(legumeService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping("create")
	public ResponseEntity<Legume> createLegume(@RequestBody Legume legume, HttpSession session) {
		return new ResponseEntity<Legume>(legumeService.create(legume.getNom(), legume.getTempsAvantRecolteEnMois(),
				legume.getPoidsMoyenFruitEnG(), legume.getConseils(), legume.getLegumesAssocies(),
				legume.isAutoReseme(), legume.isGousse(), legume.getBestSol()), HttpStatus.CREATED);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<Integer> deleteLegume(@PathVariable("id") UUID id) {
		try {
			return ResponseEntity.ok(legumeService.deleteById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<LegumeDTO> getLegumeById(@PathVariable("id") UUID idLegume, HttpSession session) {
		try {
			return ResponseEntity.ok(legumeService.findByUUID(idLegume));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@GetMapping("sol/{id}")
	public ResponseEntity<List<LegumeDTO>> getLegumes(@PathVariable("id") Sol idSol, HttpSession session) {
		try {
			return ResponseEntity.ok(legumeService.findBySol(idSol));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("getAssociations/{id}")
	public ResponseEntity<List<LegumeDTO>> getAssociations(@PathVariable("id") UUID idLegume, HttpSession session) {
		try {
			return ResponseEntity.ok(legumeService.findListeLegumesAssocies(idLegume));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
