package com.ipme.ortiecare.model;

public class Culture {
	
	private int idCulture;
	private String descCulture;
	private Sols bestSoil;
	private Plantation plantationConcernee;
	
	public Culture (int idCulture, String descCulture, Sols bestSoil, Plantation plantationConcernee)
	{
		this.setIdCulture(idCulture);
		this.setDescCulture(descCulture);
		this.setBestSoil(bestSoil);
		this.setPlantationConcernee(plantationConcernee);
	}

	public Plantation getPlantationConcernee() {
		return plantationConcernee;
	}

	public void setPlantationConcernee(Plantation plantationConcernee) {
		this.plantationConcernee = plantationConcernee;
	}

	public Sols getBestSoil() {
		return bestSoil;
	}

	public void setBestSoil(Sols bestSoil) {
		this.bestSoil = bestSoil;
	}

	public String getDescCulture() {
		return descCulture;
	}

	public void setDescCulture(String descCulture) {
		this.descCulture = descCulture;
	}

	public int getIdCulture() {
		return idCulture;
	}

	public void setIdCulture(int idCulture) {
		this.idCulture = idCulture;
	}
}