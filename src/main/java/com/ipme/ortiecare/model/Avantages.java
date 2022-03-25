package com.ipme.ortiecare.model;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Avantages")
public class Avantages {
	
	@Id
	@Column(name = "idAvantage", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID idAvantage;
	
	@Column(name ="description", length=255)
	private String description;

	public Avantages(UUID id, String description) {

		this.idAvantage = id;
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UUID getId() {
		return this.idAvantage;
	}

}
