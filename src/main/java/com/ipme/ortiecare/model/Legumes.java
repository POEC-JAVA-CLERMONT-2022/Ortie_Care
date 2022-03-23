package com.ipme.ortiecare.model;

public class Legumes extends Plantation{
	private boolean autoReseme;
	private boolean isGousse;

	
	public Legumes(int idPlant, int tempsAvantRecolteEnMois, int poidsMoyenFruitEnG, String conseilDeCulture, boolean autoReseme, boolean isGousse)
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
