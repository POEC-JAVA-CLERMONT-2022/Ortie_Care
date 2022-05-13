package com.ipme.ortiecare.services;
import com.ipme.ortiecare.model.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ipme.ortiecare.repository.LegumesRepository;
import com.ipme.ortiecare.services.DTO.ConseilDeCultureDTO;
import com.ipme.ortiecare.services.DTO.LegumeDTO;
import com.ipme.ortiecare.services.DTO.SolDTO;


@Service
public class LegumeService {
	
	@Autowired
	private LegumesRepository legumesRepo;
	// Logger
	Logger logger = LoggerFactory.getLogger(LegumeService.class);

	
	public LegumeService (LegumesRepository legumesRepo)
	{
		this.legumesRepo = legumesRepo;
	}
	
	// Création de legume et sauvegarde en base avec methode de base .save du repo
	public Legume create(String nom,int tempsAvantRecolteEnMois, int poidsMoyenFruitEnG, Set<LegumesConseilsDeCulture> conseilsDeCulture, Set<LegumesLegumesAssocies> legumesAssocies, boolean autoReseme, boolean isGousse, Sol bestSol)
	{
		if(nom != null && nom != "" && tempsAvantRecolteEnMois != 0 && poidsMoyenFruitEnG != 0 && conseilsDeCulture != null && legumesAssocies != null && bestSol != null)
		{
			logger.info("Debut creation de legume");
			Legume ceLegume = new Legume(UUID.randomUUID(), nom, tempsAvantRecolteEnMois, poidsMoyenFruitEnG ,conseilsDeCulture, legumesAssocies, autoReseme, isGousse, bestSol);
			this.legumesRepo.save(ceLegume);
			logger.info("Legume " + ceLegume.getNom() + " créé en base.");
			return ceLegume;
		}
		else
		{
			logger.warn("Erreur lors de la création du légume : nom : " + nom + " ; Retour legume vide");
			return new Legume();
		}
		
	}
	
	// Suppression de legume par ID
		public int deleteById(UUID id)
		{
			if(id != null && id.toString() != "")
			{
				logger.info("Début de suppression d'objet legume");
				legumesRepo.deleteById(id);
				return 1;
			}
			else
			{
				logger.warn("La suppression a échouée ; id null ou vide");
				return 0;
			}
				
		}
		
	// Récupération de la liste de tout les légumes et leurs légumes associés, et conversion en DTO
	public List<LegumeDTO> findAll()
	{
		ArrayList<LegumeDTO> legumesDTO = new ArrayList<>();
		for (Legume unLegume : legumesRepo.findAll())
		{
			legumesDTO.add(convertLegume(unLegume, true));
		}
		return legumesDTO;
	}
	
	// Récupération d'un legume par son id et conversion en DTO
	public LegumeDTO findByUUID(UUID id)
	{
		if(id != null && id.toString() != "")
		{
			logger.info("Legume trouvé grace a son id ");
			return convertLegume(legumesRepo.getById(id), true);
		}
		else
		{
			logger.warn("Aucun legume trouvé avec cet id(" + id + ") : retour d'un objet vide");
			return new LegumeDTO();
		}
	}
	
	
	
	// Récupération d'un légume par son nom
	public Legume findByNom(String nom)
	{
		if(nom != null && nom != "")
		{
			logger.info("Legume trouvé avec son nom");
			return legumesRepo.findByNom(nom);
		}
		else
		{
			logger.warn("Aucun legume trouvé avec ce nom (" + nom + ") : retour d'un objet vide");
			return null;
		}
	}
	
	// Récupération d'un légume avec le début de son nom et conversion en DTO
	public List<LegumeDTO> findByNomStartingWith(String nom)
	{
		if(nom != null && nom != "")
		{
			logger.info("Liste de Legumes trouvé avec son nom");
			ArrayList<LegumeDTO> legumesDTO = new ArrayList<>();
			for (Legume unLegume : legumesRepo.findByNomStartingWith(nom))
			{
				legumesDTO.add(convertLegume(unLegume, true));
			}
			return legumesDTO;
		}
		else
		{
			logger.warn("Aucun legume trouvé avec ce nom (" + nom + ") : retour d'une liste vide");
			return new ArrayList<LegumeDTO>();
		}
	}
	
