package com.ipme.ortiecare.services.DTO;

import java.util.List;

public class LegumeDTO {

	private String nom;
	private int tempsAvantRecolteEnMois;
	private int poidsMoyenFruitEnG;
	private List<ConseilDeCultureDTO> conseilsDeCulture;
	private List<LegumeDTO> legumesAssocies;
	private boolean autoReseme;
	private boolean isGousse;
	private SolDTO bestSol;
	

	public LegumeDTO() {}
	public LegumeDTO(String nom, int tempsAvantRecolteEnMois, int poidsMoyenFruitEnG,
			List<ConseilDeCultureDTO> conseilsDeCulture, List<LegumeDTO> legumesAssocies,
			boolean autoReseme, boolean isGousse, SolDTO bestSol) {
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

	public List<ConseilDeCultureDTO> getConseilsDeCulture() {return conseilsDeCulture;}

	public void setConseilsDeCulture(List<ConseilDeCultureDTO> conseilsDeCulture) {this.conseilsDeCulture = conseilsDeCulture;}

	public List<LegumeDTO> getLegumesAssocies() {return legumesAssocies;}

	public void setLegumesAssocies(List<LegumeDTO> legumesAssocies) {this.legumesAssocies = legumesAssocies;}

	public boolean isAutoReseme() {return autoReseme;}

	public void setAutoReseme(boolean autoReseme) {this.autoReseme = autoReseme;}

	public boolean isisGousse() {return isGousse;}

	public void setGousse(boolean isGousse) {this.isGousse = isGousse;}

	public SolDTO getBestSol() {return bestSol;}

	public void setBestSol(SolDTO bestSol) {this.bestSol = bestSol;}

}
