package com.ipme.ortiecare.controllerRest;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipme.ortiecare.model.Sol;
import com.ipme.ortiecare.model.User;
import com.ipme.ortiecare.services.SolService;
import com.ipme.ortiecare.services.DTO.SolDTO;
import com.ipme.ortiecare.services.DTO.UserDTO;

@RestController
@RequestMapping("/api/sols")
public class SolControllerRest {

	private SolService solService;

	public SolControllerRest(SolService solService) {
		this.solService =solService;
	}
	
	@PostMapping("create")
	@ResponseBody
	public ResponseEntity<Sol> createSol(@RequestBody Sol sol) {
		return new ResponseEntity<Sol>(solService.create(sol.getNomSol(), sol.getTextureSol(), sol.getStructureSol(), sol.getAvantageSol(), sol.getInconvenientSol()), HttpStatus.CREATED);
	}
	
	@GetMapping("getAll")
	public List<SolDTO> getAllSols(){
		return solService.findAll();
	}

	@GetMapping("{id}")
	public SolDTO getByUUID(@PathVariable("id") UUID id) {
		return solService.findById(id);
	}

}
