package com.ipme.ortiecare.services;


import com.ipme.ortiecare.model.ConseilDeCulture;
import com.ipme.ortiecare.model.User;
import com.ipme.ortiecare.repository.UserRepository;
import com.ipme.ortiecare.services.DTO.UserDTO;

import java.util.*;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	Logger logger = LoggerFactory.getLogger(User.class);

	@Autowired
	private UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public List<UserDTO> findAll() {
		ArrayList<UserDTO> userDTOList = new ArrayList<>();
		for (User user : userRepo.findAll()) {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(user, userDTO);
			userDTOList.add(userDTO);
		}
		return userDTOList;
	}

	public UserDTO convertUser(User unUser) {
		if (unUser != null) {
			return new UserDTO(unUser.isAdmin(), unUser.getFirstName(), unUser.getLastName(), unUser.getEmail());
		} else {
			return new UserDTO();
		}
	}

	public UserDTO findById(UUID id) {
		if (id != null) {
			logger.info("Recherche par id : " + id);

			return convertUser(userRepo.getById(id));
		} else {
			logger.warn("Recherche d'id échouée");
			return new UserDTO();
		}
	}

	public ArrayList<UserDTO> findListByIs_Admin(Integer vraiOuFaux) {

		if (vraiOuFaux != null) {
			logger.info("Statut utilisateur : " + vraiOuFaux);
			ArrayList<UserDTO> usersDTO = new ArrayList<>();
			for (User unUser : userRepo.findByIsAdmin(vraiOuFaux)) {
				usersDTO.add(convertUser(unUser));
			}
			return usersDTO;
		} else {
			logger.warn("Statut utilisateur non trouvé");
			return new ArrayList<UserDTO>();
		}
	}

	public UserDTO findByIs_Admin(Integer vraiOuFaux) {
		if(vraiOuFaux != null)
		{
			return convertUser(userRepo.getByIsAdmin(vraiOuFaux));
		}
		else
		{
			return new UserDTO();
		}
		
	}

	public UserDTO findByFirstNameAndLastName(String firstName, String lastName) {
		if(firstName != "" && lastName != "")
		{
			return convertUser(userRepo.findByFirstNameAndLastName(firstName, lastName));
		}
		else
		{
			return new UserDTO();
		}
		
	}

	public User create(String password, String firstName, String lastName, String email) {
		User ceUser = new User(UUID.randomUUID(), password, firstName, lastName, email);
		this.userRepo.save(ceUser);
		return ceUser;
	}

	// Pas sur de cette methode = Le changement sur l'appli est repercut� en base ?
	// ou il faudrait le save dans le repo apr�s l'avoir modifi� sur la plateforme
	public void setAdmin(User thisUser) {
		if (!thisUser.isAdmin() && thisUser != null) {
			thisUser.setAdmin(true);
			// pas sur de l'utilité du coup
			this.userRepo.save(thisUser);
		}
	}

	public int deleteById(UUID idUser) {
		if(idUser != null && idUser.toString() != "")
		{
			logger.info("Début de suppression du user");
			userRepo.deleteById(idUser);
			return 1;
		}
		else
		{
			logger.warn("La suppression a échouée ; id null ou vide");
		return 0;
	}
	}
	
	// Modification du user
		@Transactional
		public User modifById(UUID idUser, String firstName, String lastName, String email) {
			logger.info("Récupération de la modification du user " + idUser);
			if (idUser != null && idUser.toString() != "") {
				User user = this.userRepo.getById(idUser);
				if(firstName != "") {
					user.setFirstName(firstName);
				}
				if(lastName != "") {
					user.setLastName(lastName);
				}
				if(email != "") {
					user.setEmail(email);
				}
				this.userRepo.save(user);
				return user;
			} else {
				logger.error(
						"Erreur de modification du user : Renvoi d'un utilisateur vide");
				return new User();
			}
		}

}
