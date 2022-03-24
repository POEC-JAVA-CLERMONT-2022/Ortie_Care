package com.ipme.ortiecare.model;

import java.util.*;

public abstract class Plantation {
	
	protected int idPlantation;
	protected int tempsAvantRecolteEnMois;
	protected int poidsMoyenFruitEnG;
	protected String conseilDeCulture;
	protected ArrayList<Inconvenients> listeInconvenients;
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
