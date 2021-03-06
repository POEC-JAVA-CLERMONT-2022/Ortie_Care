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
import com.ipme.ortiecare.services.DTO.SolDTO;


@Service
public class SolService {

	Logger logger = LoggerFactory.getLogger(Sol.class);

	@Autowired
	private SolRepository solRepo;

	public SolService(SolRepository solRepo) {
		this.solRepo = solRepo;
	}

	public Sol create(String nomSol, String textureSol, String structureSol, String avantageSol,
			String inconvenientSol) {
		Sol ceSol = new Sol(UUID.randomUUID(), nomSol, textureSol, structureSol, avantageSol, inconvenientSol);
		this.solRepo.save(ceSol);
		return ceSol;
	}

	public ArrayList<SolDTO> findAll() {
		ArrayList<SolDTO> solDTOList = new ArrayList<>();
		for (Sol sol : solRepo.findAll()) {
			// Exemple d'utilisation de copyProperties
//			SolDTO solDTO = new SolDTO();
//			BeanUtils.copyProperties(sol, solDTO);
			solDTOList.add(convertSol(sol));
		}
		return solDTOList;
	}

	public SolDTO findById(UUID id) {
		if (id != null && id.toString() != "") {
			logger.info("La recherche a fonctionné pour l'id : " + id);
			return convertSol(solRepo.getById(id));
		} else {
			logger.warn(
					"La recherche n'a pas fonctionné. Renvoi d'un objet Sol vide. Valeur du paramètre passé : " + id);
			return new SolDTO();
		}
	}
	
	public Sol findByNom(String nom) {
		if (nom != null && nom.toString() != "") {
			logger.info("La recherche a fonctionné pour le nom : " + nom);
			return solRepo.findByNomSol(nom);
		} else {
			logger.warn("La recherche n'a pas fonctionné. Renvoi d'un objet null. Valeur du paramètre passé : " + nom);
			return null;
		}
	}
	

	public SolDTO convertSol(Sol unSol) {
		if (unSol != null) {
			return new SolDTO(unSol.getId() ,unSol.getNomSol(), unSol.getTextureSol(), unSol.getStructureSol(), unSol.getAvantageSol(),
					unSol.getInconvenientSol());
		} else {
			return new SolDTO();
		}
	}

	public List<SolDTO> findByStructureSolContaining(String boutStructureSol) {
		if (boutStructureSol != null && boutStructureSol != "") {
			logger.info("Recherche par bout de structure de sol : " + boutStructureSol);
			ArrayList<SolDTO> solsDTO = new ArrayList<>();
			for (Sol unSol : solRepo.findByStructureSolContaining(boutStructureSol)) {
				solsDTO.add(convertSol(unSol));

			}
			return solsDTO;
		} else {
			logger.warn("Recherche de structure échouée : retour d'une liste vide");
			return new ArrayList<SolDTO>();
		}

	}

	public List<SolDTO> findByTextureSolContaining(String boutTextureSol) {
		if (boutTextureSol != null && boutTextureSol != "") {
			logger.info("Recherche par bout de texture sol : " + boutTextureSol);
			ArrayList<SolDTO> solsDTO = new ArrayList<>();
			for (Sol unSol : solRepo.findByTextureSolContaining(boutTextureSol)) {
				solsDTO.add(convertSol(unSol));
			}
			return solsDTO;
		} else {
			logger.warn("Recherche de texture échouée : retour d'une liste vide");
			return new ArrayList<SolDTO>();
		}
	}

	public int deleteById(UUID idSol) {
		if (idSol != null && idSol.toString() != "") {
			logger.info("Début de suppression du sol");
			solRepo.deleteById(idSol);
			return 1;
		} else {
			logger.warn("La suppression a échouée ; id null ou vide");
			return 0;
		}

	}

}
