package com.ipme.ortiecare.model;

import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

// annotations pour bdd -- Spring

@Entity
@Table(name = "ConseilsDeCulture")
public class ConseilDeCulture{
	
	
	// Attributs & annotations pour bdd -- Spring
	@Id
	@Column(name = "idConseil", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID idConseil;
	
	@Column(name ="titre", length=100)
	@NotNull
	@NotEmpty
	private String titre;
	
	@Column(name ="description", length=255)
	@NotNull
	@NotEmpty
	private String description;
	
	// Constructeur par défaut necessaire pour hibernate
	public ConseilDeCulture(){	}
	public ConseilDeCulture(UUID idConseil,String titre, String description) {
		this.idConseil = idConseil;
		this.titre = titre;
		this.description = description;
	}

	public UUID getIdConseil() {return idConseil;}

	public String getTitre() {return titre;}

	public void setTitre(String titre) {this.titre = titre;}

	public String getDescription() {return description;}

	public void setDescription(String description) {this.description = description;}

}
