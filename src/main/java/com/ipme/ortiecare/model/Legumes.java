package com.ipme.ortiecare.model;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "legumes")
public class Legumes{

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
	private Set<Legumes> legumesAssocies;
	
	
	
	@Column(name="idInconvenient")
	@ManyToMany//(fetch=FetchType.EAGER)
	private Set<Inconvenients> listeInconvenients;
	
	@Column(name="idInconvenient")
	@ManyToMany//(fetch=FetchType.EAGER)
	private Set<Avantages> listeAvantages;

	
	public Legumes(UUID idLegume, int tempsAvantRecolteEnMois, int poidsMoyenFruitEnG, Set<ConseilDeCulture> conseilsDeCulture, boolean autoReseme, boolean isGousse)
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
	public void addInconvenient(Inconvenients unInconvenient)
	{
		if(unInconvenient!=null)
		{
			this.listeInconvenients.add(unInconvenient);
		}
	}
	
	public void addAvantage(Avantages unAvantage)
	{
		if(unAvantage!=null)
		{
			this.listeAvantages.add(unAvantage);
		}
	}
}
