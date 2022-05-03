package com.ipme.ortiecare.controllerRest;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipme.ortiecare.model.Sol;

import com.ipme.ortiecare.services.SolService;
import com.ipme.ortiecare.services.DTO.SolDTO;

@RestController
@RequestMapping("/api/sols")
public class SolControllerRest {

	private SolService solService;

	public SolControllerRest(SolService solService) {
		this.solService = solService;
	}

	@PostMapping("create")
	// @ResponseBody
	// Le seul ResponseBody qu'on garde pour l'exemple, pas nécessaire puisqu'on
	// utilise @RestController, utile si @Controller
	public ResponseEntity<Sol> createSol(@RequestBody Sol sol) {
		try {
			return ResponseEntity.ok(solService.create(sol.getNomSol(), sol.getTextureSol(), sol.getStructureSol(),
					sol.getAvantageSol(), sol.getInconvenientSol()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("getAll")
	public ResponseEntity<List<SolDTO>> getAllSols() {
		try {
			return ResponseEntity.ok(solService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<SolDTO> getByUUID(@PathVariable("id") UUID id) {
		try {
			return ResponseEntity.ok(solService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<Integer> deleteSol(@PathVariable("id") UUID idSol) {
		try {
			return ResponseEntity.ok(solService.deleteById(idSol));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

}
