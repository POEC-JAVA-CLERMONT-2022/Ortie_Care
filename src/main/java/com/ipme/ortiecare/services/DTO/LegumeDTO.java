package com.ipme.ortiecare.services.DTO;

import java.util.Set;
import java.util.UUID;

import com.ipme.ortiecare.model.LegumesConseilsDeCulture;
import com.ipme.ortiecare.model.LegumesLegumesAssocies;
import com.ipme.ortiecare.model.Sol;

public class LegumeDTO {

	private String nom;
	private int tempsAvantRecolteEnMois;
	private int poidsMoyenFruitEnG;
	private Set<LegumesConseilsDeCulture> conseilsDeCulture;
	private Set<LegumesLegumesAssocies> legumesAssocies;
	private boolean autoReseme;
	private boolean isGousse;
	private Sol bestSol;

	public LegumeDTO() {}
	public LegumeDTO(String nom, int tempsAvantRecolteEnMois, int poidsMoyenFruitEnG,
			Set<LegumesConseilsDeCulture> conseilsDeCulture, Set<LegumesLegumesAssocies> legumesAssocies,
			boolean autoReseme, boolean isGousse, Sol bestSol) {
		this.nom = nom;
		this.tempsAvantRecolteEnMois = tempsAvantRecolteEnMois;
		this.poidsMoyenFruitEnG = poidsMoyenFruitEnG;
		this.conseilsDeCulture = conseilsDeCulture;
		this.legumesAssocies = legumesAssocies;
		this.autoReseme = autoReseme;
		this.isGousse = isGousse;
		this.bestSol = bestSol;

	}

	public String getNom() {return nom;}

	public void setNom(String nom) {this.nom = nom;}

	public int getTempsAvantRecolteEnMois() {return tempsAvantRecolteEnMois;}

	public void setTempsAvantRecolteEnMois(int tempsAvantRecolteEnMois) {this.tempsAvantRecolteEnMois = tempsAvantRecolteEnMois;}

	public int getPoidsMoyenFruitEnG() {return poidsMoyenFruitEnG;}

	public void setPoidsMoyenFruitEnG(int poidsMoyenFruitEnG) {this.poidsMoyenFruitEnG = poidsMoyenFruitEnG;}

	public Set<LegumesConseilsDeCulture> getConseilsDeCulture() {return conseilsDeCulture;}

	public void setConseilsDeCulture(Set<LegumesConseilsDeCulture> conseilsDeCulture) {this.conseilsDeCulture = conseilsDeCulture;}

	public Set<LegumesLegumesAssocies> getLegumesAssocies() {return legumesAssocies;}

	public void setLegumesAssocies(Set<LegumesLegumesAssocies> legumesAssocies) {this.legumesAssocies = legumesAssocies;}

	public boolean isAutoReseme() {return autoReseme;}

	public void setAutoReseme(boolean autoReseme) {this.autoReseme = autoReseme;}

	public boolean isGousse() {return isGousse;}

	public void setGousse(boolean isGousse) {this.isGousse = isGousse;}

	public Sol getBestSol() {return bestSol;}

	public void setBestSol(Sol bestSol) {this.bestSol = bestSol;}

}
