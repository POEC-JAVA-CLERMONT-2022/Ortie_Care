package com.ipme.ortiecare.model;

import java.util.*;
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
	private Sols bestSol;
	
	@JoinColumn(name="idLegume")
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Legumes> legumesConcerne;

	public Culture (UUID idCulture, String descCulture, Sols bestSol, Set<Legumes> legumeConcerne)
	{
		this.idCulture = idCulture;
		this.descCulture = descCulture;
		this.bestSol=bestSol;
		this.legumesConcerne = legumeConcerne;
	}
	
	public Set<Legumes> getPlantationConcernee() {
		return legumesConcerne;
	}

	public void setPlantationConcernee(Set<Legumes> legumesConcerne) {
		this.legumesConcerne = legumesConcerne;
	}

	public Sols getBestSoil() {
		return bestSol;
	}

	public void setBestSoil(Sols bestSoil) {
		this.bestSol = bestSoil;
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