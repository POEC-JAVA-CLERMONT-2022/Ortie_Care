package com.ipme.ortiecare.services;
import com.ipme.ortiecare.model.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipme.ortiecare.repository.ConseilDeCultureRepository;
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
	
	public List<LegumeDTO> findAll()
	{
		ArrayList<LegumeDTO> legumesDTO = new ArrayList<>();
		for (Legume unLegume : legumesRepo.findAll())
		{
			legumesDTO.add(convertLegume(unLegume, true));
		}
		return legumesDTO;
	}
	
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
	
	// Recup la liste des legumes associes pour un legume
	public List<LegumeDTO> findListeLegumesAssocies(UUID idLegume)
	{
		if(idLegume != null && idLegume.toString() != "")
		{
			logger.info("Liste de legumes associes trouvée ");
			ArrayList<LegumeDTO> legumesDTO = new ArrayList<>();
			for (Legume unLegume : legumesRepo.findLegumesAssocies(idLegume))
			{
				legumesDTO.add(convertLegume(unLegume, true));
			}
			return legumesDTO;
		}
		else
		{
			logger.warn("Aucun legume associés trouvés avec cet id(" + idLegume + ") : retour d'une liste vide");
			return new ArrayList<LegumeDTO>();
		}
	}
	
	public LegumeDTO findByNom(String nom)
	{
		if(nom != null && nom != "")
		{
			logger.info("Legume trouvé avec son nom");
			return convertLegume(legumesRepo.findByNom(nom), true);
		}
		else
		{
			logger.warn("Aucun legume trouvé avec ce nom (" + nom + ") : retour d'un objet vide");
			return new LegumeDTO();
		}
	}
	
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
	
	public void addAssociationLegumeLegume(Legume premierLegume, Legume deuxiemeLegume)
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
		}
		else
		{
			logger.warn("L'ajout de l'association a échoué ; l'association existe déjà.");
		}
	}
	// TODO : A vérifier et tester, boolean doContinue pour empecher de boucler sur l'appel à lui même
	// Fonctionne 
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
					legumesDTO.add(convertLegume(uneAssociation.getAssoLegumes().getLegume2(), false));
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
	
	public SolDTO convertSol(Sol unSol) {
		if (unSol != null) {
			return new SolDTO(unSol.getNomSol(), unSol.getTextureSol(), unSol.getStructureSol(), unSol.getAvantageSol(),
					unSol.getInconvenientSol());
		} else {
			return new SolDTO();
		}
	}
}
