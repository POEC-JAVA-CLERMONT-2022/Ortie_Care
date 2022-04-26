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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipme.ortiecare.model.ConseilDeCulture;
import com.ipme.ortiecare.services.ConseilDeCultureService;
import com.ipme.ortiecare.services.DTO.ConseilDeCultureDTO;

@RestController
@RequestMapping("api/conseilsDeCulture")
public class ConseilDeCultureControllerRest {

	@Autowired
	private ConseilDeCultureService conseilService;

	@GetMapping("getAll")
	public List<ConseilDeCultureDTO> getConseils(HttpSession session) {
		return conseilService.findAll();
	}

	@PostMapping("create")
	@ResponseBody
	public ResponseEntity<ConseilDeCulture> createConseil(@RequestBody ConseilDeCulture conseil, HttpSession session) {
		return new ResponseEntity<ConseilDeCulture>(conseilService.create(conseil.getTitre(), conseil.getDescription()),HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ConseilDeCultureDTO getConseilById(@PathVariable("id")UUID idConseil, HttpSession session) {
		return conseilService.findById(idConseil);
	}
	
	// Exemple delete à transformer
//	@DeleteMapping(path = { "/{id}" })
//	public Employee delete(@PathVariable("id") int id) {
//		Employee deletedEmp = null;
//		for (Employee emp : employees) {
//			if (emp.getEmpId().equals(id)) {
//				employees.remove(emp);
//				deletedEmp = emp;
//				break;
//			}
//		}
//		return deletedEmp;
//	}

}
