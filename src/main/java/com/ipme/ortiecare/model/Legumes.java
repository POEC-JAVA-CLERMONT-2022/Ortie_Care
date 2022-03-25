package com.ipme.ortiecare.model;

import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "legumes")


public class Legumes extends Plantation{

	
	@Column(name ="autoReseme", length=20)
	private boolean autoReseme;
	
	@Column(name ="isGousse", length=20)
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
