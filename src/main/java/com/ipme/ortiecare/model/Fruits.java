

package com.ipme.ortiecare.model;

import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "fruits")

public class Fruits extends Plantation{
	@Id
	@Column(name = "idFruit")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID idFruit;
	@Column(name = "fruitDescription", length = 255)
	private UUID fruitDescription;
	private int tempsAvantPremiereRecolteEnAnnee;
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