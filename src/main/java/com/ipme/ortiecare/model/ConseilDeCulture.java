package com.ipme.ortiecare.model;

import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

// annotations pour bdd -- Spring

@Entity
@Table(name = "ConseilsDeCulture")
public class ConseilDeCulture {
	
	// Attributs & annotations pour bdd -- Spring
	@Id
	@Column(name = "idConseil", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID idConseil;
	
	@Column(name ="titre", length=100)
	private String titre;
	
	@Column(name ="description", length=255)
	private String description;
	
	public ConseilDeCulture(UUID idConseil,String titre, String description) {
		this.idConseil = idConseil;
		this.titre = titre;
		this.description = description;
	}

	// get set 
	public UUID getIdConseil() {return idConseil;}

	public String getTitre() {return titre;}

	public void setTitre(String titre) {this.titre = titre;}

	public String getDescription() {return description;}

	public void setDescription(String description) {this.description = description;}

}
