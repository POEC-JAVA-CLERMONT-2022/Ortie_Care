//
//
//package com.ipme.ortiecare.model;
//
//import java.util.Set;
//import java.util.UUID;
//
//import javax.persistence.*;
//
//import org.hibernate.annotations.Type;
//
//@Entity
//@Table(name = "fruits")
//public class Fruits{
//	@Id
//	@Column(name="idFruit", nullable=false)
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Type(type="org.hibernate.type.UUIDCharType")
//	private UUID idFruit;
//	
//	@Column(name ="tempsAvantPremiereRecolteEnAnnee", length=255)
//	private int tempsAvantPremiereRecolteEnAnnee;
//	
//	@Column(name ="hauteurMaxEnMetre", length=255)
//	private int hauteurMaxEnMetre;
//	
//	@Column(name ="tempsAvantRecolteEnMois", length=30)
//	private int tempsAvantRecolteEnMois; 
//	
//	@Column(name ="poidsMoyenFruitEnG", length=30)
//	private int poidsMoyenFruitEnG; 
//	
//	@Column(name ="conseilDeCulture", length=255)
//	private String conseilDeCulture; 
//	
//	
//	protected Set<Inconvenients> Inconvenients;
//	
//	protected Set<Avantages> Avantages;
//	
//	
//	public Fruits(UUID idFruit, int tempsAvantRecolteEnMois, int poidsMoyenFruitEnG, String conseilDeCulture, int tempsAvantPremiereRecolteEnAnnee, int hauteurMaxEnMetre)
//	{
//		this.idFruit = idFruit;
//		this.tempsAvantRecolteEnMois = tempsAvantRecolteEnMois;
//		this.poidsMoyenFruitEnG = poidsMoyenFruitEnG;
//		this.conseilDeCulture = conseilDeCulture;
//		this.tempsAvantPremiereRecolteEnAnnee =tempsAvantPremiereRecolteEnAnnee;
//		this.hauteurMaxEnMetre = hauteurMaxEnMetre;
//		
//		
//		
//	}
//	public int getTempsAvantPremiereRecolteEnAnnee() {
//		return tempsAvantPremiereRecolteEnAnnee;
//	}
//	public void setTempsAvantPremiereRecolteEnAnnee(int tempsAvantPremiereRecolteEnAnnee) {
//		this.tempsAvantPremiereRecolteEnAnnee = tempsAvantPremiereRecolteEnAnnee;
//	}
//	public int getHauteurMaxEnMetre() {
//		return hauteurMaxEnMetre;
//	}
//	public void setHauteurMaxEnMetre(int hauteurMaxEnMetre) {
//		this.hauteurMaxEnMetre = hauteurMaxEnMetre;
//	}
////	public Set<Inconvenients> getSeteInconvenients() {
////		return SeteInconvenients;
////	}
////
////	public void setSeteInconvenients(Set<Inconvenients> SeteInconvenients) {
////		this.SeteInconvenients = SeteInconvenients;
////	}
////
////	public Set<Avantages> getSeteAvantages() {
////		return SeteAvantages;
////	}
////
////	public void setSeteAvantages(Set<Avantages> SeteAvantages) {
////		this.SeteAvantages = SeteAvantages;
////	}
//	
//}