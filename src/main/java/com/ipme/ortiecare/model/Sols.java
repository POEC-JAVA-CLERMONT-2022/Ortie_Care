package com.ipme.ortiecare.model;

import java.util.ArrayList;
import java.util.List;


public class Sols {
	
	private int id;
	private String description;
	private List<Avantages> listeAvantages;
	private List<Inconvenients> listeInconvenients;
	
	public Sols(int id, String description, List<Inconvenients> listeInconvenients, List<Avantages> listeAvantages) {
		
		this.id = id;
        this.description = description;
        this.listeInconvenients = listeInconvenients;
        this.listeAvantages = listeAvantages;
	}
	
	


	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Avantages> getListeAvantages() {
		return listeAvantages;
	}

	public void setListeAvantages(List<Avantages> listeAvantages) {
		this.listeAvantages = listeAvantages;
	}

	public List<Inconvenients> getListeInconvenients() {
		return listeInconvenients;
	}

	public void setListeInconvenients(List<Inconvenients> listeInconvenients) {
		this.listeInconvenients = listeInconvenients;
	}
	
	
}
