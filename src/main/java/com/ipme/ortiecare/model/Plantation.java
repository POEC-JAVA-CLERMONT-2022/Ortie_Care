package com.ipme.ortiecare.model;

public abstract class Plantation {
	
	protected int idPlantation;
	protected int tempsAvantRecolteEnMois;
	protected int poidsMoyenFruitEnG;
	protected String conseilDeCulture;
	
	public Plantation(int idPlantation, int tempsAvantRecolteEnMois, int poidsMoyenFruitEnG, String conseilDeCulture)
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
	
	public int getIdPlantation() {
		return idPlantation;
	}
}
