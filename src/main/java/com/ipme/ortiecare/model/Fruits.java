

package com.ipme.ortiecare.model;

import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "fruits")
public class Fruits extends Plantation{
	
	@Column(name ="tempsAvantPremiereRecolteEnAnnee", length=255)
	private int tempsAvantPremiereRecolteEnAnnee;
	
	@Column(name ="hauteurMaxEnMetre", length=255)
	private int hauteurMaxEnMetre;
	
	public Fruits(UUID idPlant, int tempsAvantRecolteEnMois, int poidsMoyenFruitEnG, String conseilDeCulture, int tempsAvantPremiereRecolteEnAnnee, int hauteurMaxEnMetre)
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