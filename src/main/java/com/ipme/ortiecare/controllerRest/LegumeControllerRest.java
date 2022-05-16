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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipme.ortiecare.model.ConseilDeCulture;
import com.ipme.ortiecare.model.Legume;
import com.ipme.ortiecare.model.LegumesConseilsDeCulture;
import com.ipme.ortiecare.model.Sol;
import com.ipme.ortiecare.services.ConseilDeCultureService;
import com.ipme.ortiecare.services.LegumeService;
import com.ipme.ortiecare.services.SolService;
import com.ipme.ortiecare.services.DTO.LegumeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping("api/legumes")
@Tag(name = "Legume", description = "Legume HTTP REQUESTS")
public class LegumeControllerRest {

	@Autowired
	private LegumeService legumeService;
	@Autowired
	private ConseilDeCultureService conseilService;
	@Autowired
	private SolService solService;

    @Operation(summary = "findAll du repository legume", description = "Récupère toutes les legumes présents dans la base de données et les renvoie en tant que DTO.", tags = { "Legume" })
	@GetMapping("getAll")
	public ResponseEntity<List<LegumeDTO>> getLegumes(HttpSession session) {
		try {
			return ResponseEntity.ok(legumeService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
//	@PostMapping("create")
//	public ResponseEntity<Legume> createLegume(@RequestBody String nom, boolean resseme, boolean gousse, String tempsRecolte,
//			String poidsMoyen, String titreConseil, String nomLegumeAssocie, String nomSol, HttpSession session) {
//		
//		ConseilDeCulture selectedConseil = conseilService.findByTitre(titreConseil);
//		Legume selectedLegume = legumeService.findByNom(nomLegumeAssocie);
//		Sol selectedSol = solService.findByNom(nomSol);
//		LegumesConseilsDeCulture linkConseil = new LegumesConseilsDeCulture();
//		
//		return new ResponseEntity<Legume>(legumeService.create(nom, tempsRecolte,
//				poidsMoyen, selectedConseil.getIdConseil(), legume.getLegumesAssocies(),
//				legume.isAutoReseme(), legume.isGousse(), legume.getBestSol()), HttpStatus.CREATED);
//	}

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
	
	@GetMapping("sol/{idLegume}/{idSol}")
	public ResponseEntity<List<LegumeDTO>> getLegumeBySolAndId(@PathVariable("idSol") Sol idSol,@PathVariable("idLegume") UUID idLegume, HttpSession session) {
		try {
			return ResponseEntity.ok(legumeService.findBySolAndId(idSol, idLegume));
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
