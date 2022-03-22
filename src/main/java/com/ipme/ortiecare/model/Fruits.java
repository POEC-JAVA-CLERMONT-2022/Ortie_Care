

package com.ipme.ortiecare.model;

public class Fruits extends Plantation{
	private int tempsAvantPremiereRecolteEnAnnee;
	private int hauteurMaxEnMetre;
	public Fruits(int idPlant, int tempsAvantRecolteEnMois, int poidsMoyenFruitEnG, String conseilDeCulture, int tempsAvantPremiereRecolteEnAnnee, int hauteurMaxEnMetre)
	{
		super(idPlant, tempsAvantRecolteEnMois, poidsMoyenFruitEnG, conseilDeCulture);
		this.setTempsAvantPremiereRecolteEnAnnee(tempsAvantPremiereRecolteEnAnnee);
		this.setHauteurMaxEnMetre(hauteurMaxEnMetre);
	}
	public int getTempsAvantPremiereRecolteEnAnnee() {
		return tempsAvantPremiereRecolteEnAnnee;
	}
	public void setTempsAvantPremiereRecolteEnAnnee(int tempsAvantPremiereRecolteEnAnnee) {
		this.tempsAvantPremiereRecolteEnAnnee = tempsAvantPremiereRecolteEnAnnee;
	}
	public int getHauteurMaxEnMetre() {
		return hauteurMaxEnMetre;
	}
	public void setHauteurMaxEnMetre(int hauteurMaxEnMetre) {
		this.hauteurMaxEnMetre = hauteurMaxEnMetre;
	}
	
}