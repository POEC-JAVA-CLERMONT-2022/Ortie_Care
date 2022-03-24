package com.ipme.ortiecare.model;

import java.util.UUID;
import javax.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "Cultures")
public class Culture {
	
	@Id
	@Column(name="idCulture", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID idCulture;
	
	@Column(name="descCulture", length=255)
	private String descCulture;

	@JoinColumn(name="idSol")
	@ManyToOne(fetch=FetchType.EAGER)
	private Sols bestSoil;
	
	@JoinColumn(name="idPlantation")
	@ManyToOne(fetch=FetchType.EAGER)
	private Plantation plantationConcernee;
	
	public Culture (UUID idCulture, String descCulture, Sols bestSoil, Plantation plantationConcernee)
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

	public UUID getIdCulture() {
		return idCulture;
	}

	public void setIdCulture(UUID idCulture) {
		this.idCulture = idCulture;
	}
}