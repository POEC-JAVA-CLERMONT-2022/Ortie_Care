//package com.ipme.ortiecare.model;
//
//import java.util.*;
//
//import javax.persistence.*;
//
//
//import org.hibernate.annotations.Type;
//@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//public abstract class Plantation {
//	
//	@Id
//	@Column(name="idPlantation", nullable=false)
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Type(type="org.hibernate.type.UUIDCharType")
//	protected UUID idPlantation;
//	
//	@Column(name="tempsAvantRecolteEnMois", length=30)
//	protected int tempsAvantRecolteEnMois;
//	
//	@Column(name="poidsMoyenFruitEnG", length=30)
//	protected int poidsMoyenFruitEnG;
//	
//	@Column(name="conseilDeCulture", length=255)
//	protected String conseilDeCulture;
//	
//	public Plantation(UUID idPlantation, int tempsAvantRecolteEnMois, int poidsMoyenFruitEnG, String conseilDeCulture)
//	{
//		this.idPlantation = idPlantation;
//		this.tempsAvantRecolteEnMois = tempsAvantRecolteEnMois;
//		this.poidsMoyenFruitEnG = poidsMoyenFruitEnG;
//		this.conseilDeCulture = conseilDeCulture;
//	}
//
//	public int getTempsAvantRecolteEnMois() {
//		return tempsAvantRecolteEnMois;
//	}
//
//	public void setTempsAvantRecolteEnMois(int tempsAvantRecolteEnMois) {
//		this.tempsAvantRecolteEnMois = tempsAvantRecolteEnMois;
//	}
//
//	public int getPoidsMoyenFruitEnG() {
//		return poidsMoyenFruitEnG;
//	}
//
//	public void setPoidsMoyenFruitEnG(int poidsMoyenFruitEnG) {
//		this.poidsMoyenFruitEnG = poidsMoyenFruitEnG;
//	}
//	
//	public UUID getIdPlantation() {
//		return idPlantation;
//	}
//}
