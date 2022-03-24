package com.ipme.ortiecare.model;

import java.util.*;

import javax.persistence.*;


import org.hibernate.annotations.Type;

@Entity
@Table(name = "Plantations")
public abstract class Plantation {
	
	@Id
	@Column(name="idPlantation", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Type(type="org.hibernate.type.UUIDCharType")
	protected UUID idPlantation;
	
	@Column(name="tempsAvantRecolteEnMois", length=30)
	protected int tempsAvantRecolteEnMois;
	
	@Column(name="poidsMoyenFruitEnG", length=30)
	protected int poidsMoyenFruitEnG;
	
	@Column(name="conseilDeCulture", length=255)
	protected String conseilDeCulture;
	
	@Column(name="idInconvenient")
	@ManyToMany(fetch=FetchType.EAGER)
	protected ArrayList<Inconvenients> listeInconvenients;
	
	@Column(name="idAvantage")
	@ManyToMany(fetch=FetchType.EAGER)
	protected ArrayList<Avantages> listeAvantages;
	
	public ArrayList<Inconvenients> getListeInconvenients() {
		return listeInconvenients;
	}

	public void setListeInconvenients(ArrayList<Inconvenients> listeInconvenients) {
		this.listeInconvenients = listeInconvenients;
	}

	public ArrayList<Avantages> getListeAvantages() {
		return listeAvantages;
	}

	public void setListeAvantages(ArrayList<Avantages> listeAvantages) {
		this.listeAvantages = listeAvantages;
	}

	public Plantation(UUID idPlantation, int tempsAvantRecolteEnMois, int poidsMoyenFruitEnG, String conseilDeCulture)
	{
		this.idPlantation = idPlantation;
		this.tempsAvantRecolteEnMois = tempsAvantRecolteEnMois;
		this.poidsMoyenFruitEnG = poidsMoyenFruitEnG;
		this.conseilDeCulture = conseilDeCulture;
	}

	public int getTempsAvantRecolteEnMois() {
		return tempsAvantRecolteEnMois;
	}

	public void setTempsAvantRecolteEnMois(int tempsAvantRecolteEnMois) {
		this.tempsAvantRecolteEnMois = tempsAvantRecolteEnMois;
	}

	public int getPoidsMoyenFruitEnG() {
		return poidsMoyenFruitEnG;
	}

	public void setPoidsMoyenFruitEnG(int poidsMoyenFruitEnG) {
		this.poidsMoyenFruitEnG = poidsMoyenFruitEnG;
	}
	
	public UUID getIdPlantation() {
		return idPlantation;
	}
}
