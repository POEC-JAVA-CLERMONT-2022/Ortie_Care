package com.ipme.ortiecare.model;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "legumes")
public class Legume{

	@Id
	@Column(name="idLegume", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID idLegume;
	
	@Column(name ="autoReseme", length=20)
	private boolean autoReseme;
	
	@Column(name ="isGousse", length=20)
	private boolean isGousse;
	
	@Column(name="tempsAvantRecolteEnMois", length=30)
	private int tempsAvantRecolteEnMois;
	
	@Column(name="poidsMoyenFruitEnG", length=30)
	private int poidsMoyenFruitEnG;
	
	@OneToMany
	private Set<ConseilDeCulture> conseilsDeCulture;
	
	@OneToMany
	private Set<Legume> legumesAssocies;
	
	@ManyToOne
	private Sol bestSol; 
	
	
	public Legume(UUID idLegume, int tempsAvantRecolteEnMois, int poidsMoyenFruitEnG, Set<ConseilDeCulture> conseilsDeCulture, boolean autoReseme, boolean isGousse, Sol bestSol)
	{
		this.idLegume = idLegume;
		this.tempsAvantRecolteEnMois = tempsAvantRecolteEnMois;
		this.poidsMoyenFruitEnG = poidsMoyenFruitEnG;
		this.conseilsDeCulture = conseilsDeCulture;
		this.autoReseme = autoReseme;
		this.isGousse = isGousse;
		this.bestSol = bestSol;
	}
	public Sol getBestSol() {
		return bestSol;
	}
	public void setBestSol(Sol bestSol) {
		this.bestSol = bestSol;
	}
	public boolean isGousse() {
		return isGousse;
	}
	public void setGousse(boolean isGousse) {
		this.isGousse = isGousse;
	}
	public boolean isAutoReseme() {
		return autoReseme;
	}
	public void setAutoReseme(boolean autoReseme) {
		this.autoReseme = autoReseme;
	}
	public void addConseil(ConseilDeCulture unConseil)
	{
		if(unConseil!=null)
		{
			this.conseilsDeCulture.add(unConseil);
		}
	}
	
	public void removeConseil(ConseilDeCulture unConseil)
	{
		if(unConseil!=null)
		{
			this.conseilsDeCulture.add(unConseil);
		}
	}
}
