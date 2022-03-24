package com.ipme.ortiecare.model;

import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "legumes")


public class Legumes extends Plantation{
	@Id
	@Column(name = "idLegume")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID idLegume;
	@Column(name = "legumeDescription", length = 255)
	private UUID legumeDescription;
	private boolean autoReseme;
	private boolean isGousse;

	
	public Legumes(UUID idPlant, int tempsAvantRecolteEnMois, int poidsMoyenFruitEnG, String conseilDeCulture, boolean autoReseme, boolean isGousse)
	{
		super(idPlant, tempsAvantRecolteEnMois, poidsMoyenFruitEnG, conseilDeCulture);
		this.setAutoReseme(autoReseme);
		this.setGousse(isGousse);
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
}
