package com.ipme.ortiecare.controllerRest;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipme.ortiecare.model.ConseilDeCulture;
import com.ipme.ortiecare.services.ConseilDeCultureService;
import com.ipme.ortiecare.services.DTO.ConseilDeCultureDTO;

@CrossOrigin
@RestController
@RequestMapping("api/conseilsDeCulture")
public class ConseilDeCultureControllerRest {

	@Autowired
	private ConseilDeCultureService conseilService;

	@GetMapping("getAll")
	public ResponseEntity<List<ConseilDeCultureDTO>> getConseils(HttpSession session) {
		try {
			return ResponseEntity.ok(conseilService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PostMapping("create")
	public ResponseEntity<ConseilDeCulture> createConseil(@RequestBody ConseilDeCulture conseil, HttpSession session) {
		try {
			return new ResponseEntity<ConseilDeCulture>(
					conseilService.create(conseil.getTitre(), conseil.getDescription()), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<ConseilDeCultureDTO> getConseilById(@PathVariable("id") UUID idConseil, HttpSession session) {
		try {
			return ResponseEntity.ok(conseilService.findById(idConseil));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<Integer> deleteConseil(@PathVariable("id") UUID idConseil) {
		try {
			return ResponseEntity.ok(conseilService.deleteById(idConseil));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping("update/{id}")
	public ResponseEntity<ConseilDeCulture> updateConseil(@PathVariable("id") UUID id, @RequestBody ConseilDeCulture conseil) {
		try {
			return ResponseEntity.ok(conseilService.modifById(id, conseil.getTitre(), conseil.getDescription()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping("findList/{id}")
	public ResponseEntity<List<ConseilDeCultureDTO>> findConseilsLegume(@PathVariable("id") UUID idConseil) {
		try {
			return ResponseEntity.ok(conseilService.findListeConseilPourLegume(idConseil));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