	public List<LegumeDTO> findBySol(Sol idSol)
	{
		if(idSol != null && idSol.toString() != "")
		{
			ArrayList<LegumeDTO> legumesDTO = new ArrayList<>();
			for (Legume unLegume : legumesRepo.findByBestSol(idSol))
			{
				legumesDTO.add(convertLegume(unLegume, true));
			}
			return legumesDTO;
		}
		else
		{
			return new ArrayList<LegumeDTO>();
		}
	}
	// Ajout d'une association legume legume
	// TODO : test et fin
	public int addAssociationLegumeLegume(Legume premierLegume, Legume deuxiemeLegume)
	{
		boolean check = true;
		for (LegumesLegumesAssocies unLegume : premierLegume.getLegumesAssocies())
		{
			if(unLegume.getAssoLegumes().getLegume1().getIdLegume().equals(deuxiemeLegume.getIdLegume()))
			{
				logger.info("L'asso existe déjà entre " + premierLegume.getNom() + " et " + deuxiemeLegume.getNom());
				check = false;
			}
		}
		for (LegumesLegumesAssocies unLegume : deuxiemeLegume.getLegumesAssocies()) 
		{
			if(unLegume.getAssoLegumes().getLegume2().getIdLegume().equals(premierLegume.getIdLegume()))
			{
				logger.info("L'asso existe déjà entre " + premierLegume.getNom() + " et " + deuxiemeLegume.getNom());
				check = false;
			}
		}
		if(check)
		{
			this.legumesRepo.addAssociationLegumeLegume(premierLegume.getIdLegume(), deuxiemeLegume.getIdLegume());
			logger.info("Association entre " + premierLegume.getNom() + " et " + deuxiemeLegume.getNom() + " ajout�e en base !");
			return 1;
		}
		else
		{
			logger.warn("L'ajout de l'association a échoué ; l'association existe déjà.");
			return 0;
		}
	}
	// Recup la liste des legumes associes pour un legume
		public List<LegumeDTO> findListeLegumesAssocies(UUID idLegume) {
			if (idLegume != null && idLegume.toString() != "") {
				logger.info("Liste de legumes associes trouvée ");
				ArrayList<LegumeDTO> legumesDTO = new ArrayList<>();
				
				for (Legume unLegume : legumesRepo.findConseilsLegume(idLegume)) {
					legumesDTO.add(convertLegume(unLegume, true));
				}
				return legumesDTO;
			} else {
				logger.warn("Aucun legume associés trouvés avec cet id(" + idLegume + ") : retour d'une liste vide");
				return new ArrayList<LegumeDTO>();
			}
		}
	
	// Methode de conversion d'un légume en légume DTO. Boolean doContinue pour empecher la boucle infini sur la récupération des légumes associés
	public LegumeDTO convertLegume(Legume legume, boolean doContinue)
	{
		if(legume != null)
		{
			ArrayList<LegumeDTO> legumesDTO = new ArrayList<>();
			ArrayList<ConseilDeCultureDTO> conseilsDTO = new ArrayList<>();
			SolDTO solDTO = convertSol(legume.getBestSol());

			if(doContinue)
			{
				for (LegumesLegumesAssocies uneAssociation : legume.getLegumesAssocies())
				{
					if(legume.getIdLegume() != uneAssociation.getAssoLegumes().getLegume2().getIdLegume())
					{
						legumesDTO.add(convertLegume(uneAssociation.getAssoLegumes().getLegume2(), false));
					}
				}
				for (LegumesConseilsDeCulture unConseil : legume.getConseils())
				{
					conseilsDTO.add(convertConseil(unConseil.getConseilLegume().getConseil()));
				}
			}
			return new LegumeDTO(legume.getNom(), legume.getTempsAvantRecolteEnMois(), legume.getPoidsMoyenFruitEnG(), conseilsDTO, legumesDTO, legume.isAutoReseme(), legume.isGousse(), solDTO);
		}
		else
		{
			return new LegumeDTO();
		}
	}
	// Duplication conversion conseilDeCulture en DTO nécessaire pour l'objet legume
	public ConseilDeCultureDTO convertConseil(ConseilDeCulture conseil)
	{
		if(conseil != null)
		{
			return new ConseilDeCultureDTO(conseil.getTitre(), conseil.getDescription());
		}
		else
		{
			return new ConseilDeCultureDTO();
		}
	}
	
	// Duplication conversion Sol en DTO nécessaire pour l'objet legume
	public SolDTO convertSol(Sol unSol) {
		if (unSol != null) {
			return new SolDTO(unSol.getNomSol(), unSol.getTextureSol(), unSol.getStructureSol(), unSol.getAvantageSol(),
					unSol.getInconvenientSol());
		} else {
			return new SolDTO();
		}
	}
	
}
