package com.ipme.ortiecare.model;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import ch.qos.logback.classic.Logger;

// Annotations pour bdd -- Spring
@Entity
@Table(name = "legumes")
public class Legume{

	// Attributs & annotations pour bdd -- Spring
	@Id
	@Column(name="idLegume", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID idLegume;
	
	@Column(name="nom", length=30)
	private String nom;

	@Column(name ="autoReseme", length=20)
	private boolean autoReseme;
	
	@Column(name ="isGousse", length=20)
	private boolean isGousse;
	
	@Column(name="tempsAvantRecolteEnMois", length=30)
	private int tempsAvantRecolteEnMois;
	
	@Column(name="poidsMoyenFruitEnG", length=30)
	private int poidsMoyenFruitEnG;
	
	@OneToMany(mappedBy="conseilLegume.legume")
	private Set<LegumesConseilsDeCulture> conseilsDeCulture;
	
	@OneToMany(mappedBy="assoLegumes.legume1")
	private Set<LegumesLegumesAssocies> legumesAssocies;
	
	@ManyToOne
	private Sol bestSol; 
	
	
	public Legume(UUID idLegume, String nom, int tempsAvantRecolteEnMois, int poidsMoyenFruitEnG, Set<LegumesConseilsDeCulture> conseilsDeCulture, Set<LegumesLegumesAssocies> legumesAssocies, boolean autoReseme, boolean isGousse, Sol bestSol)
	{
		this.idLegume = idLegume;
		this.nom = nom;
		this.tempsAvantRecolteEnMois = tempsAvantRecolteEnMois;
		this.poidsMoyenFruitEnG = poidsMoyenFruitEnG;
		this.conseilsDeCulture = conseilsDeCulture;
		this.legumesAssocies = legumesAssocies;
		this.autoReseme = autoReseme;
		this.isGousse = isGousse;
		this.bestSol = bestSol;
		
	}
	public UUID getIdLegume() {return idLegume;}

	public Sol getBestSol() {return bestSol;}
	
	public void setBestSol(Sol bestSol) {this.bestSol = bestSol;}
	
	public Set<LegumesLegumesAssocies> getLegumesAssocies() {return legumesAssocies;}
	
	// Get add remove liste de legumes associes
	
	public void setLegumesAssocies(Set<LegumesLegumesAssocies> legumesAssocies) {this.legumesAssocies = legumesAssocies;}
	
	public void addLegumeAssocie(LegumesLegumesAssocies unLegume)
	{
		if(unLegume!=null)
		{
			this.legumesAssocies.add(unLegume);
		}
	}
	
	public void removeLegumeAssocie(LegumesLegumesAssocies unLegume)
	{
		if(unLegume!=null)
		{
			this.legumesAssocies.remove(unLegume);
		}
	}
		
	public String getNom() {return nom;}
	
	public void setNom(String nom) {this.nom = nom;}
	
	public boolean isGousse() {return isGousse;}
	
	public void setGousse(boolean isGousse) {this.isGousse = isGousse;}
	
	public boolean isAutoReseme() {return autoReseme;}
	
	public void setAutoReseme(boolean autoReseme) {this.autoReseme = autoReseme;}
	
	// Get add remove liste de conseils
	public Set<LegumesConseilsDeCulture> getConseils() {return conseilsDeCulture;}

	public void addConseil(LegumesConseilsDeCulture unConseil)
	{
		if(unConseil!=null)
		{
			this.conseilsDeCulture.add(unConseil);
		}
	}
	
	public void removeConseil(LegumesConseilsDeCulture unConseil)
	{
		if(unConseil!=null)
		{
			this.conseilsDeCulture.remove(unConseil);
		}
	}
}
