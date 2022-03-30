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
	
	@Column(name="conseilDeCulture", length=255)
	@OneToMany
	private Set<ConseilDeCulture> conseilsDeCulture;
	
	//@Column(name="conseilDeCulture", length=255)
	@OneToMany
	private Set<Legume> legumesAssocies;
	
	
	public Legume(UUID idLegume, int tempsAvantRecolteEnMois, int poidsMoyenFruitEnG, Set<ConseilDeCulture> conseilsDeCulture, boolean autoReseme, boolean isGousse)
	{
		this.idLegume = idLegume;
		this.tempsAvantRecolteEnMois = tempsAvantRecolteEnMois;
		this.poidsMoyenFruitEnG = poidsMoyenFruitEnG;
		this.conseilsDeCulture = conseilsDeCulture;
		this.autoReseme = autoReseme;
		this.isGousse = isGousse;
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
